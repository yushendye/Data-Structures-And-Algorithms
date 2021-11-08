import java.util.*;

public class Pattern16 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int stars = 1;
        int spaces = n - 2;
        
        for(int i = 1; i <= n / 2 + 1; i++){
            for(int j = 0; j < stars; j++)
                System.out.print("*\t");
            for(int j = 0; j < spaces; j++)
                System.out.print("\t");
            
            spaces -= 2;
            stars++;
            
            System.out.println();
        }
    }
}