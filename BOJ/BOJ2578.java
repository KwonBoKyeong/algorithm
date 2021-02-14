package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2578 {

	static int[][] map = new int[5][5];
	static boolean[][] check = new boolean[5][5];
	static int cnt=0, ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//빙고판 초기화 
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++)
				map[i][j] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken()); 
				ans++;
				find(num);
				if(cnt >= 3) {
					System.out.println(ans);
					return;
				}
			}
		}
		
		System.out.println(ans);

	}
	
	static void find(int num) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j] == num) {
					check[i][j] = true;
					
					//가로 빙고 확인 
					boolean row = true;
					for(int k=0; k<5; k++)
						if(!check[i][k]) row = false;
					if(row == true) cnt++;
					
					//세로 빙고 확인 
					boolean col = true;
					for(int k=0; k<5; k++)
						if(!check[k][j]) col = false;
					if(col == true) cnt++;
					
					//대각선 빙고 확인 
					boolean diag = true;
					if(i == j) {
						for(int k=0; k<5; k++)
							if(!check[k][k]) diag = false;
						if(diag == true) cnt++;
					}
					
					diag = true;
					if(i+j == 4) {
						for(int k=0; k<5; k++)
							if(!check[k][4-k]) diag = false;
						if(diag == true) cnt++;
					}
					
					return;
				}
			}
		}
	}
}
