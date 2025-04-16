import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] city = new int[n+1][n+1];
        for(int[] c:city) Arrays.fill(c,100000000);
        for(int i=0;i<m;i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            int w = scan.nextInt();
            city[start][end] = Math.min(w,city[start][end]);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j) continue;
                    city[i][j] = Math.min(city[i][j],city[i][k]+city[k][j]);
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if (city[i][j] == 100000000) {
                    System.out.print("0 ");
                }
                else System.out.print(city[i][j] + " ");

            }
            System.out.println();
        }
    }
}
