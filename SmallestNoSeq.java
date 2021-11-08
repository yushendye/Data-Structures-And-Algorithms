import java.io.*;
import java.util.*;

public class SmallestNoSeq{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		Stack<Integer> st = new Stack<Integer>();

		String min_no = getMinNo(str);
	}

	public static String getMinNo(String str){
		int[] nums = new int[str.length()];

		nums[nums.length - 1] = str.length() - 1;
		nums[0] = str.length() + 2 - nums[nums.length - 1];

		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);

		return "";
	}
}