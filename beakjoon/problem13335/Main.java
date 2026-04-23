import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = scan.nextInt();
        Queue<Integer> truck = new LinkedList<>();
        int w = scan.nextInt();
        int l = scan.nextInt();
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            truck.add(scan.nextInt());
        }
        for(int i=0;i<w;i++) q.add(0);
        while (!truck.isEmpty()){
            int num = q.poll();
            sum-=num;
            int head = truck.peek();
            if(sum+head <= l){
                head = truck.poll();
                q.add(head);
                sum+=head;
            }
            else q.add(0);
            cnt++;
        }
        System.out.println(cnt+w);

    }



}
