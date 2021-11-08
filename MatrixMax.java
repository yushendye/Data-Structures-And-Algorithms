import java.io.*;
import java.util.*;

public class MatrixMax{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();

		int[][] matrix = new int[row][col];
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				matrix[i][j] = scn.nextInt();

		int i = scn.nextInt();
		int j = scn.nextInt();

		System.out.println(maxFromPos(matrix, i, j, 0));
	}

	//initiallt, put sum = 0
	public static int maxFromPos(int[][] matrix, int i, int j, int sum){
		//we can traverse in 8 different directions
		//upper left -> (i - 1, j - 1)
		//just upper -> (i - 1, j)
		//upper right -> (i - 1, j + 1)
		//just left -> (i, j - 1)
		//just right -> (i, j + 1)
		//down left -> (i + 1, j - 1)
		//just down -> (i + 1, j)
		//down right -> (i + 1, i + 1)

		//we exit when i and j both < 0 or if i and j both > row

		int max_pos = matrix.length;
		System.out.println("We are currently at " + matrix[i][j]);

		if((i == 0 && j == 0) || (i == max_pos && j == max_pos))
			return matrix[i][j];

		if((i < 0 && j < 0) || (i > max_pos && j > max_pos))
			return 0;

		if(i > 0 && j > 0){
			int p1 = maxFromPos(matrix, i - 1, j - 1, Math.max(sum, sum + matrix[i - 1][j - 1]));
			int p2 = maxFromPos(matrix, i - 1, j, Math.max(sum, sum + matrix[i - 1][j]));
			int p3 = maxFromPos(matrix, i - 1, j + 1, Math.max(sum, sum + matrix[i - 1][j + 1]));
			int p4 = maxFromPos(matrix, i, j - 1, Math.max(sum, sum + matrix[i][j - 1]));
			int p5 = maxFromPos(matrix, i, j + 1, Math.max(sum, sum + matrix[i][j + 1]));
			int p6 = maxFromPos(matrix, i + 1, j - 1, Math.max(sum, sum + matrix[i + 1][j - 1]));
			int p7 = maxFromPos(matrix, i + 1, j, Math.max(sum, sum + matrix[i + 1][j]));
			int p8 = maxFromPos(matrix, i + 1, j + 1, Math.max(sum, sum + matrix[i + 1][j + 1]));
		}
		System.out.println("Sum = " + sum);

		return sum;
	}
}