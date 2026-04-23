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
        num = new int[n+2];
        num[0] = 0;
        num[1] = 1;
        num[2] = 2;
        if(n < 3){
            System.out.println(n%15746);
        }
        else {
            for(int i=3;i<=n;i++){
                num[i] = (num[i-1] + num[i-2])%15746;
            }
            System.out.println(num[n]);
        }
    }


}
