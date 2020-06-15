package SocketTest;

import java.util.*;
class Node{
    int x;
    int y;
    Node(){
        x = 0;
        y = 0;
    }
}
public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Node, List<Integer>> mymap = new HashMap<>();
        for(int i = 0; i < m; i++){
            int k = sc.nextInt();
            for(int j = 0; j < k; j++){
                Node node = new Node();
                node.x = sc.nextInt();
                node.y = sc.nextInt();
                List<Integer> list = mymap.getOrDefault(node, new ArrayList<Integer>());
                list.add(i + 1);
                mymap.put(node, list);
            }
        }
        //遍历hashmap
        Iterator it  = mymap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            Node node = (Node)entry.getKey();
            List<Integer> list = (List<Integer>)entry.getValue();
            System.out.println(node.x + " " + node.y + " " + list);
        }
    }
}