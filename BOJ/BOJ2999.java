package day0205;

import java.util.Scanner;

public class BOJ2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int len = s.length();
		int r = 0, c = 0;
		
		for(int i=(int) Math.sqrt(len); i>0; i--) {
			if(len % i == 0) {
				r = i;
				c = len/i;
				break;
			}
		}
		
		char[][] email = new char[r][c];
		int idx = 0;
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++) {
				email[j][i] = s.charAt(idx); 
				idx++;
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(email[i][j]);
			}
		}
	}

}
