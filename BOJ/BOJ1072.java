package BOJ;

import java.util.Scanner;

public class BOJ1072 {

	static long x, y, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		double z = y*100/x;
		
		if(z+1 >= 100){
			ans = -1;
			
		} else {
			z += 1;
			
//			System.out.println((x*z-100*y) / (100-z));
			ans = (long) Math.ceil((x*z-100*y) / (100-z));
		}
		System.out.println(ans);
	}

}
