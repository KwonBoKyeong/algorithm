package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15961 {
	Queue<Character> queue = new LinkedList<Character>();
	//n:접시수, d:초밥가지수, k:연속해서먹는접시수, c:쿠폰번호 
	static int n, d, k, c;
	static int[] sushi, kind;
//	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[n];
		kind = new int[3001];
		
		for(int i=0; i<n; i++) {
			sushi[i]= Integer.parseInt(br.readLine()); 
		} 
		
		int x = 0;
		for(int i=0; i<k; i++) {
			if(kind[sushi[i]] == 0) x++;
			kind[sushi[i]]++;
		}
		int max = x;

		for(int i=1; i<n; i++) {
			if(max <= x) {
				max = x;
				if(kind[c] == 0) //먹었던 초밥이 아닌 경우 
					max++;
			}
			kind[sushi[i-1]] -= 1;
			if(kind[sushi[i-1]] == 0) x--;
			
			if(kind[sushi[(i+k-1) % n]] == 0) x++;
			kind[sushi[(i+k-1) % n]]++;
		}
		System.out.println(max);
	}

}

