package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
	
	static char[][] arr;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]= ' '; 
			}
		}
		
		star10(0, 0, N);
		
		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void star10(int x, int y, int N) {
		if(N == 1) {
			arr[x][y]= '*'; 
			return;
		}
		
		N /= 3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if (i == 1 && j == 1) continue;
				star10(x+i*N, y+j*N, N);
			}
		}
	}

}
