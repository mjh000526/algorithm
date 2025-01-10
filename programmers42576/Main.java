import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            if(hashMap.containsKey(participant[i]))
                hashMap.put(participant[i],hashMap.get(participant[i])+1);
            else hashMap.put(participant[i],1);
        }

        for(int i=0;i<completion.length;i++){
            hashMap.put(completion[i],hashMap.get(completion[i])-1);
            if(hashMap.get(completion[i])==0) hashMap.remove(completion[i]);
        }
        List<String> keySet = new ArrayList<>(hashMap.keySet());
        System.out.println(keySet.size());
    }
}
