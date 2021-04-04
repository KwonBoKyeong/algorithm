package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/****** 수강과목 ******/
public class BOJ17845 {

	static int n, k; //최대 공부시간, 과목 수 
	static int[] v, t; //중요도, 필요한 공부시간
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		v = new int[k+1];
		t = new int[k+1];
		dp = new int[k+1][n+1];
		
		for(int i=1; i<=k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			v[i] = Integer.parseInt(st.nextToken());
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				if(j >= t[i]) {
					
					//현재 과목 선택하는 경우 
					int n1 = v[i] + dp[i-1][j-t[i]];
					
					//현재 과목 선택하지 않는 경우 
					int n2 = dp[i-1][j];
					
					dp[i][j]= Integer.max(n1,n2); 
				} else {
					dp[i][j]= dp[i-1][j]; 
				}
			}
		}
		
		System.out.println(dp[k][n]);
	}
}