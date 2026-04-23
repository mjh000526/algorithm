import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] nx = {-1,1,0,0};
    static int[] ny = {0,0,1,-1};
    static int[][] map;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        map = new int[n+1][m+1];
        scan.nextLine();
        for(int i=1;i<=n;i++){
            String num = scan.nextLine();
            for(int j=1;j<=m;j++){
                map[i][j]=num.charAt(j-1)-48;
            }
        }
        int result = bfs(n,m);
        System.out.println(result==Integer.MAX_VALUE ? -1:result);
    }
    public static int bfs(int n,int m){
        ArrayDeque<Point> q =new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n+1][m+1];
        boolean[][] brokenVisited = new boolean[n+1][m+1];
        visited[1][1] = true;

        q.add(new Point(1,1,1,false));
        while (!q.isEmpty()){
            Point p = q.poll();
            //좌표크기
            if(p.x==n&&p.y==m) {
                result = Math.min(result,p.cnt);
                break;
            }


            for(int i=0;i<4;i++){
                if(p.x+nx[i]<1||p.x+nx[i]>n||p.y+ny[i]<1||p.y+ny[i]>m) continue;
                if(map[p.x+nx[i]][p.y+ny[i]]==1&&p.broken) continue;
                else if(map[p.x+nx[i]][p.y+ny[i]]==1&&!brokenVisited[p.x+nx[i]][p.y+ny[i]]&&!p.broken){
                    q.add(new Point(p.x+nx[i],p.y+ny[i],p.cnt+1,true));
                    brokenVisited[p.x+nx[i]][p.y+ny[i]]=true;
                }
                else if(map[p.x+nx[i]][p.y+ny[i]]==0&&!brokenVisited[p.x+nx[i]][p.y+ny[i]]&&p.broken){
                    q.add(new Point(p.x+nx[i],p.y+ny[i],p.cnt+1,true));
                    brokenVisited[p.x+nx[i]][p.y+ny[i]]=true;
                }
                else if(map[p.x+nx[i]][p.y+ny[i]]==0&&!visited[p.x+nx[i]][p.y+ny[i]]&&!p.broken){
                    q.add(new Point(p.x+nx[i],p.y+ny[i],p.cnt+1,false));
                    visited[p.x+nx[i]][p.y+ny[i]]=true;
                }

            }
        }
        return result;
    }

    static class Point{
        int x,y,cnt;
        boolean broken;
        public Point(int x,int y,int cnt, boolean broken){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.broken = broken;
        }
    }
}
