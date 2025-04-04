import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int knowManCnt = scan.nextInt();
        //사람을 맵으로해서 어디 파티 가는지 기록
        HashMap<Integer, List<Integer>> personMap = new HashMap<>();
        //파티에 참석자들 기록
        List<List<Integer>> partyList = new ArrayList<>();
        //진실파티 리스트(나중에 CNT변경가능)
        List<Integer> truthPartyList = new ArrayList<>();
        boolean[] partyVisited = new boolean[m+1];
        boolean[] personVisited = new boolean[n+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<knowManCnt;i++){
            int perNum =scan.nextInt();
            q.add(perNum);
            personVisited[perNum] = true;
        }
        for(int i=0;i<m;i++){
            int partyNum = scan.nextInt();
            List<Integer> partyMember = new ArrayList<>();
            for(int j=0;j<partyNum;j++){
                int personNum = scan.nextInt();
                partyMember.add(personNum);
                List<Integer> joinedParty = personMap.getOrDefault(personNum,new ArrayList<>());
                joinedParty.add(i);
                personMap.put(personNum, joinedParty);
            }
            partyList.add(partyMember);
        }
        while (!q.isEmpty()){
            int perNum = q.poll();
            List<Integer> joinedPartyList = personMap.getOrDefault(perNum,new ArrayList<>());
            for(int i=0;i< joinedPartyList.size();i++){
                int partyNum = joinedPartyList.get(i);
                if(!partyVisited[partyNum]){
                    List<Integer> memberList = partyList.get(partyNum);
                    for(int j=0;j<memberList.size();j++){
                        if(!personVisited[memberList.get(j)]){
                            q.add(memberList.get(j));
                            personVisited[memberList.get(j)]=true;
                        }
                    }
                    partyVisited[partyNum]=true;
                    truthPartyList.add(partyNum);
                }
            }
        }
        System.out.println(m-truthPartyList.size());

    }
}
