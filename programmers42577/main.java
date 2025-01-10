import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class main {
    public static void main(String[] args){
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        HashMap<String, Integer> map = new HashMap<>();
        int sum=1;
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],1) + 1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        for(int i=0;i<keySet.size();i++){
            sum*=map.get(keySet.get(i));
        }
        System.out.println(sum-1);
    }
}
