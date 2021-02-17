package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992 {
	
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j)-'0'; 
			}
		}
		
		//시작점의 x좌표, y좌표, 배열크기
		quadTree(0, 0, N);
		System.out.println(sb);
		
		
	}
	
	static void quadTree(int x, int y, int n) {
		//기저조건 : 네 칸이 모두 같은 경우에 return
		if(check(x, y, n)) {
			sb.append(arr[x][y]);
			return;
		}
		
		sb.append("(");
		//왼쪽 위
		quadTree(x, y, n/2);
		
		//오른쪽 위 
		quadTree(x, y+n/2, n/2);
		
		//왼쪽 아래 
		quadTree(x+n/2, y, n/2);
		
		//오른쪽 아래 
		quadTree(x+n/2, y+n/2, n/2);
		
		
		sb.append(")");
	}
	
	static boolean check(int x, int y, int n) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(arr[x][y] != arr[i][j])
					return false;
			}
		}
		return true;
		
	}
	
	

}
