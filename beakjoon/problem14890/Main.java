import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] board = new int[n][n];
        int[][] visit = new int[n][n];
        int l = scan.nextInt();
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = scan.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            boolean road = true;
            for(int j=1;j<n;j++){
                if(board[i][j]>board[i][j-1]&&Math.abs(board[i][j]-board[i][j-1])==1){
                    if(j<l){
                        road=false;
                        break;
                    }
                    for(int x = j-l;x<j;x++){
                        if(visit[i][x]==1||board[i][x]!=board[i][j-1]) {
                            road = false;
                            break;
                        }
                        visit[i][x]=1;
                    }
                }
                else if(board[i][j]<board[i][j-1]&&Math.abs(board[i][j]-board[i][j-1])==1){
                    if(j+l-1>=n){
                        road=false;
                        break;
                    }
                    for(int x = j;x<j+l;x++){
                        if(board[i][x]!=board[i][j]||visit[i][x]==1) {
                            road = false;
                            break;
                        }
                        visit[i][x]=1;
                    }
                }
                else if(Math.abs(board[i][j]-board[i][j-1])>1) road=false;
                if(road==false){
                    break;
                }
            }
            if(road==true){
//                System.out.println("i = " + i);
//                for(int j=0;j<n;j++){
//                    System.out.print(visit[i][j] +" ");
//                }
//                System.out.println("\n=================");
                cnt++;
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(visit[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("========================");
        for(int j=0;j<n;j++){
            boolean road = true;
            for(int i=1;i<n;i++){
                if(board[i][j]>board[i-1][j]&&Math.abs(board[i][j]-board[i-1][j])==1){
                    if(i<l) {
                        road=false;
                        break;
                    }
                    for(int x = i-l;x<i;x++){
                        if(visit[x][j]==2||board[x][j]!=board[i-1][j]) {
                            road = false;
                            break;
                        }
                        visit[x][j]=2;
                    }
                }
                else if(board[i][j]<board[i-1][j]&&Math.abs(board[i][j]-board[i-1][j])==1){
                    if(i+l-1>=n){
                        road=false;
                        break;
                    }
                    for(int x = i;x<i+l;x++){
                        if(board[x][j]!=board[i][j]||visit[x][j]==2) {
                            road = false;
                            break;
                        }
                        visit[x][j]=2;
                    }
                } else if (Math.abs(board[i][j]-board[i-1][j])>1) {
                    road=false;
                }
                if(road==false){
                    break;
                }
            }
            if(road==true){
//                System.out.println("j = " + j);
//                for(int i=0;i<n;i++){
//                    System.out.print(visit[i][j] +" ");
//                }
//                System.out.println("\n=================");
                cnt++;
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(visit[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("===================");
        System.out.println(cnt);



    }


}