import java.util.Scanner;

public class Main {
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        num = new int[n];
        int m = scan.nextInt();
        for(int i=0;i<n;i++){
            num[i]=scan.nextInt();
            max = Integer.max(num[i], max);
        }
        search(n,m,0,max+1);
        System.out.print(result);
    }

    public static void search(int n,int m,int low, int high){
        int mid = 0;
        int cnt;
        while (low<high){
            cnt =0;
            mid = (low + high)/2;
            for(int i=0;i<n;i++){
                cnt = cnt + (num[i]/mid);
            }
            if(cnt < m){
                high = mid;
            }
            else if (cnt >= m) {
                low = mid + 1;
                result=Integer.max(mid,result);
            }
        }
        result = low-1;
    }
}
