package BOJ;

import java.util.Scanner;

public class BOJ9661 {

	static long[] arr = new long[21];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		
		
		if(n%5 == 0 || n%5 == 2) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}

}
