import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> str = new ArrayList<String>();
    public static void main(String[] args) {
        Main object = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0;i<n;i++){
            str.add(scan.next());
        }
        for(int i=0;i<n;i++){
            int bool = object.Checkvps(0,i);
            String message = str.get(i).length() == 0 ? "YES":"NO";
            System.out.println(message);
        }
    }

    public int Checkvps(int index,int resultIndex){
        int cnt1 = (int) str.get(resultIndex).chars().filter(i->String.valueOf((char)i).equals("(")).count();
        int cnt2 = (int) str.get(resultIndex).chars().filter(i->String.valueOf((char)i).equals(")")).count();
        if(cnt1!=cnt2){
            return 0;
        }
        else if(str.get(resultIndex).isEmpty()) return 0;
        else if(str.get(resultIndex).charAt(0) == ')'){
            return 0;
        }
        else if(str.get(resultIndex).charAt(index)=='('){
            if(str.get(resultIndex).length()>1){
                int bool = Checkvps(index+1,resultIndex);
                if(bool == 1){
                    bool = Checkvps(index > 0 ? index -1 : index,resultIndex);
                }
            }
        }
        else if(str.get(resultIndex).charAt(index)==')'){
            String copy = str.get(resultIndex);
            str.set(resultIndex, copy.substring(0,index-1)+copy.substring(index+1,copy.length()));
            return 1;
        }
        return 0;
    }
}