public class Main {
    static int answer = 0;
    public static void main(String[] args){
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers,target));
    }

    static public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return answer;
    }

    static void dfs(int index,int result, int[] numbers, int target){
        if(index==numbers.length) {
            if(result==target) answer++;
            return;
        }
        dfs(index+1,result+numbers[index],numbers,target);
        dfs(index+1,result-numbers[index],numbers,target);

    }
}
