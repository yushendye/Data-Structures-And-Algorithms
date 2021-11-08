import java.io.*;
import java.util.Scanner;

public class MaxPath{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[][] matrix = new int[n][n];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				matrix[i][j] = scn.nextInt();

		//System.out.println(getMaxPathUp(matrix));
		System.out.println(getMaxPathDn(matrix, 0, 0, 0));
		//System.out.println(getMaxPathBi(matrix));
	}

	public static int getMaxPathDn(int[][] matrix, int i, int j, int sum){
		int n = matrix.length;

		if(i == n - 1 && j == n - 1)
			sum = Math.max(sum, sum + matrix[i][j]);

		if(i == n && j == n)
			return sum;

		int sum_left = 0, sum_dn = 0, sum_rt = 0;
		if(i > 0 && j > 0){
			sum_left = getMaxPathDn(matrix, i + 1, j - 1, sum + matrix[i + 1][j - 1]);
			sum_dn = getMaxPathDn(matrix, i + 1, j, sum + matrix[i + 1][j]);
			sum_rt = getMaxPathDn(matrix, i + 1, j + 1, sum + matrix[i + 1][j + 1]);
		}
		
		return Math.max(sum_left, Math.max(sum_dn, sum_rt));
	}
}