import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] ground;
    static int[][] visit;
    static List<Integer> cnt_list = new ArrayList<>();
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++){
            int w = scan.nextInt();
            int h = scan.nextInt();
            int c = scan.nextInt();
            ground = new int[w][h];
            visit = new int[w][h];
            for(int j=0;j<c;j++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                ground[x][y] = 1;
            }
            cnt = 0;
            for(int x = 0;x<w;x++){
                for(int y=0;y<h;y++){
                    if(ground[x][y]==1){
                        dfs(x,y,w,h);
                        cnt++;
                    }
                }
            }
            cnt_list.add(cnt);
        }
        for(int i=0;i<cnt_list.size();i++){
            System.out.println(cnt_list.get(i));
        }
    }

    static public void dfs(int x,int y,int w,int h){
        ground[x][y] = 0;
        if(x<w-1&&ground[x+1][y]==1){
            dfs(x+1,y,w,h);
        }
        if(x>0&&ground[x-1][y]==1){
            dfs(x-1,y,w,h);
        }
        if(y<h-1&&ground[x][y+1]==1){
            dfs(x,y+1,w,h);
        }
        if(y>0 && ground[x][y-1]==1){
            dfs(x,y-1,w,h);
        }
    }




}
