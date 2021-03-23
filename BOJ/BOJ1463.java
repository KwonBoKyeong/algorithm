package BOJ;

import java.util.Scanner;

public class BOJ1463 {
	static int input, ans;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();
		dp = new int[1000001];
		
		for(int i=2; i<=input; i++) {
			
			dp[i] = dp[i-1] + 1;
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3]+1 , dp[i]);
			} 
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
		}
		
		System.out.println(dp[input]);
		
	}

}
