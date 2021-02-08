package day0208;

import java.util.Scanner;

public class SWEA5215 {

	static int[][] arr; //점수와 칼로리를 담을 배열 
	static int N, L, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			ans = 0;
			N = sc.nextInt(); //재료의 수
			L = sc.nextInt(); //제한 칼로리
			arr = new int[N][2];
			for(int i=0; i<N; i++) {
				arr[i][0] = sc.nextInt(); //점수 
				arr[i][1] = sc.nextInt(); //칼로리 
			}
			
			diet(0, 0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}

	public static void diet(int i, int s, int c) {
		if(c > L) return; 
		else ans = ans >= s ? ans : s;
		if(i == N) return;
		
		diet(i+1, s, c);
		diet(i+1, s+arr[i][0], c+arr[i][1]);
	}
}
