import java.io.*;
import java.util.*;

public class SpiralPrint {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        
        int[][] matrix = new int[r][c];
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                matrix[i][j] = scn.nextInt();
        spiralTraverse(matrix);
    }
    
    public static void spiralTraverse(int[][] matrix){
        int min_row = 0;
        int min_col = 0;
        
        int max_row = matrix.length - 1;
        int max_col = matrix.length - 1;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int count = rows * cols;
        int ctr = 0;
        while(ctr < count){
            //left wall
            for(int i = min_row, j = min_col; i <= max_row && ctr < count; i++){
                System.out.println(matrix[i][j]);
                ctr++;
            }
            min_col++;
            
            //bottom wall
            for(int i = max_row, j = min_col; j <= max_col  && ctr < count; j++){
                System.out.println(matrix[i][j]);
                ctr++;
            }
            max_col--;
            
            //right wall
            for(int i = max_row, j = max_col; i >= min_row && ctr < count; i--){
                System.out.println(matrix[i][j]);
                ctr++;
            }
            min_col++;
            //top wall
            for(int i = min_row, j = max_col; j >= min_col && ctr < count; j--){
                System.out.println(matrix[i][j]);
                ctr++;
            }
            min_row++;
        }
    }

}