package SWEA;

import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486 {

	static int T, N, B, ans;
	static int[] h;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			h = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			getHeight(h, visited, N, 0);
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static void getHeight(int[] arr, boolean[] visited, int n, int idx) {
	    if(idx == n) {
	    	int sum = 0;
	    	for (int i = 0; i < n; i++) {
	            if (visited[i] == true)
	                sum += arr[i];
	        }
	    	
	    	if(sum-B >= 0 && ans > sum-B) {
	    		ans = sum-B;
	    	}
	    	
	        return;
	    }
	 
	    visited[idx] = false;
	    getHeight(arr, visited, n, idx + 1);
	 
	    visited[idx] = true;
	    getHeight(arr, visited, n, idx + 1);
	}

}
