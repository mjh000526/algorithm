import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int cnt = 0;
        int n = scan.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Pair> num = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            num.add(new Pair(x,y));
        }

        Collections.sort(num);
        q.add(num.get(0).y);
        for(int i=1;i<n;i++){
            if(q.peek() <= num.get(i).x){
                q.poll();
            }
            q.add(num.get(i).y);

        }
        System.out.println(q.size());
    }

    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x == o.x){
                return this.y<o.y?-1:1;
            }
            return this.x < o.x?-1:1;
        }
    }


}
