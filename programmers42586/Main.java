import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds={1, 1, 1, 1, 1, 1};
        int day=0;
        int index=0;
        ArrayDeque<Integer> pQue = new ArrayDeque<>();
        ArrayDeque<Integer> sQue = new ArrayDeque<>();
        ArrayDeque<Integer> result = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++){
            pQue.add(progresses[i]);
            sQue.add(speeds[i]);
        }
        while (!pQue.isEmpty()){
            day = day + (int)Math.ceil((double) (100-pQue.getFirst()-day*sQue.getFirst()) /sQue.getFirst());
            int cnt=0;
            while (!pQue.isEmpty()){
                if(pQue.getFirst() + sQue.getFirst()*day>=100){
                    pQue.poll();
                    sQue.poll();
                    cnt++;
                }
                else break;
            }
            if(cnt!=0){
                result.add(cnt);
            }
        }




//        return que.stream().mapToInt(i->i).toArray();
    }

}
