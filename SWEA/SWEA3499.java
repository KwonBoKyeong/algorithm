package day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()); 
			String[] card = new String[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++)
				card[i] = st.nextToken();
			
			System.out.print("#" + t + " ");
			
			int sum = (N%2 == 0) ? N/2 : N/2+1;
			for(int i=1; i<= sum; i++) {
				for(int j=i; j<=N; j+=sum) {
					System.out.print(card[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
