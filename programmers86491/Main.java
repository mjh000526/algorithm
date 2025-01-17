public class Main {
    public static void main(String[] args){
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
//        System.out.println(solution([[60, 50], {30, 70}, {60, 30}, [80, 40]]));
    }

    public static int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int t = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] =t;
            }
            x = Math.max(sizes[i][0],x);
            y = Math.max(sizes[i][1],y);
        }
        return x*y;
    }
}
