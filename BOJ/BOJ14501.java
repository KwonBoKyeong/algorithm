package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

	static int[] t, p;
	static int n, ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n+1];
		p = new int[n+1];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken()); 
			p[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dfs(0,0);
		System.out.println(ans);
	}
	
	private static void dfs(int i, int sum) {
		if(i >= n) {
			ans = Math.max(ans, sum);
			return;
		}
		
		if(i + t[i] > n) 
			dfs(i + t[i], sum);
		else 
			dfs(i+t[i], sum+p[i]);
		
		dfs(i+1, sum);
	}

}
