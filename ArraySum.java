import java.io.*;
import java.util.*;

public class ArraySum {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int size1 = scn.nextInt();
        int[] arr1 = new int[size1];
        
        for(int i = 0; i < size1; i++)
            arr1[i] = scn.nextInt();
            
        int size2 = scn.nextInt();
        int[] arr2 = new int[size2];
        
        for(int i = 0; i < size2; i++)
            arr2[i] = scn.nextInt();
            
        System.out.println(getSumOf(arr1, arr2));
    }
    
    public static int getSumOf(int[] arr1, int[] arr2){
        int sum = 0;
        int carry = 0;
        int p = 1;
        
        int size1 = arr1.length - 1;
        int size2 = arr2.length - 1;
        
        while(size1 > 0 || size2 > 0 || carry > 0){
            int d = arr1[size1] + arr2[size2] + carry;
            
            carry = d % 10;
            d /= 10;
            
            if(size1 > 0)
                size1--;
            if(size2 > 0)
                size2--;
            
            sum = sum + d * p;
            p *= 10;
        }
        
        return sum;
    }

}