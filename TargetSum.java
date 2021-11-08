import java.io.*;
import java.util.*;

public class TargetSum {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        int target_sum = scn.nextInt();

        System.out.println(isSumPossible(arr, target_sum));
        
    }

    public static boolean isSumPossible(int[] arr, int target_sum) {
        boolean[][] is_possible = new boolean[arr.length + 1][target_sum + 1];
        
        for(int i = 0; i < is_possible.length; i++){
            for(int j = 0; j < is_possible[0].length; j++){
                if(i == 0 && j == 0)
                    is_possible[i][j] = true;
                else if(i == 0)
                    is_possible[i][j] = false;
                else if(j == 0)
                    is_possible[i][j] = true;
                else{
                    if(is_possible[i -1][j] == true)
                        is_possible[i][j] = true;
                    else{
                        int val = arr[i - 1];
                        if(j >= val){
                            if(is_possible[i - 1][j - val])
                                is_possible[i][j] = true;
                        }
                    }
                }
            }
        }
        
        return is_possible[is_possible.length - 1][target_sum];
    }
}