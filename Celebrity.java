import java.io.*;
import java.util.*;

public class Celebrity{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int no_of_people = scn.nextInt();

		int[][] matrix = new int[no_of_people][no_of_people];

		for(int i = 0; i < no_of_people; i++)
			for(int j = 0; j < no_of_people; j++)
				matrix[i][j] = scn.nextInt();
		boolean found_1 = false;
		Stack<Integer> a_knows = new Stack<Integer>();				
		for(int i = 0; i < no_of_people; i++){
			found_1 = false;
			for(int j = 0; j < no_of_people; j++){				
				if(i != j){
					a_knows.push(i);
					//System.out.println("found " + matrix[i][j] + " at " + i + "," + j);
					if(matrix[i][j] == 1){
						//System.out.println("entering");
						if(a_knows.size() > 0){
							a_knows.pop();							
						}
					}
					break;			
				}
			}
		}
		//System.out.println(a_knows);

		while(a_knows.size() > 1)
			a_knows.pop();

		if(a_knows.size() == 0)		
			System.out.println("none");
		else{			
			boolean is_celebrity = true;
			for(int i = 0; i < no_of_people; i++)
				if(i != a_knows.peek()){
					if(matrix[i][a_knows.peek()] == 0){				
						is_celebrity = false;
					}
				}
			if(is_celebrity)
				System.out.println(a_knows.peek());
			else
				System.out.println("none");
		}		
	}
}