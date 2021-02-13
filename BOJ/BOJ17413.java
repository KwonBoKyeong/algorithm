package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String ans = "";
		String word = "";
		
		for(int i=0; i<s.length(); i++) {
			
			if(s.charAt(i) == '<') {
				if(word.length() != 0) {
					for(int j=word.length()-1; j>=0; j--) {
						ans += word.charAt(j);
					}
					word = "";
				}
				while(true) {
					ans += s.charAt(i);
					if(s.charAt(i) == '>') break;
					i++;
				}
			} else if(s.charAt(i) == ' ') {
				for(int j=word.length()-1; j>=0; j--) {
					ans += word.charAt(j);
				}
				ans += " ";
				word = "";
			} else word += s.charAt(i);
		}
		
		if(word.length() != 0) {
			for(int j=word.length()-1; j>=0; j--) {
				ans += word.charAt(j);
			}
		}
		
		System.out.println(ans);		

	}

}
