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
    static int []arr;
    static int []input;
    static List<Integer> cal = new ArrayList<>();
    static int cnt=0;
    static int mx=-1000000000;
    static int mn=1000000000;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        input = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            input[i] = Integer.parseInt(st.nextToken());
            cnt+=input[i];
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<input[i];j++){
                cal.add(i+1);
            }
        }
        back(n,arr[0],0);
        bw.write(mx + "\n"+mn);
        bw.flush();
        bw.close();
    }

    public static void back(int n,int sum,int depth) throws IOException {
        if(depth==cnt){
            mx = Math.max(mx,sum);//if문으로 하다가 1시간날림
            mn = Math.min(mn,sum);
            return;
        }
        for (int i=0;i<cnt;i++){
            if(cal.get(i)>0){
                int c = cal.get(i);
                cal.set(i,0);
                switch (c){
                    case 1:
                        back(n,sum+arr[depth+1],depth+1);
                        break;
                    case 2:
                        back(n,sum-arr[depth+1],depth+1);
                        break;
                    case 3:
                        back(n,sum*arr[depth+1],depth+1);
                        break;
                    case 4:
                        back(n,sum/arr[depth+1],depth+1);
                        break;
                }
                cal.set(i,c);
            }

        }
    }
}
