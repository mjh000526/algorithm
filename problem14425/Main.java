import com.sun.source.tree.BinaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int c=0;
        int cnt =0;
        for(int i=0;i<n;i++){
            list1.add(scan.next());
        }
        for(int i=0;i<m;i++){
            list2.add(scan.next());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(list1.get(i).equals(list2.get(j))) cnt++;
            }
        }

        System.out.println(cnt);
    }

}
