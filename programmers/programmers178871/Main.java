import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Solution sol = new Solution();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        players = sol.solution(players,callings);
        for(int i=0;i<players.length;i++){
            System.out.println(players[i]);
        }


    }

    static class Solution {
        public String[] solution(String[] players, String[] callings) {
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=0;i<players.length;i++){
                map.put(players[i],i);
            }
            for(int i=0;i<callings.length;i++){
                //map에서 플레이어이름과 인덱스 찾기
                String first_name = callings[i];
                int first_index = map.get(first_name);

                //인덱스를 이용해서 앞의 선수 이름과 찾기
                String sec_name = players[first_index-1];
                int sec_index = first_index-1;

                //array에 반영
                players[sec_index] = first_name;
                players[first_index] = sec_name;
                //map에 인덱스 업데이트하기(둘다)
                map.put(first_name,sec_index);
                map.put(sec_name,first_index);
            }


            return players;
        }
    }
}
