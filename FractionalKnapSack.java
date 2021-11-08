import java.io.*;
import java.util.*;

public class FractionalKnapSack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] values = new int[n];
        for(int i = 0; i < n; i++)
            values[i] = scn.nextInt();
            
        int[] weights = new int[n];
        for(int i = 0; i < n; i++)
            weights[i] = scn.nextInt();
            
        int capacity = scn.nextInt();
        
        //double max = getMaxKnapSack(weights, values, capacity);
        System.out.println(Integer.MAX_VALUE);
    }
    
    public static double getMaxKnapSack(int[] weights, int[] values, int capacity){
        double[][] max_values = new double[weights.length + 1][capacity + 1];
        double[] wt_per_val = new double[weights.length];
        
        //defining value per weight
        for(int i = 0; i < weights.length; i++)
            wt_per_val[i] = values[i] / weights[i];
        
        
        for(int i = 1; i < max_values.length; i++){
            for(int j = 1; j < max_values[0].length; j++){
                if(j < weights[i - 1]){                    
                    max_values[i][j] = j * wt_per_val[j];
                }else{
                    if(j == weights[i - 1]){                        
                        max_values[i][j] = values[j];
                    }
                    else{
                        double prev = max_values[i - 1][j];
                        double my_score = values[i - 1];
                        double score_by_rest = max_values[i - 1][weights[i - 1]];                        
                        max_values[i][j] = Math.max(prev, my_score + score_by_rest);                        
                    }
                }                
            }
            //printMatrix(max_values);
        }
        
        return max_values[weights.length - 1][capacity];
    }

    public static void printMatrix(double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
        System.out.println("------------------------------------");
    }
}