import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            q.add(scan.nextInt());
        }
        while (q.size()>1){
            int a = q.poll();
            int b = q.poll();
            sum+=(a+b);
            q.add(a+b);

        }
        System.out.println(sum);
    }



}
