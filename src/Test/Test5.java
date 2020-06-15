package Test;

import java.util.HashMap;

public class Test5 {
    //判断字符串匹配问题
    public static boolean stringPattern(String pattern, String string){
        //任意一个为空则一定是不匹配的
        if(pattern == null || string == null){
            return false;
        }
        //以空格为界进行切分
        String[] word = string.split(" ");
//        for(String s : word){
//            System.out.println(s);
//        }
        //判断长度，长度不同也肯定是不匹配的
        if(pattern.length() != word.length){
            return false;
        }
        //此时长度相同，同时遍历pattern和字符串数组，利用hashmap保存第一次的对应关系
        HashMap<Character, String> mymap = new HashMap<>();
        int len = pattern.length();
        for(int i = 0; i < len; i++){
            char ch = pattern.charAt(i);
            if(!mymap.containsKey(ch)){
                //此时不存在，则将字符串数组中相应位置的字符串存入hashmap
                mymap.put(ch, word[i]);
            }else{
                //此时表示hashmap中存在，此时看字符串数组相应位置的字符串是否和hashmap中存储的相等，这里用equals判断
                //不相等，直接返回false
                if(!word[i].equals(mymap.get(ch))){
                    return false;
                }
            }
        }
        //遍历完成也没有遇到不匹配的，直接返回true
        return true;
    }
    public static void main(String[] args) {
        /*
        用例1
        String pattern = "abba";
        String str = "北京 杭州 杭州 北京";  //true

        用例2
        String pattern = "aabb";
        String str = "北京 杭州 杭州 北京";  //false

        用例3
        String pattern = "baab";
        String str = "北京 杭州 杭州 北京"; //true
         */
        String pattern = "baab";
        String str = "北京 杭州 杭州 南京"; //false
        System.out.println("匹配：" + stringPattern(pattern, str));
    }
}
