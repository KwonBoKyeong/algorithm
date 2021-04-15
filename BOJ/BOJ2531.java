package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2531 {
Queue<Character> queue = new LinkedList<Character>();
	//n:접시수, d:초밥가지수, k:연속해서먹는접시수, c:쿠폰번호 
	static int n, d, k, c;
	static int[] sushi, kind;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[n];
		kind = new int[d];
		for(int i=0; i<n; i++) {
			sushi[i]= Integer.parseInt(br.readLine()); 
		} 
		
		for(int i=0; i<n; i++) {
			kind = new int[3001];
			for(int j=0; j<k; j++) { //연속해서 먹기 
				int idx = i+j;
				if(idx >= n) idx %= n;
				kind[sushi[idx]]++;
			}
			
			kind[c]++;
			
			int ans = 0;
			for(int j : kind) {
				if(j > 0) ans++;
			}
			if(ans > max) max = ans;
			
		}
		System.out.println(max);
	}

}
