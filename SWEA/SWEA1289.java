package problem;

import java.util.Scanner;

public class SWEA1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			String s = sc.next();
			int size =s.length();
			int ans = 0;
			
			if(s.charAt(0) == '1') ans++;
			
			for(int j=1; j<size; j++) {
				if(s.charAt(j-1) != s.charAt(j)) 
					ans++;
			}
			
			System.out.println("#" + i + " " + ans);
		}
	}

}
