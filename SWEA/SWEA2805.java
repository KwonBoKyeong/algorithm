package problem;

import java.util.Scanner;

public class SWEA2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int ans = 0;
			
			for(int i=0; i<N; i++) {
				String str = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			for(int i=0; i<=N/2; i++) {
				for(int j=N/2-i; j<=N/2+i; j++) {
					ans += arr[i][j];
					System.out.println(arr[i][j]);
				}
			}
			
			for(int i=N/2+1; i<N; i++) {
				for(int j=N/2-(N-i)+1; j<N/2+(N-i); j++) {
					ans += arr[i][j];
					System.out.println(arr[i][j]);
				}
			} 
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
