package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2846 {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr= new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken()); 
		}
		
		
		int sum = 0;
		int max = 0;
		for(int i=1; i<n; i++) {
			if(arr[i-1] < arr[i]) sum += (arr[i]-arr[i-1]);
			else {
				max = Math.max(max, sum);
				sum=0;
			}
		}
		
		System.out.println(Math.max(max, sum));
	}

}
