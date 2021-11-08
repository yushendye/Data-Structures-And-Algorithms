import java.io.*;
import java.util.*;

public class MatrixTrans{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				arr[i][j] = scn.nextInt();

		transpose(arr);

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println(
				);
		}
	}

	public static void transpose(int[][] arr) {
		for(int i = 0; i < arr.length; i++)
			for(int j = i; j < arr.length; j++){
				int t = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = t;
			}
	}
}