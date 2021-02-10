package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7964 {
	static int T, N, D;
	static int[] country;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			country = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				country[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				cnt++;
				if(country[i] == 1) {
					cnt = 0;
					continue;
				}
				if(cnt == D) {
					ans++;
					cnt = 0;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
