import java.util.*;
public class Main {
    public static void main(String[] args){
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people,limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int length = people.length;

        boolean[] visit = new boolean[people.length];
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;

        while (i<length){
            if(visit[i]){
                i++;
                continue;
            }
            int boat = people[i];
            visit[i]=true;
            while (j>i){
                if(boat+people[j]<=limit&&!visit[j]){
                    boat+=people[j];
                    visit[j]=true;
                    break;
                }
                j--;
            }
            i++;
            answer++;
        }
        return answer;
    }

}
