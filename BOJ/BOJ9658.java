package BOJ;

import java.util.Scanner;

public class BOJ9658 {

	static int n,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		if(n % 7 == 1 || n % 7 == 3) 
			System.out.println("CY");
		else 
			System.out.println("SK");
	}
}
