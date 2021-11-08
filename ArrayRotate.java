import java.io.*;
import java.util.*;

public class ArrayRotate {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void rotate(int[] a, int k) {        
        int[] old = new int[a.length];
        for(int i = 0; i < a.length; i++){
            old[i] = a[i];
        }
        int p = 0;
        for(int i = k - 1; i < a.length; i++){
            a[p] = a[i];
            p++;
        }
        p--;
        for(int i = 0; i < k - 1; i++)
            a[p++] = old[i];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}