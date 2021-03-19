package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10819 {

	static int N, ans = Integer.MIN_VALUE;
	static int[] arr, numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		numbers = new int[N];
		isSelected = new boolean[N];
		
		permutation(0);
		
		System.out.println(ans);
		
	}
	
	private static void permutation(int cnt) {
		
		if(cnt == N) {
			int sum = 0;
			
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(numbers[i]- numbers[i+1]);
			}
			
			ans = sum > ans? sum : ans;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = arr[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false; 
 		}
		
	}

}
