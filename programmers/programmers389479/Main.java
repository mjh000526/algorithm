public class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m=3,k=5;
        System.out.println(sol.solution(players,m,k));
    }

    static class Solution {
        public int solution(int[] players, int m, int k) {
            int answer = 0;
            //현재 서버 갯수
            int currnet_server_cnt = 1;
            //증설한횟수
            int creation_cnt = 0;
            //서버갯수를 저장할 arr
            int[] server_arr = new int[50];
            //현재인원과 수용인원 계산
            for(int i=0;i<24;i++){
                currnet_server_cnt-=server_arr[i];
                int memo = 0;
                if(players[i]>=(currnet_server_cnt*m)){
                    int needed_server = ((int) Math.ceil(players[i]/m))-currnet_server_cnt+1;
                    memo = needed_server;
                    creation_cnt +=needed_server;
                    server_arr[i+k]= needed_server;
                    currnet_server_cnt+=needed_server;
                }
//                System.out.println(i + " : " + players[i] + " " + (currnet_server_cnt-1) + " " + memo);
            }
            return creation_cnt;
        }
    }
}
