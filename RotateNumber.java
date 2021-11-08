import java.util.*;

public class RotateNumber {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int k = scn.nextInt();
        int n = scn.nextInt();
        
        
        System.out.println(rotate(k, n));
    }
    
    public static long rotate(int n, int k){
        int num_len = String.valueOf(n).length();
        k = k % num_len;
        
        if(k < 0){
            k = k + num_len;
        }
        
        int divisor = (int)Math.pow(10, k);
        int multiplier = (int)Math.pow(10, num_len - k);
        
        int q = n / divisor;
        int r = n % divisor;
        
        return (r * multiplier + q);
    }
}