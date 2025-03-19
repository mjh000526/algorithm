import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {

        this.dfs(new ArrayList<Integer>(), 1,n,0,q,ans);

        return answer;
    }
    public void dfs(List<Integer> list,int index, int n,int cnt, int[][]q, int[] ans){
        if(cnt==q[0].length) {
            if(list.size()==q[0].length){
                boolean isRight = true;
                for(int i=0;i<q.length;i++){
                    int sameNumCnt = 0;
                    for(int j=0;j<q[0].length;j++){
                        if(list.contains(q[i][j])){
                            sameNumCnt++;
                        }
                    }
                    if(ans[i]!=sameNumCnt) isRight=false;
                }
                if(isRight==true) {

                    this.answer++;
                }
            }

            return;
        }
        for(;index<=n;index++){
            list.add(index);
            this.dfs(list,index+1,n,cnt+1,q,ans);
            list.remove(list.size()-1);
        }

    }
}