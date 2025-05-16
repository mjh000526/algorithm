import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] wheel = new int[4][8];
    static int[] top = new int[4];
    static int mainWheel = 0;
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    public static void main(String[] args){
        wheel = new int[4][8];
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<4;i++){
            String str = scan.nextLine();
            for(int j=0;j<str.length();j++){
                wheel[i][j]=str.charAt(j)-'0';
            }
        }
        int n = scan.nextInt();
        List<int[]> rotation = new ArrayList<>();
        for(int i=0;i<n;i++){
            int num = scan.nextInt();
            int dir = scan.nextInt();
            rotation.add(new int[]{num-1,dir});
        }
        for(int i=0;i<n;i++){
            int[] list = rotation.get(i);
            mainWheel = list[0];
            q.add(mainWheel);
            leftRotate(mainWheel);
            rightRotate(mainWheel);
            while (!q.isEmpty()){
                move(q.poll(),list[1]);
            }
        }
        int sum=0;
        for(int i=0;i<4;i++){
            if(wheel[i][top[i]]==1) sum+=(int)(Math.pow(2,i));
        }
        System.out.println(sum);
    }

    public static void move(int num,int dir){
        if(num%2==mainWheel%2){
            top[num]=(top[num]-dir)%8 < 0 ? 7 : (top[num]-dir)%8 > 7 ? 0 : (top[num]-dir)%8;
        }else {
            top[num]=(top[num]+dir)%8 < 0 ? 7 : (top[num]+dir)%8 > 7 ? 0 : (top[num]+dir)%8;
        }
    }

    public static void leftRotate(int num){
        while(num>0){
            int originSide = wheel[num][(top[num]+6)%8];
            num--;
            int leftSide = wheel[num][(top[num]+2)%8];
            if(originSide==leftSide) break;
            q.add(num);
        }
    }
    public static void rightRotate(int num){
        while(num<3){
            int originSide = wheel[num][(top[num]+2)%8];
            num++;
            int leftSide = wheel[num][(top[num]+6)%8];
            if(originSide==leftSide) break;
            q.add(num);
        }
    }

}
