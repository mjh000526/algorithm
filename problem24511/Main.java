
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> struct = new ArrayList<Integer>();
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> addDate = new ArrayList<Integer>();
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            struct.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(struct.get(i)==0){
                queue.addLast(num);
            }
        }
        int x = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<x;i++){
            addDate.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<x;i++){
            queue.addFirst(addDate.get(i));
            int num = queue.pollLast();
            sb.append(num + " ");
        }
        System.out.println(sb);

    }

}
