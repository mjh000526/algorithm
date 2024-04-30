import java.util.Scanner;

public class Main {
    static int [][]board = new int[9][9];
    static int cnt = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = scan.nextInt();
                if(board[i][j]==0) cnt++;
            }
        }
        bfs(0,0);
    }
    public static void bfs(int x, int y) {
        if(y==9){
            bfs(x+1,0);
            return;
        }
        else if(x==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        else if(board[x][y]==0){
            for(int i=1;i<10;i++){
                if(checkNum(x,y,i)){
                    board[x][y]=i;
                    bfs(x,y+1);
                }
            }
            board[x][y]=0;
            return;
        }
        bfs(x,y+1);
    }

    public static boolean checkNum(int x,int y,int num){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+(((x/3))*3)][j+((y/3)*3)]==num){
                    return false;
                }
            }
        }
        for(int i=0;i<9;i++){
            if(board[x][i] == num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][y]==num){
                return false;
            }
        }
        return true;
    }



}
