import java.util.Scanner;

public class Main {
    static int[][] board;
    static boolean finish = false;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        board = new int[9][9];
        int x = -1;
        int y = -1;
        for(int i=0;i<9;i++){
            String str = scan.nextLine();
            for(int j=0;j<9;j++){
                if(x==-1&&y==-1&&str.charAt(j)-48==0){
                    x = i;
                    y = j;
                }
                board[i][j] = str.charAt(j)-48;
            }

        }
        dfs(x,y);

    }

    public static void dfs(int x,int y){
        if(finish==true) return;
        if(x==8&&y==9){
            //종료
            finish = true;
            print();
            //출력
            return;
        }
        if(y==9){
            x++;
            y=0;
        }

        if(board[x][y]!=0) {
//            System.out.println("x = " + x+", y = " + y+", v = "+board[x][y]);
            dfs(x,y+1);
            return;
        }

        for(int i=1;i<=9;i++){
            if(checkLine(x,y,i)) continue;
            if(checkBox(x,y,i)) continue;
            board[x][y] = i;

            dfs(x,y+1);
            board[x][y] = 0;
        }
    }

    public static boolean checkLine(int x,int y,int value){
        for(int i=0;i<9;i++){
            if(board[x][i]==value||board[i][y]==value)
                return true;
        }
        return false;
    }
    public static boolean checkBox(int x,int y,int value){
        for(int i=x/3*3;i<(x/3*3)+3;i++){
            for(int j=y/3*3;j<(y/3*3)+3;j++){
                if(board[i][j]==value) return true;
            }
        }
        return false;
    }

    public static void print(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

