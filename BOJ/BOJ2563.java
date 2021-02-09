package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	static int x, y, N;
	static boolean[][] map = new boolean[100][100];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					if(!map[i][j]) {
						ans++;
						map[i][j]= true; 
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}
