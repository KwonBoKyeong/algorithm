package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA4789 {

	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int ans = 0;
			int man = 0; //현재 박수 치는 사람 수 
			String s = "0";
			s += br.readLine();

			for(int i=1; i<s.length(); i++) {
				int n = s.charAt(i)-'0';
				man += n;

				if(man < i) {
					ans += (i-man);
					man += (i-man);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		
	}

}
