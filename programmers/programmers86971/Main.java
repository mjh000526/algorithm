import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        for(int i=0;i<wires.length;i++){
            ArrayDeque<Integer> q = new ArrayDeque<Integer>();
            boolean[] visited = new boolean[n+1];
            q.add(1);
            int cnt = 1;
            visited[1]=true;
            System.out.println(1);
            while(!q.isEmpty()){
                int checkNum = q.poll();
                for(int x=0;x<wires.length;x++){
                    if(x==i) continue;
                    else if(wires[x][0]==checkNum&&visited[wires[x][1]]==false){
                        cnt++;
                        visited[wires[x][1]] = true;
                        q.add(wires[x][1]);
                    }
                    else if(wires[x][1]==checkNum&&visited[wires[x][0]]==false){
                        cnt++;
                        visited[wires[x][0]] = true;
                        q.add(wires[x][0]);
                    }
                }
            }

            answer = Math.min(Math.abs(n-cnt-cnt),answer);
        }
        return answer;
    }
}