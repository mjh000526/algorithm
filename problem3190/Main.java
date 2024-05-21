import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] board = new int[n+1][n+1];
        int dir = 1;
        Deque<Point> deque = new ArrayDeque<>();
        int cnt = 0;
        int m = scan.nextInt();
        Queue<Pair> lot = new LinkedList<>();
        for(int i=0;i<m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            board[y-1][x-1] = 1;
        }
        m = scan.nextInt();
        for(int i=0;i<m;i++){
            int key = scan.nextInt();
            String value = scan.next();
            lot.add(new Pair(key,value.charAt(0)));
        }
        deque.addFirst(new Point(0,0));
        board[0][0] = 2;
        Pair pair = lot.poll();
        int move_x=0,move_y=0;
        while (true){
            cnt++;
            switch (dir%4){
                case 1:move_x+=1;
                    break;
                case 2: move_y+=1;
                    break;
                case 3: move_x-=1;
                    break;
                case 0: move_y-=1;
            }
            if(move_x == n||move_y==n||move_y<0||move_x<0||board[move_x][move_y]==2) break;
            deque.addFirst(new Point(move_x,move_y));
            if(board[move_x][move_y]!=1){
                Point p = deque.pollLast();
                board[(int) p.getX()][(int) p.getY()] = 0;
            }
            if(pair != null && pair.key==cnt){
                if(pair.value=='D') dir+=1;
                else dir-=1;
                if(dir == -1) dir=3;
                if(!lot.isEmpty()) pair = lot.poll();
                else if(lot.isEmpty()) pair = null;
            }
            board[move_x][move_y] = 2;
        }
        System.out.println(cnt);
    }
    static class Pair{
        public int key;
        public char value;
        public Pair(int key,char value){
            this.key = key;
            this.value = value;
        }
    }



}
