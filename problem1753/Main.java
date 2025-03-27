import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int n = scan.nextInt();
        int start = scan.nextInt();
        final int INF = Integer.MAX_VALUE;

        int[] graph = new int[size+1];
        Arrays.fill(graph, INF);
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        if(size==1){
            System.out.println(0);
            return;
        }
        for(int i=0;i<n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();
            HashMap<Integer,Integer> node = map.getOrDefault(x,new HashMap<>());
            node.put(y,Math.min(node.getOrDefault(y,INF),w));
            map.put(x,node);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> (a[1]-b[1]));
        graph[start]=0;
        queue.add(new int[]{start,0});


        while(!queue.isEmpty()){
            int[] value = queue.poll();
            int index = value[0];
            int dist = value[1];
            if(dist < graph[index]) continue;
            HashMap<Integer,Integer> node = map.get(index);
            if(map.containsKey(index)){
                for(Integer key : map.get(index).keySet()){
                    int end = key;
                    int w = map.get(index).get(end);
                    if(graph[end]>dist +w){
                        graph[end] = dist + w;
                        queue.add(new int[]{end,graph[end]});
                    }
                }
            }
        }
        for(int i=1;i<=size;i++){
            if (graph[i] == INF) {
                System.out.println("INF");
            }
            else{
                System.out.println(graph[i]);
            }
        }

    }
}
