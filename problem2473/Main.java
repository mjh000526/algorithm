import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        long min = Long.MAX_VALUE;
        long[] result = new long[3];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextLong();
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            long num = arr[i];
            int left = i+1;
            int right = n-1;
            long before = Long.MAX_VALUE;
            if(min==0) break;
            while (left<right){
                long sum = num+arr[left]+arr[right];

                if(left==i) left++;
                if(Math.abs(sum)<min){
//                    System.out.println("first : " + i + ", left : " + left + " , right : " + right + ", sum = " + sum);
                    min = Math.abs(sum);
                    result[0] = num;
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                if(sum>0){
                    right--;
                }
                else if (sum<0){
                    left++;
                }
                else if(sum==0) break;
                before = sum;
            }
        }
        Arrays.sort(result);
        for(int i=0;i<3;i++){
            System.out.print(result[i] + " ");
        }
    }
}
