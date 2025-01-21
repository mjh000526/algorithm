import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args){
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int[][] distance = new int[maps.length][maps[0].length];
        q.add(new Pair(0,0));
        visit[0][0]=true;
        distance[0][0]=1;
        while (!q.isEmpty()){
            Pair pair = q.poll();
            for(int i=0;i<4;i++){
                if(pair.x+dx[i] == maps.length || pair.x+dx[i]<0 ||pair.y+dy[i]==maps[0].length || pair.y+dy[i]<0) continue;
                else if(!visit[pair.x+dx[i]][pair.y+dy[i]]&&maps[pair.x+dx[i]][pair.y+dy[i]]!=0){
                    visit[pair.x+dx[i]][pair.y+dy[i]] = true;
                    q.add(new Pair(pair.x+dx[i],pair.y+dy[i]));
                    distance[pair.x+dx[i]][pair.y+dy[i]] = distance[pair.x][pair.y]+1;
                }
            }
        }

        return distance[distance.length-1][distance[0].length-1] == 0 ? -1 : distance[distance.length-1][distance[0].length-1];
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
