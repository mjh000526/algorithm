import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};
    }

    static class Solution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String answer = "";
            int[] video_len_arr = time_format(video_len);
            int[] pos_arr = time_format(pos);
            int[] op_start_arr = time_format(op_start);
            int[] op_end_arr = time_format(op_end);
            pos_arr = is_opening_skip(pos_arr,op_start_arr,op_end_arr) ? op_end_arr.clone() : pos_arr;
            for(int i=0;i<commands.length;i++){
                if(commands[i].equals("prev")) pos_arr = command_prev(pos_arr);
                else pos_arr = command_next(pos_arr,video_len_arr);
                pos_arr = is_opening_skip(pos_arr,op_start_arr,op_end_arr) ? op_end_arr.clone() : pos_arr;
                System.out.println(answer_format(pos_arr));
            }
            return answer_format(pos_arr);
        }

        public int [] time_format(String time){
            int[] time_arr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
            return time_arr;
        }
        public String answer_format(int[] pos){
            String answer = Arrays.stream(pos).mapToObj(i -> String.format("%02d", i)).collect(Collectors.joining(":"));
            return answer;
        }

        public boolean is_opening_skip(int[] pos,int[]op_start,int[] op_end){
            //분이 같으면 초까지 세기
            if(pos[0]<op_start[0]||op_end[0]<pos[0]||
                    (pos[0]==op_start[0]&&pos[1]<op_start[1])||(pos[0]==op_end[0]&&pos[1]>op_end[1])){
                return false;
            }
//            System.out.println("스킵실행");
            return true;
        }

        public int[] command_prev(int[] pos){
            //10초전이 -이면 00:00
//            System.out.print("prev 실행:");
            if(pos[0]==0&&pos[1]<=10){
                pos[1]=0;
            }
            else if(pos[1]<10){
                pos[0]-=1;
                pos[1]=60 + pos[1] - 10;
            }
            else {
                pos[1]-=10;
            }
            return pos;
        }

        public int[] command_next(int[] pos,int[] video_len_arr){
//            System.out.print("next 실행:");
            pos[1]+=10;
            if(pos[1]>=60){
                pos[1] -=60;
                pos[0]+=1;
            }
            //10초후가 end보다 크면 end로
            if((pos[0]==video_len_arr[0]&&pos[1]>=video_len_arr[1]) ||
                    pos[0]>video_len_arr[0]){
//                System.out.println("여기가 실행이 안되나?" + answer_format(video_len_arr));
                return video_len_arr.clone();
            }
            return pos;
        }
    }
}
