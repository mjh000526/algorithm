import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class main {
    public static void main(String[] args){
        int[] progresses = {93, 30, 55};
        int[] speeds={1, 30, 5};
        int day=0;
        int index=0;
        ArrayDeque<Integer> pQue = new ArrayDeque<>();
        ArrayDeque<Integer> sQue = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++){
            pQue.add(progresses[i]);
            sQue.add(speeds[i]);
        }
        while (!pQue.isEmpty()){
            day = day+(day*sQue.getFirst() + (int));Math.ceil((double) (100-pQue.getFirst()) /sQue.get)
        }




//        return que.stream().mapToInt(i->i).toArray();
    }

}
