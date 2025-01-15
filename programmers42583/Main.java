import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args){
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length,weight,truck_weights));

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        ArrayDeque<Integer> truckQ = new ArrayDeque<>();
        for(int i=0;i<truck_weights.length;i++){
            truckQ.add(truck_weights[i]);
        }
        ArrayDeque<Integer> bridgeQ = new ArrayDeque<>();
        for(int i=0;i<bridge_length;i++){
            bridgeQ.add(-1);
        }
        do{
            answer++;
            int out = bridgeQ.poll();
            if(out!=-1){
                bridge_weight-=out;
            }

            if(!truckQ.isEmpty()&&truckQ.getFirst()+bridge_weight<=weight){
                int w = truckQ.poll();
                bridge_weight+=w;
                bridgeQ.add(w);
            }
            else{
                bridgeQ.add(-1);
            }
        } while (bridge_weight!=0);
        return answer;
    }
}
