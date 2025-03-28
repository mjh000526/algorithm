import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int h = scan.nextInt();
        int tmtCnt = n*m*h;
        int totalTmt = 0;
        int maxDate = 0;
        int[][][] box = new int[h][m][n];
        ArrayDeque<Tomato> q = new ArrayDeque<>();
        //입력
        for(int x=0;x<h;x++){
            for(int y=0;y<m;y++){
                for(int z=0;z<n;z++){
                    box[x][y][z] = scan.nextInt();
                    if(box[x][y][z]==-1) tmtCnt--;
                    else if (box[x][y][z]==1){
                        q.add(new Tomato(x,y,z,0));
                        box[x][y][z]=0;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Tomato tmt = q.poll();
            if(box[tmt.x][tmt.y][tmt.z]==1) continue;
            if(tmt.x+1<h&&box[tmt.x+1][tmt.y][tmt.z]==0) q.add(new Tomato(tmt.x+1,tmt.y,tmt.z,tmt.date+1));
            if(tmt.x>0&&box[tmt.x-1][tmt.y][tmt.z]==0) q.add(new Tomato(tmt.x-1,tmt.y,tmt.z,tmt.date+1));
            if(tmt.y+1<m&&box[tmt.x][tmt.y+1][tmt.z]==0) q.add(new Tomato(tmt.x,tmt.y+1,tmt.z,tmt.date+1));
            if(tmt.y>0&&box[tmt.x][tmt.y-1][tmt.z]==0) q.add(new Tomato(tmt.x,tmt.y-1,tmt.z,tmt.date+1));
            if(tmt.z+1<n&&box[tmt.x][tmt.y][tmt.z+1]==0) q.add(new Tomato(tmt.x,tmt.y,tmt.z+1,tmt.date+1));
            if(tmt.z>0&&box[tmt.x][tmt.y][tmt.z-1]==0) q.add(new Tomato(tmt.x,tmt.y,tmt.z-1,tmt.date+1));
            box[tmt.x][tmt.y][tmt.z]=1;
            totalTmt++;
            maxDate = Math.max(maxDate,tmt.date);
        }
        if (totalTmt == tmtCnt) {
            System.out.println(maxDate);
        } else {
            System.out.println(-1);
        }

    }
    public static class Tomato{
        int x,y,z,date;
        Tomato(int x,int y,int z,int date){
            this.x = x;
            this.y = y;
            this.z = z;
            this.date = date;
        }
    }

}
