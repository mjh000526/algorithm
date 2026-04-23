import java.util.*;
class Solution {
    int cnt;
    public int solution(String[] storage, String[] requests) {
        this.cnt=storage.length*storage[0].length();
        boolean[][] container = new boolean[storage.length+2][storage[0].length()+2];

        for(int i=1;i<=storage.length;i++){
            for(int j=1;j<=storage[0].length();j++){
                container[i][j]=true;
            }
        }
        for(int i=0;i<requests.length;i++){
            if(requests[i].length()==1){
                this.pop(requests[i].charAt(0),storage,container);
            }else {
                this.popAll(requests[i].charAt(0),storage,container);
            }
        }
        return this.cnt;
    }

    public void pop(char alpha,String[] storage,boolean[][] container){
        ArrayDeque<int[]> searchQueue = new ArrayDeque<int[]>();
        boolean[][] visit = new boolean[container.length][container[0].length];
        visit[0][0] = true;
        searchQueue.add(new int[]{0,0});
        while(!searchQueue.isEmpty()){
            int[] searchIndex = searchQueue.poll();
            int x = searchIndex[0];
            int y = searchIndex[1];
            this.search(x-1,y,storage,alpha,searchQueue,container,visit);
            this.search(x+1,y,storage,alpha,searchQueue,container,visit);
            this.search(x,y-1,storage,alpha,searchQueue,container,visit);
            this.search(x,y+1,storage,alpha,searchQueue,container,visit);
        }
    }
    public void popAll(char alpha,String[] storage, boolean[][] container){
        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[0].length();j++){
                if(storage[i].charAt(j)==alpha){
                    storage[i] = storage[i].substring(0,j)+"-"+storage[i].substring(j+1);
                    container[i+1][j+1]=false;
                    this.cnt--;
                }
            }
        }

    }

    public void search(int x,int y,String[] storage, char alpha,ArrayDeque<int[]> searchQueue,boolean[][] container,boolean[][] visit){
        if(x<0||y<0||x>=container.length||y>=container[0].length) return;
        else if(visit[x][y]) return;
        else if(!container[x][y]){
            searchQueue.add(new int[]{x,y});
            visit[x][y]=true;
        }
        else if(x>0&&y>0&&storage[x-1].charAt(y-1)==alpha){
            storage[x-1] = storage[x-1].substring(0,y-1)+"-"+storage[x-1].substring(y);
            container[x][y]=false;
            visit[x][y]=true;
            this.cnt--;
        }

    }

}