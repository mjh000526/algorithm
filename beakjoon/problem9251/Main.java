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
        int[][] arr = new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }
                else arr[i][j] = Integer.max(arr[i-1][j],arr[i][j-1]);
            }
        }
        int max = -1;
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                max = Integer.max(max,arr[i][j]);
            }
        }
        System.out.println(max);

    }

}