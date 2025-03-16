import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> list = new ArrayList<>();
        if(N==number) return 1;
        for(int i=0;i<9;i++){
            list.add(new HashSet<>());
        }
        list.get(0).add(N);
        for(int i=1;i<8;i++){
            for(int j=0;j<i;j++){
                list.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i+1)));
                // System.out.println(i-j + "," + j);
                for(int a : list.get(i-j-1)){
                    for(int b : list.get(j)){
                        list.get(i).add(a+b);
                        list.get(i).add(a-b);
                        list.get(i).add(a*b);
                        if(b!=0) list.get(i).add(a/b);
                    }
                }
            }
            if (list.get(i).contains(number)){
                return i+1;
            }
            // System.out.println("============");
        }

        return -1;
    }
}