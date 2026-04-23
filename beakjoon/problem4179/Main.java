import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] raze = new int[n][m];
        int[] nx = new int[]{-1,1,0,0};
        int[] ny = new int[]{0,0,-1,1};

        int time = 0;
        scan.nextLine();
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean isEscape = false;
        for(int i=0;i<n;i++){
            String str = scan.nextLine();
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='#') raze[i][j] = -1;
                else if(str.charAt(j)=='J') {
                    q.addLast(new Point(i,j,0,2));
                    raze[i][j] = 2;
                }
                else if(str.charAt(j)=='F') {
                    q.addFirst(new Point(i,j,0,1));
                    raze[i][j] = 1;
                }
            }
        }
        while (!q.isEmpty()){
            Point point = q.poll();
            if(isEscape) break;
            for(int i=0;i<4;i++){
                int x = point.x+nx[i];
                int y = point.y+ny[i];
                if(x>=n||x<0||y>=m||y<0){
                    if(point.type == 2){
                        System.out.println(point.time+1);
                        isEscape = true;
                        break;
                    }
                }
                else if(raze[x][y]==0){
                    raze[x][y] = point.type;
                    q.add(new Point(x,y, point.time+1, point.type));
                }

            }
        }
        if (!isEscape) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static class Point{
        int x,y,time,type;
        public Point(int x,int y,int time, int type){
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    }
}
