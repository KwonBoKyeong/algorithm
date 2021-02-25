package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1592 {

	static int N, M, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N]; 
		int ans = 0;
		int now = 0;
		arr[now] = 1;
		
		while(true) {
			
			now = (arr[now]%2 == 1) ? now+L : now-L;
			
			if(now >= N) now -= N;
			if(now < 0) now +=N;
			
			arr[now]++;
			ans++;
			if(arr[now] == M) break;
			
			
		}
		
		System.out.println(ans);
		
	}

}
