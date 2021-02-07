package day0205;

import java.util.Scanner;

public class BOJ8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int score = 0;
			String s = sc.next();
			
			int cnt = 1;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == 'X') cnt = 1;
				else { 
					score += cnt;
					cnt++;
				}
			}
			
			System.out.println(score);
		}
	}
}
