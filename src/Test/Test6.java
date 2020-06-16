package Test;

//public class Test6 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        //价格
//        int a[] = {2, 2, 3, 1, 5, 2};
//        //数量
//        int b[] = {2, 3, 1, 5, 4, 3};
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        for(int j = 0; j < a.length; j++) {
//            for(int i = n; i > 0; i--){
//                if(i >= a[j]){
//                    dp[i] = Math.max(dp[i], dp[i - a[j]] + b[j]);
//                    System.out.println(dp[i]);
//                }
//            }
//        }
//
//
//        System.out.println(dp[n]);
//    }
//}
//



//public class Test6 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        //大根堆
//        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
////        int[] a = new int[n];
//        for(int i = 0; i < n; i++){
//            int num = scanner.nextInt();
//            priorityQueue1.add(num);
//        }
//        int ans = 0;
//        while(!priorityQueue1.isEmpty() && priorityQueue1.peek() >= n){
//            int num = priorityQueue1.poll();
//            priorityQueue2.add(num - n);
//            ans ++;
//            while(!priorityQueue1.isEmpty()){
//                priorityQueue2.add(priorityQueue1.poll() + 1);
//            }
//            while(!priorityQueue2.isEmpty()){
//                priorityQueue1.add(priorityQueue2.poll());
//            }
//        }
//        System.out.println(ans);
//    }
//}

//static int get_gcd(int a, int b){
//        if(a == b){
//        return a;
//        }
//        while(a != b){
//        if(a > b){
//        a = a - b;
//        }else{
//        b = b - a;
//        }
//        }
//        return a;
//        }
//static int get_lcm(int a, int b, int gcd){
//        return  a * b / gcd;
//        }
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Test6 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        boolean flag = true;
//        long last = -1, curr;
//        long[] diff = new long[n - 1];
//        last = scanner.nextLong();
//        for(int i = 1; i < n; i++){
//            curr = scanner.nextLong();
//            if(curr <= last){
//                flag = false;
//            }else{
//                diff[i - 1] = curr - last;
//                last = curr;
//            }
//        }
//        if(!flag){
//            System.out.println(-1);
//        }else{
//            Arrays.sort(diff);
//            flag = true;
//            long ans = diff[0];
//            while(ans > 0){
//                for(int i = 0; i < n - 1; i++){
//                    if(diff[i] % ans != 0){
//                        flag = false;
//                        break;
//                    }
//                }
//                if(!flag){
//                    flag = true;
//                    ans --;
//                }else{
//                    break;
//                }
//            }
//            ans = ans == 0 ? -1 : ans;
//            System.out.println(ans);
//        }
//
//    }
//}

//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class Test6 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int d = scanner.nextInt();
//        int ans = 0;
//        int[][] a = new int[n][2];
//        for(int i = 0; i < n; i++){
//            a[i][0] = scanner.nextInt();
//        }
//        for(int i = 0; i < n; i++){
//            a[i][1] = scanner.nextInt();
//        }
//        Arrays.sort(a, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1] - o2[1];
//                }
//                return o2[0] - o1[0];
//            }
//        });
//        for(int i = 0; i < n; i++){
//            if(d > a[i][0]){
//                d++;
//            }else{
//                ans += a[i][1];
//                d++;
//            }
//        }
//        System.out.println(ans);
//    }
//}

import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] a= new int[m][n];
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            String string = scanner.nextLine();
            for(int j = string.length() - 1; j >= 0; j--){
                a[i][string.length() - j - 1] = string.charAt(j) - '0';
            }
        }
        for(int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i - 1][j - 1] == 0){
                    dp[i][j] = 0;
                }else{
                    if((j < n && a[i - 1][j] == 0) || (i < m && a[i][j - 1] == 0) ){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j]);
                if(j != n){
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("test git");
    }
}
