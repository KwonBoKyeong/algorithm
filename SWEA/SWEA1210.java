package problem;

import java.util.Scanner;

public class SWEA1210 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			
			sc.nextInt();
			int[][] arr = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//도착지점 찾기 
			int fin = 0;
			
			for(int i=0; i<100; i++) {
				if(arr[99][i] == 2)
					fin = i;
			}
			
			for(int i=98; i>=0; i--) {
				if(fin-1 >= 0 && arr[i][fin-1] == 1) {
					while(true) {
						fin -= 1;
						if(fin-1 < 0 || arr[i][fin-1] == 0) {
							break;
						}
					}
				} else if(fin+1 <= 99 && arr[i][fin+1] == 1) {
					while(true) {
						fin += 1;
						if(fin+1 > 99 || arr[i][fin+1] == 0) {
							break;
						}
					}
				} else {
					continue;
				}					
			}
			
			//출력 
			System.out.println("#" + t + " " + fin);
		}
	}
}
