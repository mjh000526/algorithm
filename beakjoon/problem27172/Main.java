import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] num = new int[n];
        int maxNum = 0;
        for(int i=0;i<n;i++){
            num[i] = scan.nextInt();
            maxNum = Math.max(num[i],maxNum);
            map.put(num[i],0);
        }

        for(int i=0;i<n;i++){
            for(int j=num[i]*2;j<=maxNum;j+=num[i]){
                if(map.containsKey(j)&&j%num[i]==0){
                    map.put(j,map.get(j)-1);
                    map.put(num[i],map.get(num[i])+1);
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(map.get(num[i]) + " ");
        }
    }
}
