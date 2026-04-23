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

    static int[][] room;
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    static int vi = 0;
    static int wall = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        room = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                room[i][j] = scan.nextInt();
                if(room[i][j]==2) vi++;
                if(room[i][j]==1) wall++;
            }
        }
        dfs(n,m,0);
        System.out.println((n*m)-min-wall-3);
    }

    static void dfs(int n,int m,int cnt){
        if(cnt==3){
            bfs(n,m);
        }
        else {
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(room[i][j]==0&&visit[i][j]==false) {
                        visit[i][j] = true;
                        dfs(n, m, cnt + 1);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }

    static void bfs(int n,int m){
        Queue<Point> q = new LinkedList<>();
        int[][] viRoom = new int[n][m];
        int viCnt = vi;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                viRoom[i][j] = room[i][j];
                if(room[i][j]==2) q.add(new Point(i,j));
                if(visit[i][j]==true) viRoom[i][j] = 1;
            }
        }
        while (!q.isEmpty()){
            Point p = q.poll();
            int px = (int) p.getX();
            int py = (int) p.getY();
            if(px>0&&viRoom[px-1][py]==0){
                q.add(new Point(px-1,py));
                viRoom[px-1][py]=2;
                viCnt++;
            }
            if(px<n-1&&viRoom[px+1][py]==0){
                q.add(new Point(px+1,py));
                viRoom[px+1][py]=2;
                viCnt++;
            }
            if(py>0&&viRoom[px][py-1]==0){
                q.add(new Point(px,py-1));
                viRoom[px][py-1]=2;
                viCnt++;
            }
            if(py<m-1&&viRoom[px][py+1]==0){
                q.add(new Point(px,py+1));
                viRoom[px][py+1]=2;
                viCnt++;
            }
        }
//        if(min>viCnt){
//            for (int i=0;i<n;i++){
//                for(int j=0;j<m;j++){
//                    System.out.print(viRoom[i][j]);
//                }
//                System.out.println();
//            }
//        }
//        System.out.println("============");
        min = Integer.min(min,viCnt);
    }


}
