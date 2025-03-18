import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i=0;i<visit.length;i++){
            if(visit[i]==true) continue;
            answer++;
            ArrayDeque<Integer> q = new ArrayDeque<Integer>();
            q.add(i);
            visit[i]=true;
            while(!q.isEmpty()){
                int com = q.poll();
                for(int x=0;x<n;x++){
                    if(computers[com][x]==1&&visit[x]==false){
                        visit[x]=true;
                        q.add(x);
                    }
                }
            }
        }
        return answer;
    }
}