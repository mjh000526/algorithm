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
        int[] time = new int[n];
        for(int i=0;i<n;i++){
            time[i]=scan.nextInt();
        }
        Arrays.sort(time);
        int sum =0;
        for(int i=n;i>0;i--){
            sum += time[i-1] * (n-i+1);
        }
        System.out.println(sum);
    }


}
