import java.util.*;
class Solution {
    int max = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visit=new boolean[dungeons.length];
        for(int i=0;i<dungeons.length;i++){
            this.visit[i]=true;
            this.recursion(k,dungeons,i,0);
            // System.out.println("다음단계");
            this.visit[i]=false;
        }

        return this.max;
    }

    public void recursion(int k,int[][] dungeons,int index,int cnt){
        //index>=dungeons.length||
        if(k<dungeons[index][0]){
            return;
        }
        cnt++;
        this.max = Math.max(this.max,cnt==1?0:cnt);

        k-=dungeons[index][1];
        for(int i=0;i<dungeons.length;i++){

            if(this.visit[i]) continue;
            this.visit[i]=true;
            // System.out.println(i+"번째 방문"+k);
            this.recursion(k,dungeons,i,cnt);
            this.visit[i]=false;
        }
    }
}