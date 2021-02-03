package problem;

import java.util.Scanner;

public class SWEA1209 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int t=0; t<10; t++)
		{
			int T = scanner.nextInt();
			int max = 0;
			int ans = 0;
			
			//가로
			int[][] arr = new int[100][100];
			for(int i=0; i<100; i++) {
				ans = 0;
				for(int j=0; j<100; j++) {
					arr[i][j]= scanner.nextInt(); 
					ans += arr[i][j];
				}
				if(ans > max)
					max = ans;
			}
			
			//세로
			for(int i=0; i<100; i++) {
				ans = 0;
				for(int j=0; j<100; j++) {
					ans += arr[j][i];
				}
				if(ans > max)
					max = ans;
			}
			
			//대각선 
			ans = 0;
			for(int i=0; i<100; i++) {
				ans += arr[i][i];
			}
			if(ans > max)
				max = ans;
			
			//반대 대각선 
			ans = 0;
			for(int i=0; i<100; i++) {
				ans += arr[99-i][i];
			}
			if(ans > max)
				max = ans;
			
			System.out.println("#" + T + " " + max);
		}
		
		
	}

}
