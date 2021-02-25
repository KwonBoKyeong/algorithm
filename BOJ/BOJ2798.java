package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
	
	static int N, M;
	static int[] card;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 0; //가장 차이가 작은 값 
		
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					int sum = card[i]+ card[j]+ card[k];  
					if(sum == M) {
						System.out.println(sum);
						return;
					}
					if(sum < M && min < sum)
						min = sum;
				}
			}
		}
		
		System.out.println(min);
	}
}
