import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[][] board = new int[101][101];
        int n = scan.nextInt();
        List<Pair> first = new ArrayList<>();
        List<Pair> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dir = scan.nextInt();
            int g = scan.nextInt();
            first.add(new Pair(x,y,dir,g));
        }
        for(int i=0;i<n;i++){
            graph = new ArrayList<>();
            graph.add(first.get(i));
            board[first.get(i).x][first.get(i).y]=i+1;
            graph.add(direction(first.get(i).x,first.get(i).y,first.get(i).dir));
            board[graph.get(graph.size()-1).x][graph.get(graph.size()-1).y]=i+1;
            for(int j=1;j<=first.get(i).g;j++){
                int cnt = graph.size();
                Stack<Integer> cal = new Stack<>();
                for(int x=1;x<cnt;x++){
                    int d = graph.get(x).dir+1 != 4 ? graph.get(x).dir+1 : 0;
                    cal.push(d);
                }
                while (!cal.isEmpty()){
                    graph.add(direction(graph.get(graph.size()-1).x,
                            graph.get(graph.size()-1).y,cal.pop()));
                    board[graph.get(graph.size()-1).x][graph.get(graph.size()-1).y]=i+1;
                }
            }
        }
        int cnt =0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(board[i][j]!=0&&board[i+1][j]!=0&&board[i][j+1]!=0&&board[i+1][j+1]!=0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    static Pair direction(int x,int y,int dir){
        if(dir == 0){
            x+=1;
        }
        else if(dir == 1){
            y-=1;
        }
        else if(dir == 2){
            x-=1;
        }
        else if(dir == 3){
            y+=1;
        }

        return new Pair(x,y,dir,0);
    }

    static class Pair{
        int x;
        int y;
        int dir;
        int g;
        public Pair(int x,int y,int dir,int g){
            this.x=x;
            this.y = y;
            this.dir = dir;
            this.g = g;

        }
    }

}