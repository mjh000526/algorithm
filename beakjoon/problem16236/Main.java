import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int time = 0;
        int remainFishCnt = 0;
        int sharkSize = 2;
        int eatingFish = 0;
        int[] nx = {-1,0,0,1};
        int[] ny = {0,-1,1,0};

        ArrayDeque<Point> q = new ArrayDeque<>();
        Point shark = null;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = scan.nextInt();
                if(map[i][j]==9) shark = new Point(i,j,0);
            }
        }
        q.add(shark);
        visited[shark.x][shark.y] = true;
        Point minPoint = new Point(201,201,0);
        int dist = 1000000;
        while(!q.isEmpty()) {
            Point p = q.poll();
            //상어가 먹을 수 있나?
            if(map[p.x][p.y]!=0&&map[p.x][p.y]<sharkSize&&p.weight<=dist) {


                //제일 작은거 찾기
                if(minPoint.x>p.x||(minPoint.x==p.x&&minPoint.y>p.y)){
                    dist = p.weight;
                    minPoint = new Point(p.x,p.y,p.weight);

                }

            }
            //상어가 못먹음
            for(int i=0;i<4;i++){
                if(p.x+nx[i]<0||p.y+ny[i]<0||p.x+nx[i]>=n||p.y+ny[i]>=n) continue;
                else if(sharkSize<map[p.x+nx[i]][p.y+ny[i]]) continue;
                else if(!visited[p.x+nx[i]][p.y+ny[i]]) {
                    visited[p.x+nx[i]][p.y+ny[i]]=true;
                    q.add(new Point(p.x+nx[i],p.y+ny[i],p.weight+1));
                }
            }

            if(q.isEmpty()&&minPoint.x!=201){
                //먹기
                eatingFish++;

                if (sharkSize == eatingFish) {
                    sharkSize++;
                    eatingFish = 0;
                }


                // time업데이트
                time += dist;
                // 상어위치업데이트
                map[minPoint.x][minPoint.y]=9;
                map[shark.x][shark.y] = 0;
                shark = new Point(minPoint.x, minPoint.y,0);
                q.add(shark);

                //visit초기화
                visited = new boolean[n][n];
                visited[shark.x][shark.y] = true;

                //비교값 초기화
                minPoint = new Point(201,201,0);
                dist=1000000;
//                for(int i=0;i<n;i++){
//                    for(int j=0;j<n;j++){
//                        if(map[i][j]==9)System.out.print("* ");
//                        else if(map[i][j]==0)System.out.print(". ");
//                        else System.out.print( map[i][j]+ " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println(time + "sec ====================");
            }
        }

        System.out.println(time);

    }
    static class Point{
        int x,y,weight;
        Point(int x,int y,int weight){
            this.x=x;
            this.y =y;
            this.weight =weight;
        }
    }
}
