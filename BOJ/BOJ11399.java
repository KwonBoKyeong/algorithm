package day0205;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] time = new int[N];
		
		for(int i=0; i<N; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time);
		int ans = 0;
		
		for(int i=0; i<time.length; i++) {
			ans += (N*time[i]);
			N--;
		}
		
		System.out.println(ans);
		
	}

}
