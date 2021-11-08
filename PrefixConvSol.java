import java.io.*;
import java.util.*;

public class PrefixConvSol{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();

		Stack<Integer> solution = new Stack<Integer>();
		Stack<String> infix = new Stack<String>();
		Stack<String> postfix = new Stack<String>();

		for(int i = exp.length() - 1; i >= 0; i--){
			char ch = exp.charAt(i);

			if(Character.isDigit(ch)){
				solution.push(ch - '0');
				infix.push(ch + "");
				postfix.push(ch + "");
			}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				int n1 = solution.pop();
				int n2 = solution.pop();
				int ans = calculate(n1, n2, ch);
				solution.push(ans);

				String val1 = infix.pop();
				String val2 = infix.pop();
				String op = "(" + val1 + ch + val2 + ")";
				infix.push(op);

				val1 = postfix.pop();
				val2 = postfix.pop();
				op = val1 + val2 + ch;
				postfix.push(op);
			}
		}

		System.out.println(solution.peek());
		System.out.println(infix.peek());
		System.out.println(postfix.peek());
	}

	public static int calculate(int n1, int n2, char op){
		if(op == '+')
			return n1 + n2;
		else if(op == '-')
			return n1 - n2;
		else if(op == '*')
			return n1 * n2;
		else
			return n1 / n2;
	}
}