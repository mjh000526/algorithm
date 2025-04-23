import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    static int maxWeigth = 0;
    static int firstFindNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        tree = new ArrayList[v+1];
        for(int i=1;i<=v;i++) tree[i] = new ArrayList<>();
        visited = new boolean[v+1];
        int firstVisitNode = 0;
        for(int i=0;i<v;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int y = Integer.parseInt(st.nextToken());
                if(y==-1) break;
                if(firstVisitNode==0) firstVisitNode = x;
                int w = Integer.parseInt(st.nextToken());
                tree[x].add(new int[]{y,w});
            }
        }
        visited[firstVisitNode] = true;
        dfs(firstVisitNode,v,0);
        visited[firstVisitNode] = false;
        maxWeigth=0;

        visited[firstFindNode] = true;
        dfs(firstFindNode,v,0);

        System.out.println(maxWeigth);
    }

    static void dfs(int x,int v,int cnt){
        if(x>v||x<1) return;
        if(cnt>maxWeigth){
            maxWeigth=cnt;
            firstFindNode = x;
        }
        for(int i=0;i<tree[x].size();i++){
            int[] arr = tree[x].get(i);
            int y = arr[0];
            int w = arr[1];
            if(!visited[y]){
                visited[y] = true;
                dfs(y,v,cnt+w);
                visited[y] = false;
            }
        }
    }
}
