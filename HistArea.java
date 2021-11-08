import java.io.*;
import java.util.*;

public class HistArea{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n];

		for(int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		//code starts here

		int[] right_boundary = new int[arr.length];

		Stack<Integer> st = new Stack<Integer>();
		st.push(arr.length - 1);
		right_boundary[arr.length - 1] = arr.length;

		for(int i = arr.length - 2; i >= 0; i--){
			while (st.size() > 0 && arr[i] <= arr[st.peek()])
				st.pop();

			if(st.size() == 0)
				right_boundary[i] = arr.length;
			else{
				right_boundary[i] = st.peek();
			}

			st.push(i);
		}

		int[] left_boundary = new int[arr.length];
		st = new Stack<Integer>();
		st.push(0);
		left_boundary[0] = -1;

		for(int i = 1; i < arr.length; i++){
			while(st.size() > 0 && arr[i] <= arr[st.peek()]){
				st.pop();
			}

			if(st.size() == 0)
				left_boundary[i] = -1;
			else{
				left_boundary[i] = st.peek();
			}
			st.push(i);
		}
		int max_area = 0;
		for(int i = 0; i < arr.length; i++){
			int width = right_boundary[i] - left_boundary[i] - 1;
			int area = arr[i] * width;

			if(area > max_area)
				max_area = area;
		}

		System.out.println(max_area);
	}
}