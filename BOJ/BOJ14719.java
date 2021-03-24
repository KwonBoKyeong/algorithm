package BOJ;

import java.util.Scanner;

public class BOJ14719 {

	static int W, H;
	static int[] rain;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		rain = new int[H];
		
		for(int i=0; i<H; i++) {
			rain[i]= sc.nextInt(); 
		}
		
		int ans = 0;
		
		for(int i=1; i<H-1; i++) {
			int max_right = 0;
			int max_left = 0;
			
			int pivot = rain[i];
			
			for(int j=0; j<i; j++) {
				if(max_left < rain[j]) max_left = rain[j];
			}
			
			for(int j=i; j<H; j++) {
				if(max_right < rain[j]) max_right = rain[j];
			}
			
			int cnt = Math.min(max_left, max_right) - pivot;
			if(cnt <= 0) continue;
			else ans += cnt;
		}
		
		System.out.println(ans);
	}

}
