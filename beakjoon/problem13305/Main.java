import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static long[] gas;
    static long[] dis;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dis = new long[n-1];
        gas = new long[n];

        for(int i=0;i<n-1;i++){
            dis[i] = scan.nextLong();
        }
        for(int i=0;i<n;i++){
            gas[i] = scan.nextLong();
        }
        int i = 0;
        long sum = 0;
        long now_gas = gas[0];
        while (i<n-1){
            if(now_gas <= gas[i]){
                sum+=(now_gas*dis[i]);
            }
            else {
                now_gas = gas[i];
                sum+=(now_gas*dis[i]);
            }
            i++;
        }
        System.out.println(sum);
    }


}
