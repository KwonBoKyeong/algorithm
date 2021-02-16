package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(true) {
			if(N % 5 == 0) {
				ans += (N/5);
				break;
			}
			N-=3;
			ans++;
			
			if(N<0) {
				ans = -1;
				break;
			}
		}
		
		System.out.println(ans);
	}

}
