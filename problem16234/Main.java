import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[]dx = {-1,1,0,0};
    static int[]dy = {0,0,-1,1};
    static int[][] population;
    static int[][] group;
    static boolean move = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int groupNum = 1;
        int day=0;
        population = new int[n][n];
        group = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            move=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(bfs(i,j,n,groupNum,l,r)){
                        groupNum++;
                    }
                }
            }
            group=new int[n][n];
            if(move==false){
                break;
            }
            day++;
        }

        System.out.println(day);

    }

    public static boolean bfs(int x,int y,int n, int num,int l,int r){
        if(group[x][y]!=0) return false;
        Queue<Pair> q = new ArrayDeque<>();
        List<Pair> list = new ArrayList<>();
        int sum = population[x][y];
        int groupSize = 1;
        q.add(new Pair(x,y));
        list.add(new Pair(x,y));
        group[x][y] = num;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            for(int i=0;i<4;i++){
                int nx = pair.x+dx[i];
                int ny = pair.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                int diff = Math.abs(population[pair.x][pair.y]-population[nx][ny]);
                if (group[nx][ny]==0&&diff>=l&&diff<=r) {
                    group[nx][ny]=num;
                    q.add(new Pair(nx,ny));
                    list.add(new Pair(nx,ny));
                    sum += population[nx][ny];
                    move=true;
                    groupSize++;
                }
            }
        }
        sum /=groupSize;
        for(int i=0;i<list.size();i++){
            Pair pair = list.get(i);
            population[pair.x][pair.y] = sum;

        }
        return true;
    }

    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
