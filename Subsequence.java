import java.util.*;
import java.io.*;

public class Subsequence{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		showSubSequence(str);
	}

	public static void showSubSequence(String str){
		int possible_subseq = (int) Math.pow(2, str.length());
		for(int i = 0; i < possible_subseq; i++){
			int temp = i;
			String sub_seq = "";
			for(int j = str.length() - 1; j >= 0; j--){
				int d = temp % 2;
				if(d == 0)
					sub_seq = "-" + sub_seq;
				else
					sub_seq = str.charAt(j) + sub_seq;
				temp /= 2;
			}
			System.out.println(sub_seq);
		}
	}

}