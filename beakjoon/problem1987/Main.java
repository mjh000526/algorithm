import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Character, Integer> map = new HashMap<>();
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int n;
    static int m;
    static int[] dy = {0,0,1,-1};
    static int max = 0;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            list.add(br.readLine());
        }
        dfs(0,0,0);
        System.out.println(max);
    }

    static void dfs(int x,int y,int cnt){
        if(x>=n||y>=m||x<0||y<0) return;
        if(map.containsKey(list.get(x).charAt(y))||visited[x][y]){
            return;
        }

        cnt++;
        max = Math.max(max,cnt);
        visited[x][y]=true;
        map.put(list.get(x).charAt(y),0);
        for(int i=0;i<4;i++){
            dfs(x+dx[i],y+dy[i],cnt);
        }
        map.remove(list.get(x).charAt(y));
        visited[x][y]=false;
    }
}
