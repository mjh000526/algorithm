import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] line;
    static int[] dfs_node;
    static int[] bfs_node;
    static List<Integer> bfs_list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int start = scan.nextInt();
        dfs_node = new int[n+1];
        bfs_node = new int[n+1];
        line = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            line[x][y] = line[y][x] = 1;
        }
        dfs(start,n);
        System.out.println();
        bfs(start,n);
        for(int i=0;i<bfs_list.size();i++){
            System.out.print(bfs_list.get(i) + " ");
        }
    }
    static public void bfs(int x,int size){
        if(bfs_node[x]==0){
            bfs_list.add(x);
            bfs_node[x]=1;
        }
        for(int i=1;i<=size;i++){
            if(line[x][i] == 1 && bfs_node[i] == 0){
                bfs_node[i]=1;
                q.add(i);
                bfs_list.add(i);
            }
        }
        int z = q.size();
        for(int i=0;i<z;i++){
            if(!q.isEmpty()) bfs(q.poll(),size);
        }
    }
    static public void dfs(int x,int size){
        if(dfs_node[x]==0){
            dfs_node[x]=1;
            System.out.print(x + " ");
        }
        for(int i=1;i<=size;i++){
            if(line[x][i] == 1 && dfs_node[i] == 0){
                dfs_node[i]=1;
                System.out.print(i + " ");
                dfs(i,size);
            }
        }
    }



}
