package day0125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ3040 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = -100;

		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<9; i++) {
			int num = sc.nextInt();
			arr.add(num);
			sum += num;
		}
		
		boolean flag = false;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(arr.get(i)+ arr.get(j)== sum) {
					arr.remove(j);
					arr.remove(i);
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
		
		

	}

}
