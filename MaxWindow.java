import java.io.*;
import java.util.*;

public class MaxWindow{
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
    
    int [] max = new int[arr.length -k + 1];
    int p = 0;
    Stack<Integer> st = new Stack();
    st.push(arr[0]);
    for(int i = 0; i < arr.length -k + 1; i++){
    	st = new Stack<Integer>();
    	st.push(0);
    	for(int j = 0; j < k; j++){
    		if(arr[i + j] > st.peek()){
    			//System.out.println(st.peek() + " < " + arr[i + j]);
    			st.pop();
    			st.push(arr[i + j]);    			
    		}
    	}

    	max[i] = st.peek();    
    }
    for(int i = 0; i < max.length; i++)
    	System.out.print(max[i] + " ");
 }
}