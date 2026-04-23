import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int sum =0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        graph = new int[n][n];
        for(int i=0;i<n;i++){
            String s = scan.next();
            for(int j=0;j<n;j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==1){
                    sum++;
                    list.add(bfs(i,j,n));
                }
            }
        }
        System.out.println(sum);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    static int bfs(int x,int y,int size){
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        graph[x][y] = 0;
        while (!q.isEmpty()){
            Point p = q.poll();
            int px = (int) p.getX();
            int py = (int) p.getY();
            cnt++;
            if(px>0&&graph[px-1][py]==1){
                q.add(new Point(px-1,py));
                graph[px-1][py]=0;
            }
            if(px<size-1&&graph[px+1][py]==1){
                q.add(new Point(px+1,py));
                graph[px+1][py]=0;
            }
            if(py>0&&graph[px][py-1]==1){
                q.add(new Point(px,py-1));
                graph[px][py-1]=0;
            }
            if(py<size-1&&graph[px][py+1]==1){
                q.add(new Point(px,py+1));
                graph[px][py+1]=0;
            }
        }
        return cnt;
    }


}
