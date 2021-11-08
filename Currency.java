import java.io.*;
import java.util.*;

public class Currency {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
            
        int currency = scn.nextInt();
        getDenomination(arr, currency);
    }
    
    public static void getDenomination(int[] arr, int currency){
        int low = 0;
        int high = arr.length - 1;        
        int mid = 0;
        
        int ceil = 0;
        int floor = 0;

        while(low <= high){
            mid = (low + high) / 2;
            System.out.println("Mid : " + mid);
            if(arr[mid] == currency){
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
            if(currency < mid){
                high = mid - 1;
                floor = arr[mid];
            }
            if(currency > mid){
                low = mid + 1;
                ceil = arr[mid];
            }
        }
        if(ceil != floor){
            System.out.println(ceil);
            System.out.println(floor);
        }else {
            System.out.println(ceil);
        }
    }

}