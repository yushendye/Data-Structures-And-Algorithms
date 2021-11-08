import java.io.*;
import java.util.*;

public class MatMul {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int mat1_row = scn.nextInt();
        int mat1_col = scn.nextInt();

        int[][] mat1 = new int[mat1_row][mat1_col];
        for (int i = 0; i < mat1.length; i++)
            for (int j = 0; j < mat1[i].length; j++)
                mat1[i][j] = scn.nextInt();

        int mat2_row = scn.nextInt();
        int mat2_col = scn.nextInt();
        int[][] mat2 = new int[mat2_row][mat2_col];
        for (int i = 0; i < mat2.length; i++)
            for (int j = 0; j < mat2[i].length; j++)
                mat2[i][j] = scn.nextInt();

        if (mat1_col != mat2_row)
            return;

        int[][] product = getProductOf(mat1, mat2);

        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[i].length; j++)
                System.out.print(product[i][j] + " ");

            System.out.println();
        }
    }

    public static int[][] getProductOf(int[][] m1, int[][] m2) {
        int[][] product = new int[m1.length][m2[0].length];

        for (int i = 0; i < product.length; i++)
            for (int j = 0; j < product[0].length; j++)
                for (int k = 0; k < m2[0].length; k++)
                    product[i][j] += m1[i][k] * m2[k][j];

        return product;
    }
}