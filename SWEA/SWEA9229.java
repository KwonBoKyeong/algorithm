package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {

	static int TC, N, M, W;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1; t<=TC; t++) {
			W = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); //과자 봉지의 개수
			M = Integer.parseInt(st.nextToken()); //무게 합 제한
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int w = arr[i]+ arr[j];
					if(w > M) continue;
					W = w > W ? w : W;
				}
			}
			
			if(W == 0) W = -1;
			System.out.println("#" + t + " " + W);
		}
	}
}
