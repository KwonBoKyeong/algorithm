package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2437 {
	static int n;
	static int[] weight;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		weight = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(weight);
		
		if(weight[0] != 1) {
			System.out.println(1);
			return;
		}
		
		int ans = 1;
			
		for(int i=1; i<n; i++) {
			if(weight[i] > ans + 1) break;
			ans += weight[i];
		}
		
		System.out.println(ans+1);
		
	}

}
