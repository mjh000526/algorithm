import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] nx = {-1,1,0,0};
        int[] ny = {0,0,1,-1};
        int[][] cheese = new int[n][m];
        int totalCheese = 0;
        int time = 0;
        Point p = null;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cheese[i][j]=scan.nextInt();
                if(cheese[i][j]==1) totalCheese++;
                else if(cheese[i][j]==0&&p==null) p = new Point(i,j);

            }
        }

        while (totalCheese!=0){
            int[][] visitedCheese = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            ArrayDeque<Point> q = new ArrayDeque<>();
            ArrayDeque<Point> removeQ = new ArrayDeque<>();
            q.add(p);
            while (!q.isEmpty()){
                Point curPoint = q.poll();
                int x = curPoint.x;
                int y = curPoint.y;
                for(int i=0;i<4;i++){
                    if(x+nx[i]<0||y+ny[i]<0||x+nx[i]>=n||y+ny[i]>=m) continue;
                    if(visited[x+nx[i]][y+ny[i]]) continue;
                    else if(cheese[x+nx[i]][y+ny[i]]==1) visitedCheese[x+nx[i]][y+ny[i]]++;
                    else if(cheese[x+nx[i]][y+ny[i]]==0) {
                        q.add(new Point(x+nx[i],y+ny[i]));
                        visited[x+nx[i]][y+ny[i]]=true;
                    }
                    if(visitedCheese[x+nx[i]][y+ny[i]]==2) removeQ.add(new Point(x+nx[i],y+ny[i]));
                }
            }
            while (!removeQ.isEmpty()){
                Point curPoint = removeQ.poll();
                cheese[curPoint.x][curPoint.y] = 0;
                totalCheese--;
            }
            time++;
        }
        System.out.println(time);



    }

    static class Point{
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
