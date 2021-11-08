import java.io.*;
import java.util.*;

public class KnightsTour{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();
		int c = scn.nextInt();

		int[][] chessboard = new int[n][n];
		knightsTour(chessboard, r, c, 1);
	}

	public static void knightsTour(int[][] chessboard, int row, int col, int move){
		//defining exit condition
		//1. If col / row is at 0, it means the knight is placed on the edge
		//1. And if chessboard[row][col] is not 0, it means the knight has already been there once
		if(row < 0 || col < 0 || row >= chessboard.length || col >= chessboard.length || chessboard[row][col] != 0)
			return;

		//2. If move = chessboard.length * chessboard.length, it means the knights has traversed all the places
		if(move == chessboard.length * chessboard.length){
			chessboard[row][col] = move;
			displayBoard(chessboard);
			chessboard[row][col] = 0;

			return;
		}

		//A knight at a position has 8 different possibilities
		//suppose a knight is placed at (2, 2)
		//now possible places are : (0, 3), (1, 4), (3, 4), (4, 3), (4, 1), (3, 0), (1, 0) and (0, 1)
		//after reaching at new place, it again can be moved to 8 places
		chessboard[row][col] = move;
		knightsTour(chessboard, row - 2, col + 1, move + 1); //(0, 3)
		knightsTour(chessboard, row - 1, col + 2, move + 1); //(1, 4)
		knightsTour(chessboard, row + 1, col + 2, move + 1); //(3, 4)
		knightsTour(chessboard, row + 2, col + 1, move + 1); //(4, 3)
		knightsTour(chessboard, row + 2, col - 1, move + 1); //(4, 1)
		knightsTour(chessboard, row + 1, col - 2, move + 1); //(3, 0)
		knightsTour(chessboard, row - 1, col - 2, move + 1); //(1, 0)
		knightsTour(chessboard, row - 2, col - 1, move + 1); //(0, 1)
		chessboard[row][col] = 0;
	}

	public static void displayBoard(int[][] chessboard){
		for(int i = 0; i < chessboard.length; i++){
			for(int j = 0; j < chessboard.length; j++)
					System.out.print(chessboard[i][j] + "\t");
			System.out.println();
		}
		System.out.println("\n");
	}
}