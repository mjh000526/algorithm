import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String str3 = scan.next();
        int[][][] arr = new int[str1.length()+1][str2.length()+1][str3.length()+1];
        int max = 0;
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                for(int z=1;z<=str3.length();z++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)&&str2.charAt(j-1)==str3.charAt(z-1)){
                        arr[i][j][z] = arr[i-1][j-1][z-1]+1;
                        max = Integer.max(arr[i][j][z],max);
                    }
                    else {
                        arr[i][j][z] = Integer.max(Integer.max(arr[i-1][j][z],arr[i][j-1][z]),arr[i][j][z-1]);
                    }
                }
            }
        }
        System.out.println(max);

    }

}