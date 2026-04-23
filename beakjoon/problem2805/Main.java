import java.util.Scanner;

public class Main {
    static int[] num;

    static long result=Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        num = new int[n];
        long m = scan.nextLong();
        for(int i=0;i<n;i++){
            num[i]=scan.nextInt();
            max = Long.max(num[i],max);
        }
        cutTree(n,m,0L,max+1);
        System.out.println(result-1);
    }

    public static void cutTree(int n,Long m,long low,long high){
        long mid;
        long sum;
        while (low < high){
            mid = (low+high)/2;
            sum = 0L;
            for(int i=0;i<n;i++){
                if(num[i]>mid) {
                    sum = sum+ num[i]-mid;
                }
            }
            if(sum >= m){
                low = mid +1;
            } else {
                high = mid;
                result = Long.min(result,mid);
            }
        }
    }

}
