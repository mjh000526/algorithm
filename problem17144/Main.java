import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static int[] nx = {1,-1,0,0};
    final static int[] ny = {0,0,1,-1};
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        int time = scan.nextInt();
        int cleanY = 0;
        int[][] room = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int num = scan.nextInt();
                if(num>0){
                    room[i][j]=num;
                }
                if(num==-1){
                    //클리너위치
                    room[i][j]=num;
                    cleanY = Math.max(i,cleanY);
                }
            }
        }
        int curTime = 0;
        while (curTime!=time){
            room = dustExpand(room,r,c);
            room = upClean(room,cleanY-1,r,c);
            room = downClean(room,cleanY,r,c);
            curTime++;
        }
        int sum = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(room[i][j]!=-1){

                    sum+=room[i][j];
                }
            }
        }
        System.out.println(sum);
    }


    public static int[][] dustExpand(int[][] room,int r,int c){
        int[][] cRoom = new int[r][c];

        //미세먼지 확산(q)
        //1초에 일어날 확산리스트를 q에 저장
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){

                if(room[i][j]==-1) {
                    cRoom[i][j]=-1;
                    continue;
                }
                cRoom[i][j]+=room[i][j];
                for(int z=0;z<4;z++){
                    if(i+nx[z]<0||j+ny[z]<0||i+nx[z]>=r||j+ny[z]>=c) continue;
                    if(room[i+nx[z]][j+ny[z]]==-1) continue;
                    if(i+nx[z]>-1&&j+ny[z]>-1&&i+nx[z]<r&&j+ny[z]<c){
                        cRoom[i+nx[z]][j+ny[z]] += room[i][j]/5;
                        cRoom[i][j] -= room[i][j]/5;
                    }
                }
            }
        }

        return cRoom;
    }

    public static int[][] upClean(int[][] room,int cleanY,int r,int c){

        for(int y=cleanY-1;y>0;y--){
            room[y][0] = room[y-1][0];
        }

        for(int x=0;x<c-1;x++){
            room[0][x] = room[0][x+1];
        }
        for(int y=0;y<cleanY;y++){
            room[y][c-1] = room[y+1][c-1];
        }
        for(int x=c-1;x>1;x--){
            room[cleanY][x] = room[cleanY][x-1];
        }
        room[cleanY][1]=0;
        return room;
    }

    public static int[][] downClean(int[][] room,int cleanY,int r,int c){
        for(int y=cleanY+1;y<r-1;y++){
            room[y][0] = room[y+1][0];
        }
        for(int x=0;x<c-1;x++){
            room[r-1][x] = room[r-1][x+1];
        }
        for(int y=r-1;y>cleanY;y--){
            room[y][c-1] = room[y-1][c-1];
        }
        for(int x=c-1;x>1;x--){
            room[cleanY][x] = room[cleanY][x-1];
        }
        room[cleanY][1]=0;
        return room;
    }
}
