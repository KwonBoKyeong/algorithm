package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int ans = 0;
			int n = Integer.parseInt(br.readLine());
			int v = 0; //초기 속도 
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int com = Integer.parseInt(st.nextToken());
				if(com == 1) {
					v += Integer.parseInt(st.nextToken());
				} else if(com == 2) {
					if(v > 0) 
						v -= Integer.parseInt(st.nextToken());
				}
				ans += v;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
