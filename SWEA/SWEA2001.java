package problem;

import java.util.Scanner;

public class SWEA2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int max = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int sum = 0;
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					sum = 0;
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							sum += arr[k][l];
						}
					}
					if(max < sum)
						max = sum;
				}
			}
			
			
			System.out.println("#" + t + " " + max);
			
		}
		
	}
}
