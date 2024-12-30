import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int num = 9;
        List<Integer> alphabat = new ArrayList<>();
        for(int i=0;i<26;i++){
            alphabat.add(0);
        }
        int sum = 0;
        int cnt = scan.nextInt();
        for (int i = 0; i < cnt; i++) {
            String str = scan.next();
            for(int j =0;j<str.length();j++){
                alphabat.set(str.charAt(j)-'A',alphabat.get(str.charAt(j)-'A')+(int)(Math.pow(10,str.length()-j-1)));
            }
        }
        Collections.sort(alphabat,Collections.reverseOrder());
        for(int i=0;i<alphabat.size();i++){
            if(alphabat.get(i)!=0){
                sum+=(alphabat.get(i)*num);
                num--;
            }
        }
        System.out.println(sum);
    }
}

