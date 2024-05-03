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
        int[] coin = new int[n];
        for(int i=0;i<n;i++){
            coin[i]=scan.nextInt();
        }
        int i=n-1;
        int cnt = 0;
        while (m>0){
            int price = m/coin[i];
            if(price>0){
                m = m - (price*coin[i]);
                cnt += price;
            }
            i--;
        }
        System.out.println(cnt);
    }


}
