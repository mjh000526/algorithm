import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] graph = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> {
            return o1[0]-o2[0];
        });
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],-1);
        }
        for(int i=0;i<m;i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            int weight = scan.nextInt();
            graph[start][end] = graph[start][end]==-1 ? weight : Math.min(graph[start][end],weight);

        }
        int start = scan.nextInt();
        int end = scan.nextInt();
        dist[start]=0;

        q.add(new int[]{0,start});
        while (!q.isEmpty()){
            int[] node = q.poll();
            visited[start]=true;
            int index = node[1];
            int cost = node[0];
            if(index==end) break;
            for(int i=1;i<=n;i++){
                if(graph[index][i]!=-1&&graph[index][i]+cost<dist[i]){
                    dist[i]=graph[index][i]+cost;
                    q.add(new int[]{dist[i],i});
                }
            }
        }
        System.out.println(dist[end]);
    }

}
