import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static long[] num;
//    static int n;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        num = new long[101];
        int[] m = new int[n];
        for(int i=0;i<n;i++){
            m[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++){
            num[0] = 1;
            num[1] = 1;
            num[2] = 1;
            num[3] = 2;
            num[4] = 2;
            for(int j=5;j<m[i];j++){
                num[j]=num[j-1]+num[j-5];
            }
            System.out.println(num[m[i]-1]);
        }
    }


}
