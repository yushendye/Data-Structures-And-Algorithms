import java.io.*;
import java.util.*;

public class ToLatin{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		printLatin(str);
	}

	public static void printLatin(String str){
		String op = "";
		ArrayDeque<Character> deque = new ArrayDeque<Character>();

		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != ' '){				
				deque.add(str.charAt(i));
			}

			if(str.charAt(i) == ' ' || i == str.length()){				
				char f = deque.peek();
				deque.remove();
				deque.add(f);

				while(deque.size() != 0){
					op += deque.peek();
					deque.remove();
				}

				op += "ay\n";
			}
		}

		if(deque.size() != 0){
			char f = deque.peek();
			deque.remove();
			deque.add(f);

			while(deque.size() != 0){
					op += deque.peek();
					deque.remove();
				}

				op += "ay\n";
		}
		System.out.println(op);
	}
}