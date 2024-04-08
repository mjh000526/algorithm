import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> list1 = new ArrayList<Integer>();
    public static void main(String[] args) {
        List<Integer> list2 = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int mid,right,left;
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            list1.add(scan.nextInt());
        }
        Collections.sort(list1);
        int m = scan.nextInt();
        for(int i=0;i<m;i++){
            list2.add(scan.nextInt());
        }
        for(int j=0;j<m;j++){
            if (binarySearch(list2.get(j), 0, n - 1) == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    static int binarySearch(int key,int low,int high){
        int mid;
        while(low <= high){
            mid = (high+low)/2;
            if(key==list1.get(mid)){
                return 0;
            }
            else if(key < list1.get(mid)){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

}