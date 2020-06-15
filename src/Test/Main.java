package Test;//package Test;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main{
//    static int cnt = 0;
//    //翻转数组, 每x位反转一次
//    static int[] reverseArray(int[] a, int x){
////        //x==0 或者 x == 数组长度直接返回
////        if(x == 0 || x == a.length){
////            return a;
////        }
//
//        int times = a.length / x;
//        for(int i = 0; i < times; i ++){
//            for(int j = 0, k = x - 1; j < k; j++, k--){
//                //交换
//                int tmp = a[i * x + j];
//                a[i * x + j] = a[i * x + k];
//                a[i * x + k] = tmp;
//            }
//        }
//        return a;
//    }
//    //合并的同时统计数量
//    static void merge(int[] a, int start, int mid, int end){
//        //用于暂时保存数组的值（有序的），最后将这个数组的值赋值给原数组的相应部分
//        int[] tmp = new int[a.length];
//        //合并两个有序的升序数组
//        int i = mid, j = end, k = end;
//        while(i >= start && j >= mid + 1){
//            if(a[i] > a[j]){
//                //左边的比右边的大才统计
//                cnt += j - mid;
//                tmp[k] = a[i];
//                k--;
//                i--;
//            }else{
//                tmp[k] = a[j];
//                k--;
//                j--;
//            }
//        }
//
//        //将未复制完的
//        while(i >= start){
//            tmp[k] = a[i];
//            k--;
//            i--;
//        }
//        while(j >= mid + 1){
//            tmp[k] = a[j];
//            k--;
//            j--;
//        }
//
//        //将tmp数组赋值给a
//        for(int s = start; s <= end; s++){
//            a[s] = tmp[s];
//        }
//    }
//    //归并排序
//    static void mergeSort(int[] a, int start, int end){
//        //不断的将数组分割成两份
//        if(start < end){
//            int mid = (end - start) / 2 + start;
//            mergeSort(a, start, mid);
//            mergeSort(a, mid + 1, end);
//            merge(a, start, mid, end);
//        }
//    }
//    public static void main(String[] args){
//        Scanner scanner  = new Scanner(System.in);
//        int n = scanner.nextInt();
//        n = (int)Math.pow(2, n);
//        int[] a = new int[n];
//        //读取原数组
//        for(int i = 0; i < n; i++){
//            a[i] = scanner.nextInt();
//        }
//        int m = scanner.nextInt();
//        //读取反转的大小
//        for(int i = 0; i < m; i++){
//            int b = scanner.nextInt();
////            System.out.println(b);
//            a = reverseArray(a, (int)Math.pow(2, b));
//            int[] copyed = Arrays.copyOf(a, a.length);
//            cnt = 0;
//            mergeSort(copyed, 0, n - 1);
//            System.out.print(cnt);
//            if(i != m - 1){
//                System.out.print("\n");
//            }
//        }
//    }
//}

import java.util.*;
public class Main{
    private static LinkedList<Character> stack = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int len = str.length();
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(ch != ']'){
                stack.push(ch);
            }else{
                //此时遇到了']'
                //需要出栈，直到遇到第一个'['
                StringBuilder sb = new StringBuilder("");
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.append(stack.pop());
                }
                //'['pop掉
                stack.pop();
                //sb反转，然后处理出现的次数和要重复的字符串
                String tmp = sb.reverse().toString();
                int times = Integer.valueOf(tmp.substring(0, tmp.indexOf('|')));
                String repeatedStr = tmp.substring(tmp.indexOf('|') + 1);
                //重复的字符串按照times放入栈中
                for(int j = 0; j < times; j++){
                    for(int k = 0; k < repeatedStr.length(); k++){
                        stack.push(repeatedStr.charAt(k));
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.reverse().toString());
    }
}