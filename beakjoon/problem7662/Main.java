import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<m;j++) {
                String[] str = br.readLine().split(" ");
                String cal = str[0];
                int num = Integer.parseInt(str[1]);
                if (cal.equals("I")) {
                    //값넣기
                    minQueue.add(num);
                    maxQueue.add(num);
                    map.put(num,map.getOrDefault(num,0)+1);
                } else {
                    //값빼기
                    if(map.isEmpty()) {
                        continue;
                    }
                    else if(num==-1){
                        while (true){
                            int pollNum = minQueue.poll();
                            int cnt = map.getOrDefault(pollNum, 0);
                            if(cnt==0) continue;
                            else if(cnt==1) map.remove(pollNum);
                            else map.put(pollNum,cnt-1);
                            break;
                        }
                    }
                    else if(num==1){
                        while (true){
                            int pollNum = maxQueue.poll();
                            int cnt = map.getOrDefault(pollNum, 0);
                            if(cnt==0) continue;
                            else if(cnt==1) map.remove(pollNum);
                            else map.put(pollNum,cnt-1);
                            break;
                        }
                    }
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }
            else {
                int maxNum;
                while (true){
                    maxNum = maxQueue.poll();
                    int cnt = map.getOrDefault(maxNum, 0);
                    if(cnt==0) continue;
                    else if(cnt==1) map.remove(maxNum);
                    else map.put(maxNum,cnt-1);
                    break;
                }
                int minNum = maxNum;


                while (map.size()!=0){
                    minNum = minQueue.poll();
                    int cnt = map.getOrDefault(minNum, 0);
                    if(cnt==0) continue;
                    else if(cnt==1) map.remove(minNum);
                    else map.put(minNum,cnt-1);
                    break;
                }
                System.out.println(maxNum+" " + minNum);
            }
        }

    }
}
