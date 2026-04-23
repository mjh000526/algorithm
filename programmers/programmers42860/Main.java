public class Main {
    static public void main(String[] args){
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    static public int solution(String name) {
        int answer = 0;
        int cnt = 1;
        boolean[] visit = new boolean[name.length()];

        for(int i=0;i<name.length();i++){
            int c = name.charAt(i) - 65;
            answer += Math.min(c,25-c+1);
//            System.out.println((char)(c+65)+"("+c + ") : "  + Math.min(c,25-c+1));
            if(c==0) {
                cnt++;
                visit[i]=true;
            }
        }

        visit[0] = true;

        int cursor = 0;
        while (cnt<name.length()){
            int i = cursor;
            int j = cursor;
            int front = 0;
            int back = 0;
            while(visit[i]){
                i++;
                front++;
                if(i==name.length()){
                    i=0;
                }
//                System.out.println("처음" + i + ", visit : " + visit[i] + ", char : " + name.charAt(i) + "cnt" + cnt);
            }
            while(visit[j]){
                j--;
                back++;
                if(j==-1){
                    j=name.length()-1;
                }
            }
            if(back<front){
                cursor=j;
                answer+=back;
                visit[j]=true;
//                System.out.println("back");
            }
            else {
                cursor=i;
                answer+=front;
                visit[i]=true;
//                System.out.println("front : " + front);
            }
            cnt++;
        }

        return answer;
    }
}
