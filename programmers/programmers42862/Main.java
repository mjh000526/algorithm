import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int n = 5;
        int[] lost = {5,3};
        int[] reserve = {4,2};
        System.out.println(solution(n,lost,reserve));
    }

    static public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+2];
        int answer = 0;

        for(int i=0;i<lost.length;i++){
            student[lost[i]]-=1;
        }
        for(int i=0;i<reserve.length;i++){
            student[reserve[i]]+=1;
        }
        for(int i=1;i<=n;i++){
            if(student[i-1]==-1&&student[i]==1){
                student[i-1]++;
                student[i]--;
            } else if (student[i+1]==-1&&student[i]==1) {
                student[i+1]++;
                student[i]--;
            }
        }
        for(int i=1;i<=n;i++){
            if(student[i]>-1) {
                answer++;
            }
        }

        return answer;
    }
}
