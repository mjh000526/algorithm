import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        List<Integer> num = new ArrayList<>();
        int start = 0,plus_sum=0,minus=0,sum = 0;
        boolean plus = false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+'){
                if(plus==false){
                    plus_sum = Integer.valueOf(str.substring(start,i));
                }
                else {
                    plus_sum+=Integer.valueOf(str.substring(start,i));
                }
                plus=true;
                start= i+1;
            }
            else if(str.charAt(i)=='-'){
                if(plus==false){
                    num.add(Integer.valueOf(str.substring(start,i)));
                }
                else {
                    plus_sum+=Integer.valueOf(str.substring(start,i));
                    num.add(plus_sum);
                    plus_sum=0;
                }
                minus++;
                plus=false;
                start= i+1;
            }
        }
        if(plus){
            plus_sum+=Integer.valueOf(str.substring(start,str.length()));
            num.add(plus_sum);
        } else if (!plus) {
            num.add(Integer.valueOf(str.substring(start,str.length())));
        }
        sum = num.get(0);
        for (int i=1;i<num.size();i++){
            sum-=num.get(i);
        }
        System.out.println(sum);
    }


}
