package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2810 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(seat.charAt(i) == 'L') i++;
			ans++;
		}
		if(N > ans+1) 
			System.out.println(ans+1);
		else
			System.out.println(N);
	}
}
