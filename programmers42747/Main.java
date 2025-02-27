import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i=0; i < citations.length ;i++){
            if(citations[i]>=citations.length-i) {
                return citations.length-i;
            }
        }
        return 0;
    }
}
