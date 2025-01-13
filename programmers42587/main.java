import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities,location));
    }

    static public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            q.add(i);
            list.add(priorities[i]);
        }
        Collections.sort(list,Collections.reverseOrder());
        while (true){
            int runIndex = q.poll();
            System.out.println(priorities[runIndex]);
            System.out.println(list.get(0));
            if (priorities[runIndex]<list.get(0)) {
                q.add(runIndex);
            } else if(runIndex==location){
                answer++;
                return answer;
            } else {
                answer++;
                list.remove(0);
            }

        }
    }

}
