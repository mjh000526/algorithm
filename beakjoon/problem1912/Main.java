import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] num;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        num = new int[n];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        boolean plus = false;
        for(int i=0;i<n;i++){
            num[i] = scan.nextInt();
            if(num[i] > 0) plus = true;
        }
        sum = num[0];
        max = Integer.max(max,num[0]);
        for(int i=1;i<n;i++){
            if(plus==true){
                sum += num[i];
                num[i] = sum;
                max = Integer.max(max,sum);
                if(sum <= 0){
                    sum -= num[i];
                    sum = 0;
                }
            }
            else max = Integer.max(max,num[i]);
        }
        max = Integer.max(max,sum);
        System.out.println(max);

    }



}
