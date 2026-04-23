import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        HashMap<String, Integer> map = new HashMap<>();
        int sum = 0;
        while ((str = bf.readLine())!=null) {
            if(map.containsKey(str)) map.replace(str,map.get(str)+1);
            else {
                map.put(str,1);
            }
            sum++;
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        StringBuilder sb = new StringBuilder();
        for(String key: keySet) {
//            sb.append((key+" "+String.format("%.4f",(double)map.get(key)*100/(double)sum)+"\n"));

            System.out.println(key+" " + String.format("%.4f",(double)map.get(key)*100/(double)sum));
        }
//        System.out.print(sb);
    }
}
