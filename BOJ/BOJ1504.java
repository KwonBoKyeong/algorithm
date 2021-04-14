package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1504 {	
	static int n, e, v1, v2; //정점개수, 간선개수 
	static int[][] adj; 

	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		adj = new int[n+1][n+1];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[n1][n2] = cost;
			adj[n2][n1] = cost;
		}
		st = new StringTokenizer(br.readLine(), " ");
		
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		/*** input end ***/
		
		
		//case1. 1 ~> v1 -> v2 ~> n
		int case1 = dijk(1, v1) + dijk(v1, v2) + dijk(v2, n);
		
		//case2. 1 ~> v2 -> v1 ~> n
		int case2 = dijk(1, v2) + dijk(v1, v2) + dijk(v1, n);
		
		int ans = Math.min(case1, case2);
		if(ans == 0) ans = -1;
		System.out.println(ans);
	}
	
	public static int dijk(int start, int end) {
		int[] dist = new int[n+1];
		boolean[] visited = new boolean[n+1];
		
		Arrays.fill(dist, MAX);
		dist[start] = 0;
		
		for(int i=1; i<n+1; i++) {
			int idx = start;
			int min = MAX;
			
			for(int j=1; j<n+1; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			if(idx == end) break;
			for(int j=1; j<n+1; j++) {
				if(!visited[j] && adj[idx][j] != 0 && min + adj[idx][j] < dist[j])
					dist[j] = min + adj[idx][j];
			}
		}
		if(dist[end]== MAX ) dist[end]= 0; 
		return dist[end];
	}

}
