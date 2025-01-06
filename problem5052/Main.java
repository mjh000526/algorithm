import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            List<String> stringList = new ArrayList<>();
            for(int j=0;j<m;j++){
                stringList.add(br.readLine());
            }
            Collections.sort(stringList);
            list.add(stringList);
        }
        for(int i=0;i<n;i++){
            List<String> stringList = list.get(i);
            String result = "YES";
            for(int j=0;j<stringList.size()-1;j++){
                if(stringList.get(j+1).startsWith(stringList.get(j))){
                    result="NO";
                    break;
                }
            }
            System.out.println(result);
        }

    }
}
