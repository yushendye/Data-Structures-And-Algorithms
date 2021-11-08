import java.io.*;
import java.util.*;

public class RainTrap{
	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

		System.out.println(trap(arr));
	}

	public static int[] maxToLeft(int[] arr){

	}

	public static int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int capacity = 0;
        
        for(int i = 0; i < height.length; i++){
            int current = height[i];
            
            if(st.size() == 0)
                st.push(current);
            else if(st.peek() <= current)
                st.push(current);
            else{
                capacity += st.pop() - current;
            }

            System.out.println("Stack : " + st);
        }
        
        while(st.size() != 0){
        	System.out.println("Adding " + st.peek());
            capacity += st.pop();
        }
        
        return capacity;
    }
}