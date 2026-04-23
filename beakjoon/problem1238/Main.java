import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int partyPoint = scan.nextInt();
        int[][] graph = new int[n+1][n+1];
        int[][] reverseGraph = new int[n+1][n+1];
        int[] dist = new int[n+1];
        int[] reverseDist = new int[n+1];
        int result = 0;

        for(int i=1;i<=n;i++){
            Arrays.fill(dist,100000000);
            Arrays.fill(reverseDist,100000000);
        }
        dist[partyPoint]=0;
        reverseDist[partyPoint]=0;
        PriorityQueue<Edge> q = new PriorityQueue<>((q1,q2) -> {
           return q1.weight-q2.weight;
        });
        for(int i=0;i<m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();
            graph[x][y] = w;
            reverseGraph[y][x] = w;
        }

        q.add(new Edge(partyPoint,0));
        while (!q.isEmpty()){
            Edge edge = q.poll();
            for(int i=1;i<=n;i++){
                if(graph[edge.index][i]==0)continue;
                int road = edge.weight+graph[edge.index][i];
                if(road<dist[i]){
                    dist[i]=road;
                    q.add(new Edge(i,road));
                }
            }
        }
        q.add(new Edge(partyPoint,0));
        while (!q.isEmpty()){
            Edge edge = q.poll();
            for(int i=1;i<=n;i++){
                if(reverseGraph[edge.index][i]==0)continue;
                int road = edge.weight+reverseGraph[edge.index][i];
                if(road<reverseDist[i]){
                    reverseDist[i]=road;
                    q.add(new Edge(i,road));
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(i==partyPoint) continue;

            result = Math.max(result,dist[i]+reverseDist[i]);

        }
        System.out.println(result);
    }

    static class Edge{
        int index,weight;
        public Edge(int inedx,int weight){
            this.index = inedx;
            this.weight = weight;
        }
    }
}
