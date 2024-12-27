import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int cnt = 1;
        int n = -1;
        int result = scan.nextInt();
        while(input<=result){
            if(Integer.toString(result).charAt(Integer.toString(result).length()-1)=='1'){
                cnt++;
                result/=10;
            }
            else if(result%2!=0){
                break;
            }
            else if((result/2)>=input){
                cnt++;
                result/=2;
            }
            else break;
            if(result==input){
                n=cnt;
            }
        }
        System.out.println(n);
    }
}
