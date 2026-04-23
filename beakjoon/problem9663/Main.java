import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static boolean [][]board;
    static boolean []visit;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        board = new boolean[n][n];
        visit = new boolean[n];
        bfs(n,0,0);
        System.out.println(cnt);
    }
    public static void bfs(int n, int y,int depth){
        if(n==depth){
            cnt++;
            return;
        }
        for(int i=0;i<n;i++){
            if(board[i][y]==false){
                if(verti(n,i)&&hori(n,y)&&diag(n,i,y)){
                    board[i][y]=true;
                    bfs(n,y+1,depth+1);
                    board[i][y]=false;
                }
            }
        }
    }

    public static boolean verti(int n,int x){
        for(int i=0;i<n;i++){
            if(board[x][i]==true){
                return false;
            }
        }
        return true;
    }
    public static boolean hori(int n,int y){
        for(int i=0;i<n;i++){
            if(board[i][y]==true){
                return false;
            }
        }
        return true;
    }

    public static boolean diag(int n,int x,int y){
        int z = Math.abs(x-y);
        int sum = x+y;
        if(x<=y) {
            for(int i=0;i<n-z;i++){
                if(board[i][i+z]==true){
                    return false;
                }
            }
        }
        else if (x>y) {
            for(int i=0;i<n-z;i++){
                if(board[i+z][i]==true){
                    return false;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+j==sum){
                    if(board[i][j]==true) return false;
                }
            }
        }
        return true;
    }

}
