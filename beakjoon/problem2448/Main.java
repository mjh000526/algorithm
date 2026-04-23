import java.util.Scanner;


public class Main {
    static boolean[][] star;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int w = h*2-1;
        star = new boolean[w][h];
        drawing(w/2,0,h);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if (star[j][i]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static void drawing(int x,int y,int n){
        if(n==3){
            top(x,y);
            return;
        }
        n/=2;
        drawing(x,y,n);
        drawing(x-n,y+n,n);
        drawing(x+n,y+n,n);

    }

    public static void top(int x,int y){
        star[x][y]=true;
        mid(x,y);
        bottom(x,y);
    }

    public static void mid(int x, int y){
        star[x-1][y+1] = true;
        star[x+1][y+1] = true;
    }

    public static void bottom(int x,int y){
        int i;
        for(i=-2;i<3;i++){
            star[x+i][y+2] = true;
        }
    }
}
