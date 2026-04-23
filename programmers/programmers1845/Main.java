import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        int[] nums = {3,3,3,2,2,4};
        int n = nums.length/2;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i], 1);
        }
        if(hashMap.size()>=n){
            System.out.println(n);
        }
        else {
            System.out.println(hashMap.size());
        }


    }
}
