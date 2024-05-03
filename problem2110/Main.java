import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] num;
    static int[] list;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=scan.nextInt();
        }
        Arrays.sort(num);
        System.out.println(share(n,m,1,num[n-1]+1));
    }

    public static int share(int n,int m,int low, int high){
        int mid = 0;
        while (low+1 < high){
             mid = (high + low) / 2;
             int a = num[0];
             int cnt = 1;
             for(int i=1;i<n;i++){
                 if(num[i]-a >= mid){
                     cnt++;
                     a = num[i];
                 }
             }
             if(cnt < m){
                 high = mid;
             }
             else {
                 low = mid;
             }
        }
        return low;
    }
}
