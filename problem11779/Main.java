import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] city = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            Arrays.fill(city[i],100000000);
        }
        Arrays.fill(dist,100000000);
        for(int i=0;i<m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();
            city[x][y] = Math.min(city[x][y],w);
        }
        int startCity = scan.nextInt();
        int endCity = scan.nextInt();
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing((o)-> {
            return o.w;
        }));
        dist[startCity] = 0;

        q.add(new Point(startCity,0));

        while (!q.isEmpty()){
            Point point = q.poll();
            if(visited[point.y]) continue;
            visited[point.y] = true;
            for(int i=1;i<=n;i++){
                int weight = city[point.y][i]+point.w;
                if(weight<dist[i]){
                    q.add(new Point(i,weight,point.list));
                    dist[i] = weight;
                    if(i==endCity) {
                        resultList = new ArrayList<>(point.list);
                        resultList.add(i);
                    }

                }
            }
        }
        System.out.println(dist[endCity]);
        System.out.println(resultList.size());
        for(int i=0;i<resultList.size();i++){
            System.out.print(resultList.get(i) + " ");
        }
    }

    static class Point {
        int y,w;
        ArrayList<Integer> list;
        public Point(int y,int w){
            this.y = y;
            this.w = w;
            this.list = new ArrayList<>();
            this.list.add(y);
        }
        public Point(int y,int w,ArrayList<Integer> list){
            this.y = y;
            this.w = w;
            this.list = new ArrayList<>(list);
            this.list.add(y);
        }

    }
}
