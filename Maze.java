import java.io.*;
import java.util.*;

public class Maze{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] maze = new int[r][c];

		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				maze[i][j] = scn.nextInt();

		List<Integer> list = new ArrayList<Integer>();
		getPaths(maze, 0, 0, "", 0, list);
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) < min)
				min = list.get(i);
		}
		System.out.println(min);
	}

	public static void getPaths(int[][] maze, int i, int j, String psf, int sum_of_path, List<Integer> list){
		if(i >= maze.length || j >= maze[0].length)
			return;

		if(i == maze.length - 1 && j == maze[0].length - 1){
			list.add(sum_of_path);	
		}

		//go down in vertical
		getPaths(maze, i, j + 1, "d" + psf, sum_of_path += maze[i][j], list);

		//go forward in horizontal
		getPaths(maze, i + 1, j, "r" + psf, sum_of_path += maze[i][j], list);
		sum_of_path = 0;
	}
}