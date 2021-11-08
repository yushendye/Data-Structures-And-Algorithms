import java.io.*;
import java.util.*;

public class ShellRotate{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int row = scn.nextInt();
		int col = scn.nextInt();

		int[][] matrix = new int[row][col];

		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = scn.nextInt();

		int shell_no = scn.nextInt();
		int rotate_by = scn.nextInt();

		rotateBy(matrix, shell_no, rotate_by);
		print(matrix);	
	}

	public static void rotateBy(int[][] matrix, int shell_no, int rotate_by){		
		int[] one_d = getShellOf(matrix, shell_no);
		rotateShell(one_d, rotate_by);
		fillShellBy(matrix, shell_no, one_d);
	}

	public static int[] getShellOf(int[][] matrix, int shell_no){
		int rmin = shell_no - 1;
		int rmax = matrix.length - shell_no;

		int cmin = shell_no - 1;
		int cmax = matrix[0].length - shell_no;

		int size = 2 * (rmax - rmin + cmax - cmin);
		
		int[] one_d = new int[size];
		int index = 0;

		//left wall
		for(int i = rmin, j = cmin; i < rmax; i++)
			one_d[index++] = matrix[i][j];
		

		//bottom wall
		for(int i = rmax, j = cmin + 1; j < cmax; j++)
			one_d[index++] = matrix[i][j];

		//right wall
		for(int i = rmax - 1, j = cmax; i >= rmin; i--)
			one_d[index++] = matrix[i][j];

		//top wall
		for(int i = rmin + 1, j = cmax - 1; j >= cmin + 1; j--)
			one_d[index++] = matrix[i][j];

		return one_d;
	}

	public static void fillShellBy(int[][] matrix, int shell_no, int[] one_d){
		int rmin = shell_no - 1;
		int rmax = matrix.length - shell_no;

		int cmin = shell_no - 1;
		int cmax = matrix[0].length - shell_no;

		int size = 2 * (rmax - rmin + cmax - cmin);			
		int index = 0;

		//left wall
		for(int i = rmin, j = cmin; i < rmax; i++)
			 matrix[i][j] = one_d[index++];
		

		//bottom wall
		for(int i = rmax, j = cmin + 1; j < cmax; j++)
			matrix[i][j] = one_d[index++];

		//right wall
		for(int i = rmax - 1, j = cmax; i >= rmin; i--)
			matrix[i][j] = one_d[index++];

		//top wall
		for(int i = rmin + 1, j = cmax - 1; j >= cmin + 1; j--)
			matrix[i][j] = one_d[index++];
	}

	public static void rotateShell(int[] arr, int n){
		n = n % arr.length;

		if(n < 0)
			n += arr.length;
		reverse(arr, 0, arr.length - n - 1);
		reverse(arr, arr.length - n, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	public static void reverse(int[] arr, int from, int to){
		while (from < to) {
			int t = arr[from];
			arr[from] = arr[to];
			arr[to] = t;

			from++;
			to--;
		}
	}

	public static void print(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}