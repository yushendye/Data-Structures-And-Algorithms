import java.io.*;
import java.util.*;

public class ZeroOneKnapSack{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] values = new int[n];
		for(int i = 0; i < n; i++)
			values[i] = scn.nextInt();

		int[] weights = new int[n];
		for(int i = 0; i < n; i++)
			weights[i] = scn.nextInt();

		int capacity = scn.nextInt();
		System.out.println(getMaxOf(weights, values, capacity));
	}

	public static int getMaxOf(int[] weights, int[] values, int capacity){
		//We have to mazimize the value but should not exceed the capacity
		int[][] cost_matrix = new int[weights.length + 1][capacity + 1];
		for(int i = 1; i < cost_matrix.length; i++){
			for(int j = 1; j < cost_matrix[0].length; j++){
				if(j >= weights[i - 1]){
					int remaining_capacity = j - weights[i - 1];
					if(cost_matrix[i - 1][remaining_capacity] + values[i - 1] > cost_matrix[i - 1][j])
						cost_matrix[i][j] = cost_matrix[i - 1][remaining_capacity] + values[i - 1];
					else
						cost_matrix[i][j] = cost_matrix[i - 1][j];
				}else{
					cost_matrix[i][j] = cost_matrix[i - 1][j];
				}
			}
		}

		return cost_matrix[weights.length][capacity];
	}
}