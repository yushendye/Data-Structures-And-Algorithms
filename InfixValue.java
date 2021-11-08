import java.io.*;
import java.util.*;

public class InfixValue{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();

		Stack<Integer> operand_st = new Stack<Integer>();
		Stack<Character> operator_st = new Stack<Character>();

		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);

			if(ch == '(')
				operator_st.push(ch);
			else if(Character.isDigit(ch)){
				operand_st.push(ch - '0');
			}
			else if(ch == ')'){
				while(operator_st.size() != 0 && operator_st.peek() != '('){
					int n2 = operand_st.pop();
					int n1 = operand_st.pop();
					char op = operator_st.pop();

					int ans = operation(n1, n2, op);
					operand_st.push(ans);
				}
				operator_st.pop();
			}else if(ch == '+' || ch == '-' || ch == '*' || ch== '/'){
				while(operator_st.size() > 0 && getPriority(ch) <= getPriority(operator_st.peek()) && 
					operator_st.peek() != '('){
					int n2 = operand_st.pop();
					int n1 = operand_st.pop();
					char op = operator_st.pop();

					int ans = operation(n1, n2, op);
					operand_st.push(ans);
				}
				operator_st.push(ch);
			}
		}

		while(operator_st.size() > 0){
			int n1 = 0, n2 = 0;
			if(operand_st.size() != 0)
				n2 = operand_st.pop();
			if(operand_st.size() != 0)
				n1 = operand_st.pop();
			char op = operator_st.pop();

			int ans = operation(n1, n2, op);
			operand_st.push(ans);
		}

		System.out.println(operand_st.peek());
	}

	public static int getPriority(char op){
		if(op == '+' || op == '-')
			return 1;
		if(op == '*' || op == '/')
			return 2;
		else
			return 3;
	}

	public static int operation(int num1, int num2, char op){
		switch(op){
			case '+':
				return num1 + num2;
			case '-':
				return num1 - num2;
			case '*':
				return num1 * num2;
			case '/':
				return num1 / num2;				
			default:
				return 0;
		}
	}
}