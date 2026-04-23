public class Main {

    public static void main(String[] args){
        int[] a = solution(5000,2000000);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
    static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i=3;i<brown/2;i++){
            int w = i-2;
            int h = (brown-(i*2))/2;

            // System.out.println(i + " : " + w + "," + h);
            if(w*h==yellow){
                answer[0] = w+2;
                answer[1] = h+2;
            }

        }
        return answer;
    }
}
