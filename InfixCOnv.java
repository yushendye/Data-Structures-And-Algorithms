import java.io.*;
import java.util.*;

public class InfixCOnv{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();

		String str_postfix = "";
		String str_prefix = "";

		Stack<Character> operator = new Stack<Character>();
		Stack<String> prefix = new Stack<String>();
		Stack<String> postfix = new Stack<String>();

		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);

			if(ch == '(')
				operator.push(ch);
			else if(Character.isLetter(ch)){						
				prefix.push(ch + "");
				postfix.push(ch + "");

				System.out.println("prefix stack : " + prefix);
				System.out.println("postfix stack : " + postfix);
			}else if(ch == ')'){
				while(operator.size() > 0 && operator.peek() != '('){
					//get top 2 elements of infix stack
					String v2 = prefix.pop();
					String v1 = prefix.pop();
					char op = operator.pop();
					System.out.println(op + v1 + v2);
					prefix.push(op + v1 + v2);					

					v2 = postfix.pop();
					v1 = postfix.pop();
					postfix.push(v1+v2+op);
				}
				operator.pop();
			}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				System.out.println("Found operator " + ch);
				while(operator.size() > 0 && operator.peek() != '(' && 
					get_priority(ch) <= get_priority(operator.peek())){
					String v2 = prefix.pop();
					String v1 = prefix.pop();
					char op = operator.pop();
					System.out.println(op + v1 + v2);
					prefix.push(op + v1 + v2);

					v2 = postfix.pop();
					v1 = postfix.pop();
					postfix.push(v1+v2+op);				
				}

				operator.push(ch);
			}
		}

		while(operator.size() > 0){
			String v1 = "";
			String v2 = "";
			
			if(prefix.size() > 0)
				v2 = prefix.pop();
			if(prefix.size() > 0)
				v1 = prefix.pop();

			char op = operator.pop();
			prefix.push(op + v1 + v2);

			if(postfix.size() > 0)
				v2 = postfix.pop();
			if(postfix.size() > 0)
				v1 = postfix.pop();
			postfix.push(v1+v2+op);
		}

		System.out.println("Prefix : " + prefix.peek());
		System.out.println("Postfix : " + postfix.peek());
	}

	public static int get_priority(char ch){
		int p = 0;
		if(ch == '+' || ch == '-')
			p = 1;
		else if(ch == '*' || ch == '/')
			p = 2;

		return p;
	}
}