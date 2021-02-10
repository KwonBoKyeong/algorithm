package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA5356 {
	static int T;
	static String[] arr;
	static String s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			arr = new String[5];
			
			int max = 0;
			for(int i=0; i<5; i++) {
				s = br.readLine();
				arr[i] = s;
				if(max < s.length()) max = s.length();
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<max; i++) {
				for(int j=0; j<5; j++) {
					if(arr[j].length() <= i) continue;
					else 
						System.out.print(arr[j].charAt(i));
				}
			}
			System.out.println();
		}
	}
}
