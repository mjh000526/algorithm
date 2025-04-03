import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        scan.nextLine();

        for(int i=0;i<n;i++){
            String[] str = scan.nextLine().split(" ");
            aList.add(Integer.valueOf(str[0]));
            bList.add(Integer.valueOf(str[1]));
        }

        for(int i=0;i<n;i++){
            int request = aList.get(i);
            int answer = bList.get(i);
            ArrayDeque<Pair> q = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            Set<Integer> set = new HashSet<>();
            q.add(new Pair(request,""));
            while (!q.isEmpty()){
                Pair pair = q.poll();
                int value = pair.value;
                String cmd = pair.cmd;
                pair = cmdD(value,cmd);

                if(pair.value==answer){
                    System.out.println(pair.cmd);
                    break;
                }
//                if(!visited[pair.value]) {
//                    visited[pair.value] = !visited[pair.value];
//                    q.add(pair);
//                }
                if(!set.contains(pair.value)){
                    set.add(pair.value);
                    q.add(pair);
                }



                pair = cmdS(value,cmd);
                if(pair.value==answer){
                    System.out.println(pair.cmd);
                    break;
                }
//                if(!visited[pair.value]) {
//                    visited[pair.value] = !visited[pair.value];
//                    q.add(pair);
//                }
                if(!set.contains(pair.value)){
                    set.add(pair.value);
                    q.add(pair);
                }

                pair = cmdL(value,cmd);
                if(pair.value==answer){
                    System.out.println(pair.cmd);
                    break;
                }
//                if(!visited[pair.value]) {
//                    visited[pair.value] = !visited[pair.value];
//                    q.add(pair);
//                }
                if(!set.contains(pair.value)){
                    set.add(pair.value);
                    q.add(pair);
                }

                pair = cmdR(value,cmd);
                if(pair.value==answer
                ){
                    System.out.println(pair.cmd);
                    break;
                }
//                if(!visited[pair.value]) {
//                    visited[pair.value] = !visited[pair.value];
//                    q.add(pair);
//                }
                if(!set.contains(pair.value)){
                    set.add(pair.value);
                    q.add(pair);
                }
            }
        }
    }
    public static class Pair{
        int value;
        String cmd;
        public Pair(int value,String cmd){
            this.value = value;
            this.cmd = cmd;
        }
    }
    public static Pair cmdD(int value,String cmd){
        value*=2;
        if(value>9999) value%=10000;
        return new Pair(value, cmd+"D");
    }
    public static Pair cmdS(int value,String cmd){

        value-=1;
        if(value==-1) value=9999;
        return new Pair(value, cmd+"S");
    }
    public static Pair cmdL(int value,String cmd){
        return new Pair((value % 1000) * 10 + value / 1000,cmd+"L");
    }
    public static Pair cmdR(int value,String cmd){
        return new Pair((value % 10) * 1000 + value / 10,cmd+"R");
    }
}