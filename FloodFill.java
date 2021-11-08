import java.io.*;
import java.util.*;

public class FloodFill{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();

		int[][] maze = new int[row][col];
		for(int i = 0; i < row; i++)
			for(int j =  0; j < col; j++)
				maze[i][j] = scn.nextInt();		

		boolean[][] visited = new boolean[row][col];

		floodFill(maze, 0, 0, "", visited);
	}

	public static void floodFill(int[][] matrix, int row, int col, String psf, boolean[][] visited){
		//defining exit conditions
		if(row < 0 || col < 0 || row == matrix.length || col == matrix[0].length || matrix[row][col] == 1 || visited[row][col] == true)
			return;
		else if(row == matrix.length - 1 && col == matrix[0].length - 1){
			System.out.println(psf);
			return;
		}
		//once we get into maze, we can go
		//	1. top -> row decreases, col same
		//	2. left -> row same, col decreases
		//	3. down -> row increases, col same
		//	4. right -> row same, col increases

		//as soon as we visit a node, mark it as visited
		visited[row][col] = true;
		//top
		floodFill(matrix, row - 1, col, psf + "t", visited);

		//left
		floodFill(matrix, row, col - 1, psf + "l", visited);

		//down
		floodFill(matrix, row + 1, col, psf + "d", visited);

		//right
		floodFill(matrix, row, col + 1, psf + "r", visited);
		visited[row][col] = false;
	}
}