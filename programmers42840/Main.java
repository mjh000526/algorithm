import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Integer> result = new HashSet<>();
    public static void main(String[] args){
        String sum = "011";
        System.out.println(solution(sum));
    }

    static public int solution(String numbers) {
        int anwser = 0;

        ArrayDeque<String> q = new ArrayDeque<>();
        for(int i=0;i<numbers.length();i++){
            q.add(Character.toString(numbers.charAt(i)));
        }
        cal(q,"",numbers.length(),0);
        return result.size();
    }
    static public void cal(ArrayDeque<String> origin, String str, int size, int depth){
        if(size==depth) {
            return;
        }

        for(int i=0;i<origin.size();i++){
            String a = origin.poll();
            str+=a;
            int num = Integer.parseInt(str);
            for(int j=2;j<=num;j++){
                if(j==num) {
                    result.add(num);
                }
                else if(num%j==0) break;
            }
            cal(origin,str,size,depth+1);
            str = str.substring(0,str.length()-1);
            origin.add(a);
        }
    }
}
