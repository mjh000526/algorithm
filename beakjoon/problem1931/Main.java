import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Pair> list = new ArrayList<>();
        int cnt = 0;
        long finish = 0;
        long time = 0;
        for(int i=0;i<n;i++){
            long f = scan.nextLong();
            long s = scan.nextLong();
            list.add(new Pair(f,s));
        }
        Collections.sort(list);
        for(int i=0;i<n;i++){
            Pair p = list.get(i);
            if(finish <= p.first){
                finish = p.second;
                time = p.second - p.first;
                cnt++;
            }
            else if(finish >= p.second && time >= p.second-p.first){
                finish = p.second;
                time = p.second-p.first;
            }
        }

        System.out.println(cnt);
    }

    public static class Pair implements Comparable<Pair> {
        public long first;
        public long second;
        public Pair(long a,long b){
            first = a;
            second = b;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.first == p.first)
                return Long.compare(this.second, p.second);
            else
                return Long.compare(this.first, p.first);
        }
    }


}
