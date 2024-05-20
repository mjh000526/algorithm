import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Queue<Pair>> qList = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        List<List<Integer>> valueList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int cas = scan.nextInt();
        for (int i = 0; i < cas; i++) {
            int list_size = scan.nextInt();
            num.add(scan.nextInt());
            Queue<Pair> q = new LinkedList<>();
            List<Integer> value = new ArrayList<>();
            for (int j = 0; j < list_size; j++) {
                int x = scan.nextInt();
                q.add(new Pair(j, x));
                value.add(x);
            }
            Collections.sort(value,Collections.reverseOrder());
            valueList.add(value);
            qList.add(q);
        }
        for(int i=0;i<cas;i++){
            int n = num.get(i);
            Queue<Pair> q = qList.get(i);
            int cnt = 0;
            while(true){
                Pair p = q.poll();
                if (p.key==n && p.value==valueList.get(i).get(0)) {
                    System.out.println(cnt+1);
                    break;
                }
                else if(p.value == valueList.get(i).get(0)){
                    valueList.get(i).remove(0);
                    cnt++;
                }else {
                    q.add(p);
                }
            }
         }
    }
    static class Pair implements Comparable<Pair>{
        public int key;
        public int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return o.value - this.value;
        }
    }



}
