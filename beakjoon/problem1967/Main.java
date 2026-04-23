import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //list 사용 고려
//    static int[][] graph;
    static List<List<int[]>> list = new ArrayList<>();
    static boolean[] visited;
    static int maxIndex;
    static int maxWeight = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<int[]>());
        }
        for(int i=0;i<n-1;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();
            list.get(x).add(new int[]{y,w});
            list.get(y).add(new int[]{x,w});
        }
        visited[1]=true;
        dfs(n,1,0);
        visited = new boolean[n+1];
        visited[maxIndex]=true;

        maxWeight=0;



        dfs(n,maxIndex,0);
        System.out.println(maxWeight);
    }

    public static void dfs(int n,int index, int weight){
        if(weight > maxWeight){
            maxWeight = weight;
            maxIndex = index;
        }
        for(int i=0;i<list.get(index).size();i++){
            int[] info =list.get(index).get(i);
            if(!visited[info[0]]){
                visited[info[0]]=true;
                dfs(n,info[0],info[1]+weight);
            }
        }
    }

}
