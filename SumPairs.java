import java.io.*;
import java.util.*;

public class SumPairs{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		int target = scn.nextInt();

		displayPairs(arr, 0, "", 0, target);		
	}

	public static void displayPairs(int[] arr, int idx, String ans, int sum_so_far, int target){
		//defining exit case
		//1. If sum_so_far > target it obviously means that even if we add more numbers, we won't rich target as all numbers are >0
		if(sum_so_far > target)
			return;

		//2. if we have reached end of array, we can only exit
		if(idx == arr.length){
			if(sum_so_far == target)
				System.out.println(ans);
			return;			
		}
		
		//every elment has 2 options:
		//1. to get added in the sum
		//2. not to get added in the sum

		//1. it decides to get added
		displayPairs(arr, idx + 1, ans + arr[idx] + ", ", sum_so_far + arr[idx], target);

		//2. it decides not to get added
		displayPairs(arr, idx + 1, ans, sum_so_far, target);
		}
	}