import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args){
        System.out.println(s());
    }
    static boolean s(){
        String s = ")()(";
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                q.push(s.charAt(i));
            }
            else if(q.isEmpty()){
                return false;
            }
            else q.pop();
        }
        if(!q.isEmpty()) return false;
        return true;
    }
}
