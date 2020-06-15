package Test;

import java.util.Scanner;

public class Test4 {
    private static int ans = Integer.MAX_VALUE;
    static void dfs(String s, String t, int cnt){
        if(cnt > s.length()){
            return;
        }
        for(int i = 0; i < s.length() - 1; i++){
            //放到末尾
            char ch = s.charAt(i);
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            sb.append(ch);
            s = sb.toString();
            if(s.compareTo(t) == 0){
                ans = Math.min(ans, cnt + 1);
            }
            dfs(s, t, cnt + 1);
            //还原
            sb = new StringBuilder(s);
            sb.deleteCharAt(s.length() - 1);
            s = ch + sb.toString() ;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        if(s.compareTo(t) == 0){
            System.out.println(0);
        }else{
            dfs(s, t, 0);
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }
}
