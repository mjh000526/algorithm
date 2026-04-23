import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] students;
    static boolean[] visited;
    static boolean[] cycle;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        students = new int[t][];
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            students[i]=new int[n+1];
            for(int j=1;j<=n;j++){
                students[i][j] = Integer.parseInt(st.nextToken());
            }
            sum = 0;
            visited = new boolean[students[i].length+1];
            cycle = new boolean[students[i].length+1];
            for(int j=1;j<students[i].length;j++){
                if(cycle[j]) continue;
                dfs(i,j);
            }
            bw.write((students[i].length- 1 - sum)+"\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int i, int x){
        if(visited[x]) {
            sum++;
            cycle[x] = true;
        }
        visited[x] = true;

        if(!cycle[students[i][x]]) dfs(i,students[i][x]);
        visited[x] = false;
        cycle[x] = true;
    }
}
