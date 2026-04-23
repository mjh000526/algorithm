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

    static int[][] box;
    static int no =0;
    static int yes=0;
    static int em = 0;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = scan.nextInt();
                if (num == -1)
                    em++;
                else if (num == 0)
                    no++;
                else if(num == 1){
                    yes++;
                    q.add(new Point(i, j));
                }
                box[i][j] = num;
            }
        }
        int px = 0;
        int py = 0;
        if (yes+em == n*m) {
            System.out.println(0);
            System.exit(0);
        } else {
            while (!q.isEmpty()) {
                Point p = q.poll();
                px = (int) p.getX();
                py = (int) p.getY();
                if (px > 0 && box[px - 1][py] == 0) {
                    q.add(new Point(px - 1, py));
                    yes++;
                    no--;
                    box[px - 1][py] = box[px][py] + 1;
                }
                if (py > 0 && box[px][py - 1] == 0) {
                    q.add(new Point(px, py - 1));
                    yes++;
                    no--;
                    box[px][py - 1] = box[px][py] + 1;
                }
                if (px < n - 1 && box[px + 1][py] == 0) {
                    q.add(new Point(px + 1, py));
                    yes++;
                    no--;
                    box[px + 1][py] = box[px][py] + 1;
                }
                if (py < m - 1 && box[px][py + 1] == 0) {
                    q.add(new Point(px, py + 1));
                    yes++;
                    no--;
                    box[px][py + 1] = box[px][py] + 1;
                }
            }
            if (no == 0) {
                System.out.println(box[px][py]-1);
            }
            else if (no != 0) {
                System.out.println(-1);
            }
        }

    }



}
