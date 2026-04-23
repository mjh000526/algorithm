import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int n = scan.nextInt();
        int[] arrA = new int[n];
        long cnt = 0;
        for(int i=0;i<n;i++){
            arrA[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] arrB = new int[m];
        for(int i=0;i<m;i++){
            arrB[i] = scan.nextInt();
        }
        ArrayList<Long> sumA = new ArrayList<>();
        ArrayList<Long> sumB = new ArrayList<>();
        for(int i=0;i<n;i++){
            long sum = 0;
            for(int j=i;j<n;j++){
                sum+=arrA[j];
                sumA.add(sum);
            }
        }
        for(int i=0;i<m;i++){
            long sum = 0;
            for(int j=i;j<m;j++){
                sum+=arrB[j];
                sumB.add(sum);
            }
        }
        Collections.sort(sumA);
        Collections.sort(sumB);
        int indexA = 0;
        int indexB = sumB.size()-1;
        while (indexA<sumA.size()&&indexB>=0){
            long sum = sumA.get(indexA) + sumB.get(indexB);
            if(sum>t) indexB--;
            else if(sum<t) indexA++;
            else {
                long numA = sumA.get(indexA);
                long numB = sumB.get(indexB);
                long aCnt = 0, bCnt = 0;
                while (indexA<sumA.size()&&numA==sumA.get(indexA)){
                    aCnt++;
                    indexA++;
                }
                while (indexB>=0&&numB==sumB.get(indexB)){
                    bCnt++;
                    indexB--;
                }
                cnt+=(aCnt*bCnt);
            }
        }
        System.out.println(cnt);
    }


}
