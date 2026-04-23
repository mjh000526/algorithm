import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        PriorityQueue<Integer> plusQ = new PriorityQueue<>((i1,i2) -> i2-i1);
        PriorityQueue<Integer> minusQ = new PriorityQueue<>((i1,i2) -> i2-i1);
        int max = 0;
        int dist = 0;
        for(int i=0;i<n;i++){
            int num = scan.nextInt();
            if(num>0) plusQ.add(num);
            else minusQ.add(Math.abs(num));
        }

        if(plusQ.isEmpty()) max = minusQ.peek();
        else if(minusQ.isEmpty()) max = plusQ.peek();
        else max = Math.max(minusQ.peek(),plusQ.peek());
        while (!plusQ.isEmpty()){
            int num = plusQ.poll();
            for(int i=0;i<m-1;i++){
                plusQ.poll();
            }
            dist+=num*2;
        }
        while (!minusQ.isEmpty()){
            int num = minusQ.poll();
            for(int i=0;i<m-1;i++){
                minusQ.poll();
            }
            dist+=num*2;
        }
        System.out.println(dist-max);

    }
}
