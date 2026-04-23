import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] num;
    //    static int n;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        num = new int[n+1];
        num[1] = 0;

        for(int i=2;i<=n;i++){
            num[i] = Integer.MAX_VALUE;
            int cnt = 1;
            int x = i;
            num[i] = num[i-1]+1;
            if(i%2==0){
                num[i] = Integer.min(num[i/2]+cnt, num[i]);
            }
            if(i%3==0){
                num[i] = Integer.min(num[i/3]+cnt, num[i]);
            }
        }
        System.out.println(num[n]);

    }


}
