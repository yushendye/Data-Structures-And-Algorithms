import java.io.*;
import java.util.*;

public class PaintMultiColor {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int houses = scn.nextInt();
        int colors = scn.nextInt();
        
        int[][] cost_matrix = new int[houses][colors];
        for(int i = 0; i < houses; i++)
            for(int j = 0; j < colors; j++)
                cost_matrix[i][j] = scn.nextInt();
        
        
        int[][] dp = new int[houses][colors];
        for(int i = 0; i < colors; i++)
            dp[0][i] = cost_matrix[0][i];
            
        for(int i = 1; i < houses; i++){
            for(int j = 0; j < colors; j++){
                //retrieve minimum from the previous row except for the value at (i, j)
                int[] remaining = new int[colors - 1];
                int p = 0;
                for(int k = 0; k < colors; k++)
                    if(k != j){
                        remaining[p] = cost_matrix[i - 1][k];
                        p++;
                    }
                
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < remaining.length; k++)
                    if(remaining[k] < min)
                        min = remaining[k];
                dp[i][j] = cost_matrix[i][j] + min;
                cost_matrix[i][j] = dp[i][j];
            }
        }
        int min_cost = Integer.MAX_VALUE;
        for(int i = 0; i < colors; i++)
            if(dp[houses - 1][i] < min_cost)
                min_cost = dp[houses - 1][i];
                
        System.out.println(min_cost);
    }
}