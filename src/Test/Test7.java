package Test;

public class Test7 {
    public static void main(String[] args) {
        String str = "dabcab";
        int[] cnt = new int[26];
        for(int i = 0; i < str.length(); i++){
            cnt[str.charAt(i) - 'a']++;
            //hhhh
        }
        for(int i = 0; i < 26; i++){
            if(cnt[i] != 0){
                char ch = (char)(i + 'a');
                System.out.print(ch + cnt[i]);
                System.out.println("hello world");
            }
        }
    }
}
