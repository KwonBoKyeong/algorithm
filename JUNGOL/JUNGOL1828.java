package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JUNGOL1828 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //화학물질 개수
		int[][] arr = new int[N][2]; //최저보관온도, 최고보관온도 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//y 기준으로 오름차순 정렬! 
		Arrays.sort(arr, new Comparator<int[]> (){
			@Override
			public int compare(int[] c1, int[] c2) {
				return c1[1] - c2[1];
			}
		});
		
		int ans = 1;
		int ref = arr[0][1]; 
		
		for(int i=1; i<N; i++) {
			if(arr[i][0] > ref) {
				ans++;
				ref = arr[i][1];
			}
		}
		
		System.out.println(ans);
		
	}
	
	
}
