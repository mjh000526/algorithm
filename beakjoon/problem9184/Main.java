import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][][] num;
    static int t = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        num = new int[50][50][50];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> z = new ArrayList<>();
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        while (true){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            if(a==-1&&b==-1&&c==-1) break;
            cnt++;
            x.add(a);
            y.add(b);
            z.add(c);
        }
        for(int i=0;i<cnt;i++){
            int m = cal(x.get(i),y.get(i),z.get(i));
            System.out.println("w(" + x.get(i) + ", " + y.get(i) + ", " + z.get(i) + ") = " + m);
        }


    }

    public static int cal(int a, int b, int c){
        if(a<=0 || b<=0|| c<=0){
            return 1;
        }
        else if(a > 20 || b>20||c>20){
            if(t==0) t = cal(20,20,20);
            return t;
        } else if (num[a][b][c] != 0) {
            return num[a][b][c];
        } else if(num[a][b][c] == 0){
            num[a][b][c] = cal(a-1,b,c) +cal(a-1,b-1,c) + cal(a-1,b,c-1) - cal(a-1,b-1,c-1);
            return num[a][b][c];
        }
        return 0;
    }


}
