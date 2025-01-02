import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static boolean[][] redGreenMap;
    static boolean[][] redBlueMap;
    static char[][] graph;
    static char[][] redBlueGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        redGreenMap = new boolean[n][n];
        redBlueMap = new boolean[n][n];
        int redGreenCnt = 0;
        int redBlueCnt = 0;
        graph = new char[n][n];
        redBlueGraph = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            for(int j=0;j<n;j++){
                graph[i][j]=str.charAt(j);
                if(str.charAt(j)=='G'){
                    redBlueGraph[i][j]='R';
                }
                else redBlueGraph[i][j]=str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++){
                if(!redGreenMap[i][j]) {
                    redGreenDfs(i,j,graph[i][j],n-1);
                    redGreenCnt++;
                }
                if(!redBlueMap[i][j]) {
                    redBlueDfs(i,j,redBlueGraph[i][j],n-1);
                    redBlueCnt++;
                }
            }
        }

        System.out.println(redGreenCnt + " " + redBlueCnt);

    }

    static void redGreenDfs(int x,int y, char color, int n){
        if(x>n||y>n||x<0||y<0) return;
        else if(graph[x][y]!=color) return;
        else if(redGreenMap[x][y]==true) return;
        redGreenMap[x][y] = true;
        redGreenDfs(x+1,y,color,n);
        redGreenDfs(x,y+1,color,n);
        redGreenDfs(x-1,y,color,n);
        redGreenDfs(x,y-1,color,n);
    }

    static void redBlueDfs(int x,int y, char color,int n){
        if(x>n||y>n||x<0||y<0) return;
        else if(redBlueGraph[x][y]!=color) return;
        else if(redBlueMap[x][y]==true) return;
        redBlueMap[x][y] = true;
        redBlueDfs(x+1,y,color,n);
        redBlueDfs(x,y+1,color,n);
        redBlueDfs(x-1,y,color,n);
        redBlueDfs(x,y-1,color,n);
    }
}

