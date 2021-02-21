package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //회의의 수 
		int[][] arr = new int[N][2]; //회의 시간 
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0]-o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int ans = 0;
		int end = 0;
		for(int i=0; i<N; i++) {
			if(arr[i][0] >= end) {
//				System.out.println(arr[i][0] +" " +arr[i][1]);
				end = arr[i][1];
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
