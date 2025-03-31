import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> orderList = new ArrayList<>();
        List<ArrayDeque<String>> arrList = new ArrayList<>();
        for(int i=0;i<n;i++){
            orderList.add(scan.nextLine());
            int size = Integer.parseInt(scan.nextLine());
            if(size==0){
                scan.nextLine();
                arrList.add(new ArrayDeque<>());
                continue;
            }
            StringBuilder sb = new StringBuilder(scan.nextLine());
            String str = sb.deleteCharAt(sb.length()-1).deleteCharAt(0).toString();
            arrList.add(new ArrayDeque<>(List.of(str.split(","))));

        }
        for(int i=0;i<n;i++){
            ArrayDeque<String> queue = arrList.get(i);
            String orderCmd = orderList.get(i);
            boolean reverseMode = false;
            boolean error = false;

            for(int j=0;j<orderCmd.length();j++){

                if(orderCmd.charAt(j)=='R'){

                    reverseMode = !reverseMode;
                }
                else{
                    if (queue.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                    else if (reverseMode == false) {
                        queue.poll();
                    } else {
                        queue.removeLast();
                    }
                }
            }
            if(error==false){
                System.out.print("[");
                if(!queue.isEmpty()){
                    if(reverseMode==false) System.out.print(queue.poll());
                    else System.out.print(queue.removeLast());
                    while (!queue.isEmpty()){
                        if(reverseMode==false) System.out.print("," + queue.poll());
                        else System.out.print("," + queue.removeLast());
                    }
                }
                System.out.println("]");
            }

        }
    }
}
