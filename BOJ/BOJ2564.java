package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2564 {

	static int r, c, n, a, b; //가로,세로,상점의개수 
	static int[] loc; //상점 위치 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		loc = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			loc[i] = getdist(a,b);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int dg = getdist(a,  b);
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int dist = Math.abs(dg - loc[i]);
			ans += Math.min(dist, (r+c)*2-dist);
		}
		
		System.out.println(ans);
	}
	
	static int getdist(int dir, int idx) {
		if(dir == 1) {
			return idx;
		} else if(dir == 2) {
			return 2*r + c - idx;
		} else if(dir == 3) {
			return 2*r + 2*c - idx;
		} else {
			return r + idx;
		}
	}
	
	
}
