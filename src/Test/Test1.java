package Test;

import java.util.HashMap;

//测试用例
/*
String s1 = "    ";
String s2 = "a";

String s1 = "";
String s2 = "";

String s1 = "Thank you for your time";
String s2 = "to complete the question";
 */

public class Test1 {
    static String getUnion(String s1, String s2){

        //特例
        if(s1.length() == 0){
            return s2;
        }
        if(s2.length() == 0){
            return s1;
        }
        //此时两者皆不为空
        StringBuilder s = new StringBuilder(s1 + s2);
        //使用hashmap保存字符串中所有字符第一次出现的位置
        //从前往后遍历
        HashMap<Character, Integer> mymap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!mymap.containsKey(s.charAt(i))){
                mymap.put(s.charAt(i), i);
            }
        }
        //s从后往前遍历，去重
        for(int i = s.length() - 1; i >= 0; i--){
            if(mymap.get(s.charAt(i)) != i){
                s.deleteCharAt(i);
            }
        }
        String str0 = "aa";
        String str1 = new String("aa");

        System.out.println(str0 == str1);
        return s.toString();
    }

    public static void main(String[] args) {
        String s1 = "Thank you for your time";
        String s2 = "to complete the question";
        System.out.println(getUnion(s1, s2));
        System.out.println("abc".compareTo("bc"));
    }
}
