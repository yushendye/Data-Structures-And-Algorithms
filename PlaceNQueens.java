import java.io.*;
import java.util.Scanner;

public class PlaceNQueens{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] chessboard = new int[n][n];
		placeNQueens(chessboard, "", 0);
	}

	public static void placeNQueens(int[][] chessboard, String qsf, int row){
		//defining exit state!
		if(row == chessboard.length){
			System.out.println(qsf + ".");
			return;
		}
		//we can't put more than 1 queen on board so we will iterate between rows for sure..
		//for a n * n chess board, for 1 row there are n columns		
		for(int col = 0; col < chessboard.length; col++){		//here as n = c, chessboard.length = chessboard[0].length			
			if(isSafe(chessboard, row, col)){
				//put the queen at row, col place
				chessboard[row][col] = 1;
				//call recursive for the next row, i.e for row + 1
				placeNQueens(chessboard, qsf + row + "-" + col + ",", row + 1);
				//don't forget to remove the queen while looking for next row
				chessboard[row][col] = 0;
			}
		}
	}

	//check if is there already a queen sitting in path of newly placed queen
	//if so, don't place new queen there, 
	//otherwise put

	public static boolean isSafe(int[][] chessboard, int row, int col){
		//vertical, row decrements
		for(int i = row - 1, j = col; i >= 0; i--){
			if(chessboard[i][j] == 1)
				return false;
		}

		//left diagonal, row and col decrements
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
			if(chessboard[i][j] == 1)
				return false;
		}

		//right diagonal, row decrements, col increments
		for(int i = row - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++)
			if(chessboard[i][j] == 1)
				return false;

		return true;
	}


}