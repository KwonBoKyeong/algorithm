package BOJ;

import java.util.Scanner;

public class BOJ1149 {

	static int N;
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[N][3]; 
		dp = new int[N][3];
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<3; m++) {
				cost[n][m] = sc.nextInt();
			}
		}
		
		for(int i=0; i<3; i++) {
			dp[0][i] = cost[0][i];
		}
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] , dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0] , dp[i-1][1]) + cost[i][2];
		}
		
		int ans = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
		
		System.out.println(ans);
	}

}
