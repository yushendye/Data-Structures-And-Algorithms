import java.util.*;

public class MyOperators{
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println(a + " " + b);

		int j = 0;
		int i = 1;

		for(j = i; j < 10; j++){
			System.out.println(j);
			i += 2;
		}
	}	
}