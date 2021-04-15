package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
	static int n, k;
	static int[] coin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		
		for(int i=n-1; i>=0; i--) {
			coin[i] = Integer.parseInt(br.readLine()); 
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(k/coin[i] > 0) {
				ans += k/coin[i];
				k %= coin[i];
			}
		}
		System.out.println(ans);
	}

}
