import java.util.*;

public class Main { // 파일명과 클래스명이 일치해야 합니다.
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 100;
        int w = 10;
        int num = 30;

        int result = sol.solution(n,w,num);
        System.out.println(result);
    }
    static class Solution {
        public int solution(int n, int w, int num) {
            int answer = 0;
            int ax =0;
            int ay =0;
            int[][] arr = new int[n/w+1][w];
            for(int i=0;i<Math.ceil((double)n/w);i++){
                int cnt=0;
                if(i%2==0){
                    for(int j=0;j<w;j++){
                        int input_num = (i*w)+cnt+1;
                        if(input_num == num){
                            ax = i;
                            ay=j;
                        }
                        cnt++;
                        if(input_num<=n){
                            arr[i][j]=input_num;
                        }
                    }
                }
                else {
                    for(int j=w-1;j>=0;j--){
                        int input_num = (i*w)+cnt+1;
                        cnt++;
                        if(input_num == num){
                            ax = i;
                            ay=j;
                        }
                        if(input_num<=n){
                            arr[i][j]=input_num;
                        }
                    }
                }
            }

            for(int i=ax;i<Math.ceil((double)n/(double)w);i++){
                if(arr[i][ay]!=0) answer++;
            }

            return answer;
        }
    }
}