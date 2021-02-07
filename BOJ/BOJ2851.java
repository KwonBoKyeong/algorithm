package day0205;

import java.awt.Adjustable;
import java.util.Scanner;

public class BOJ2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[10];
		
		for(int i=0; i<10; i++) {
			score[i] = sc.nextInt();
		}
		for(int i=1; i<10; i++) {
			score[i] += score[i-1]; 
			if(score[i]< 100) {
				continue;
			}else if(score[i] == 100) {
				System.out.println(score[i]);
				return;
			}else{
				System.out.println(score[i]-100 <= 100-score[i-1] ? score[i] : score[i-1]);
				return;
			}
		}
		System.out.println(score[9]);
	}
}
