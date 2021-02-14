package day0210;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		int sum = -100;
		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt(); 
			sum += arr[i];
		}
		
		boolean check = false;
		for(int i=0; i<8 && !check; i++) {
			for(int j=i+1; j<9; j++) {
				if(arr[i] + arr[j] == sum) {
					arr[i] = 300;
					arr[j] = 300; 
					check = true;
				}
			}
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<7; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
