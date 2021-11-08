import java.io.*;
import java.util.*;

public class PostEvalConv{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();
		
		Stack<Integer> value_stack = new Stack<Integer>();
		Stack<String> infix = new Stack<String>();
		Stack<String> prefix = new Stack<String>();
		Stack<Character> operator = new Stack<Character>();

		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);

			if(Character.isDigit(ch)){
				value_stack.push(ch - '0');
				infix.push(ch + "");
				prefix.push(ch + "");

			}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				//calculate as per regular conventions and rules
				int n2 = value_stack.pop();
				int n1 = value_stack.pop();
				int value = calculate(n1, n2, ch);
				value_stack.push(value);


				//calculate infix
				String op = "";
				String val2 = infix.pop();
				String val1 = infix.pop();

				op = "(" + val1 + ch + val2 + ")";
				infix.push(op);

				//calculate prefix
				op = "";
				val2 = prefix.pop();
				val1 = prefix.pop();

				op = ch + val1 + val2;
				prefix.push(op);
			}
		}

		System.out.println(value_stack.peek());
		System.out.println(infix.peek());
		System.out.println(prefix.peek());		
	}

	public static int calculate(int n1, int n2, char op){
		if(op == '+')
			return (n1 + n2);
		else if(op == '-')
			return (n1 - n2);
		else if(op == '*')
			return (n1 * n2);
		else
			return (n1 / n2);
	}

	public static int get_priority(char op){
		if(op == '+' || op == '-')
			return 1;
		else if(op == '*' || op == '/')
			return 2;
		return 0;
	}
}