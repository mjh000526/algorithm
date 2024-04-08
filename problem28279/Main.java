import com.sun.source.tree.BinaryTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n,order,i = 0;
        Integer result;
        n = Integer.parseInt(br.readLine());

        while (i<n) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    result = deque.pollFirst();
                    sb.append(result == null ? -1 : result).append("\n");
//                    System.out.println(result == null ? -1 : result);
                    break;
                case 4:
                    result = deque.pollLast();
                    sb.append(result == null ? -1 : result).append("\n");
//                    System.out.println(result == null ? -1 : result);
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
//                    System.out.println(deque.size());
                    break;
                case 6:
                    sb.append(deque.isEmpty() == true ? 1 : 0).append("\n");
//                    System.out.println(deque.isEmpty() == true ? 1 : 0);
                    break;
                case 7:
                    result = deque.peekFirst();
                    sb.append(result == null ? -1 : result).append("\n");
//                    System.out.println(result == null ? -1 : result);
                    break;
                case 8:
                    result = deque.peekLast();
                    sb.append(result == null ? -1 : result).append("\n");
//                    System.out.println(result == null ? -1 : result);
                    break;
            }
            i++;
        }
        System.out.println(sb);
    }

}
