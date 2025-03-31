import java.util.Scanner;

public class Main {
    static int cnt = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();
        search((int) Math.pow(2,n),r,c);
        System.out.println(cnt);
    }

    public static void search(int n,int r,int c){
        if(n==1) return;
        int siteMiddleNum = n/2;

        if(r<siteMiddleNum&&c<siteMiddleNum){
            //1사분면
//            System.out.println("1사분면 : " + r + " : " + c);

            search(siteMiddleNum,r,c);
        }
        else if(r<siteMiddleNum&&c>=siteMiddleNum){
            //2사분면
            cnt+=(siteMiddleNum*siteMiddleNum);
//            System.out.println("2사분면");
            search(siteMiddleNum,r,c-siteMiddleNum);
        }
        else if(r>=siteMiddleNum&&c<siteMiddleNum){
            //3사분면
            cnt+=(siteMiddleNum*siteMiddleNum*2);
//            System.out.println("3사분면");
            search(siteMiddleNum,r-siteMiddleNum,c);
        }
        else if(r>=siteMiddleNum&&c>=siteMiddleNum){
            //4사분면
            cnt+=(siteMiddleNum*siteMiddleNum*3);
//            System.out.println("4사분면");
            search(siteMiddleNum,r-siteMiddleNum,c-siteMiddleNum);
        }
    }
}
