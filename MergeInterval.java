import java.io.*;
import java.util.*;

public class MergeInterval{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[][] matrix = new int[n][2];

		for(int i = 0; i < n; i++){
				matrix[i][0] = scn.nextInt();
				matrix[i][1] = scn.nextInt();
		}
		Pair[] pairs = new Pair[n];
		for(int i = 0; i < n; i++){
			pairs[i] = new Pair(matrix[i][0], matrix[i][1]);
		}

		Arrays.sort(pairs);
		Stack<Pair> st = new Stack<Pair>();

		for(int i = 0; i < pairs.length; i++){
			if(i == 0)
				st.push(pairs[i]);
			else{
				Pair top = st.peek();
				if(pairs[i].start > top.end)
					st.push(pairs[i]);
				else{
					top.end = Math.max(pairs[i].end, top.end);
				}
			}
		}

		Stack<Pair> op = new Stack<Pair>();
		while(st.size() != 0)
			op.push(st.pop());

		while(op.size() != 0){
			Pair top = op.pop();
			System.out.println(top.start + " " + top.end);
		}
	}

	static class Pair implements Comparable<Pair>{
		int start;
		int end;

		public Pair(int start, int end){
			this.start = start;
			this.end = end;
		}

		public int compareTo(Pair other){
			if(this.start != other.start)
				return this.start - other.start;
			else return this.end - other.end;
		}
	}
}