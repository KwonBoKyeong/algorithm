package problem;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int t=1; t<=T; t++) {
			
			int dump = sc.nextInt(); //덤프 수 
			int[] arr = new int[100];
			for(int i=0; i<100; i++)
				arr[i] = sc.nextInt();
			
			for(int i=0; i<dump; i++) {
				Arrays.sort(arr);
				
				if(arr[99] - arr[0] <= 1) {
					break;
				}
				
				arr[99]--;
				arr[0]++;
			}
			Arrays.sort(arr);
			System.out.println("#" + t + " " + Integer.toString(arr[99]-arr[0]));
		}
	}

}
