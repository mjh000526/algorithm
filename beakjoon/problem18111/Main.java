import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] ground;
    static int block = 0;
    static int min_time = Integer.MAX_VALUE;
    static int max_h = Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int avg_max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ground = new int[n][m];
        block = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                sum += ground[i][j];
                min = Integer.min(min,ground[i][j]);
                max = Integer.max(max,ground[i][j]);
            }
        }
        for(int i=min;i<=max;i++){
            int h = i;
            int t = 0;
            int cpy_b = block;
            boolean can = true;
            for(int x=0;x<n;x++){
                for(int y=0;y<m;y++){
                    if(ground[x][y]>i){
                        int b = ground[x][y]-i;
                        cpy_b += b;
                        t += (b*2);
                    }
                }
            }
            for(int x=0;x<n;x++){
                for(int y=0;y<m;y++){
                    if(ground[x][y]<i){
                        int b = i - ground[x][y];
                        if(cpy_b - b <0){
                            can=false;
                            break;
                        }
                        cpy_b -= b;
                        t += b;
                    }
                }
            }
            if(min_time > t && can==true){
                min_time = t;
                max_h = h;
            } else if (min_time == t && can==true) {
                max_h = Integer.max(max_h,h);
            }
        }
        System.out.println(min_time + " " + max_h);

    }



}
