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
        int m = scan.nextInt();
        List<Integer> num = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        int cnt = 0;
        int s = 0;

        for(int i=0;i<n;i++){
            s += scan.nextInt();
            num.add(s);
        }
        for(int i=0;i<m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            list.add(new Pair(x,y));
        }
        for(int i=0;i<m;i++){
            Pair p = list.get(i);
            if(p.first == 1){
                System.out.println(num.get(p.second-1));
            }
            else {
                System.out.println(num.get(p.second-1) - num.get(p.first-2));
            }
        }
    }

    public static class Pair{
        public int first;
        public int second;
        public Pair(int a,int b){
            first = a;
            second = b;
        }
    }


}
