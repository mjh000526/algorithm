import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int [][]member;
    static int []list;
    static int score=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        member = new int[n][n];
        list = new int[n];
        for (int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                member[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(n,0,0);
        bw.write(score + "");
        bw.flush();
        bw.close();
    }

    public static void back(int n,int start_num,int depth) throws IOException {
        if(depth==n/2){
            int start_sum=0;
            int link_sum=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(list[i]==list[j]){
                        if(list[i]==0) link_sum= link_sum + member[i][j] + member[j][i];
                        else if(list[i]==1) start_sum= start_sum + member[i][j] + member[j][i];
                    }
                }
            }
            start_sum-=link_sum;
            score = Math.min(score,Math.abs(start_sum));
            return;
        }
        for (int i=start_num;i<n;i++){
            if(list[i]==0){
                list[i]=1;
                back(n,i+1,depth+1);
                if(score==0) {
                    System.out.println(0);
                    System.exit(0);
                }
                list[i]=0;
            }

        }
    }
}
