import java.io.*;
import java.util.*;

public class StairPath{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int at_stair = scn.nextInt();
		showPaths(at_stair, "");
		int total_paths = getPaths(at_stair);
		System.out.println(total_paths);
	}

	public static void showPaths(int n, String psf){
		if(n < 0)
			return;
		if(n == 0){
			System.out.println(psf);
			return;
		}

		showPaths(n - 1, 1 + psf);
		showPaths(n - 2, 2 + psf);
		showPaths(n - 3, 3 + psf);
	}

	public static int getPaths(int n, int[] ans){
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;

		if(ans[n] > 0)
			return ans[n];
		System.out.println("Hello " + n);
		int pm1 = getPaths(n - 1, ans);
		int pm2 = getPaths(n - 2, ans);
		int pm3 = getPaths(n - 3, ans);

		int paths = pm1 + pm2 + pm3;
		ans[n] = paths;
		return paths;
	}

	public static int getPaths(int n){
		int[] arr = new int[n + 1];
		arr[0] = 1;

		for(int i = 1; i <= n; i++){
			if(i == 1)
				arr[i] = arr[i - 1];
			else if(i == 2)
				arr[i] = arr[i - 1] + arr[i - 2];
			else
				arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}

		return arr[n];
	}

}