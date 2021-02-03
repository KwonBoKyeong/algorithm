package problem;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1954 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			int num = 1;
			int i=0 ,j=-1;
			
			while(true) {
				for(int a=0; a<size; a++) {
					j += 1;
					arr[i][j] = num;
					num++;
				}
				
				size -= 1;
				if(size == 0) break;
				
				for(int a=0; a<size; a++) {
					i += 1;
					arr[i][j] = num;
					num++;
				}
				
				for(int a=0; a<size; a++) {
					j -= 1;
					arr[i][j] = num;
					num++;
				}
				
				size -= 1;
				if(size == 0) break;
				
				for(int a=0; a<size; a++) {
					i -= 1;
					arr[i][j] = num;
					num++;
				}
				
				
			}
			
			
			System.out.println("#" + t);
			for(int ni=0; ni<arr.length; ni++) {
				for(int nj=0; nj<arr.length; nj++) {
					System.out.print(arr[ni][nj] + " ");
				}
				System.out.println();
			}
			
		}
	}

}
