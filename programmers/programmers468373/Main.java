import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javax.swing.JInternalFrame;

public class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        int n = 10;
        int infection = 1;
        int[][] edges = {{1, 2, 1}, {1, 3, 1}, {1, 4, 3}, {1, 5, 2}, {5, 6, 1}, {5, 7, 1}, {2, 8, 3}, {2, 9, 2}, {9, 10, 1}};
        int k = 2;
        System.out.println(sol.solution(n,infection,edges,k));

    }

    static class Solution {
        static int answer = 0;
        static boolean[] result;
        public int solution(int n, int infection, int[][] edges, int k) {
            //파이프유형마다 연결된 노드들 저장
            List<List<Node>> map = new ArrayList<>();
            //감염상태 array
            boolean[] monitor = new boolean[n+1];
            result = new boolean[n+1];

            //init
            for(int i=0;i<3;i++){
                map.add(new ArrayList<Node>());
            }
            for(int i=0;i< edges.length;i++){
                if(edges[i][2]==1){
                    map.get(0).add(new Node(edges[i][0],edges[i][1]));
                }
                else if(edges[i][2]==2){
                    map.get(1).add(new Node(edges[i][0],edges[i][1]));
                }
                else if(edges[i][2]==3){
                    map.get(2).add(new Node(edges[i][0],edges[i][1]));
                }
            }
            monitor[infection] = true;
            //ABC파이프가 열렸을 때 연결된 파이프들 찾기
            for(int i=0;i<3;i++){
                List<Integer> type_arr = new ArrayList<>();
                type_arr.add(i);
                dfs(n,1,map,monitor,i,k,0,type_arr);
            }


            return answer;
        }

        public void dfs(int n,int max,List<List<Node>> map, boolean[] monitor, int type,int k,int cnt,List<Integer> type_arr){
            //k값보다 넘으면 return
            if(cnt==k) return;
            boolean[] monitor_clone = monitor.clone();
            boolean[][] arr = new boolean[n][n];
            cnt++;
            //인자로 받은 파이프종류를 열고 감염된 노드 찾기(참조변수라 clone고려)
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0;i<map.get(type).size();i++){
                Node node = map.get(type).get(i);
                if(monitor_clone[node.x]){
                    q.add(node.x);
                }
                if(monitor_clone[node.y]){
                    q.add(node.y);
                }
            }
            while (!q.isEmpty()){
                int num = q.poll();
                for(int i=0;i<map.get(type).size();i++){
                    Node node = map.get(type).get(i);
                    if((num==node.x||num==node.y)&&monitor_clone[node.x]!=monitor_clone[node.y]){
                        max++;
                        monitor_clone[node.x]=true;
                        monitor_clone[node.y]=true;
                        q.add(node.x==num? node.y : node.x);
                    }
                }
            }
            //최대값 확인 및 업데이트, 방문체크
            if(answer<max){
                result = monitor_clone.clone();
                for(int i=1;i<monitor_clone.length;i++){
                    System.out.print((result[i]==true ? 1 : 0) + " ");
                }
                System.out.println();
            }
            answer = Math.max(answer,max);
            //열리는 파이프종류열고 bfs호출
            for(int i=0;i<3;i++){
                type_arr.add(i);
                dfs(n,max,map,monitor_clone,i,k,cnt,type_arr);
                type_arr.remove(type_arr.size()-1);
            }
        }


        class Node{
            int x,y;
            public Node(int x,int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}
