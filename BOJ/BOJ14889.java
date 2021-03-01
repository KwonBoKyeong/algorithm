package BOJ;
//스타트와 링크 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] person;
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		numbers = new int[N/2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		
		System.out.println(min);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == N/2) {
			person = new boolean[N];
			for(int i=0; i<numbers.length; i++) {
				person[numbers[i]] = true;
			}
			getScore();
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt]= i;
			combination(cnt+1, i+1);
		}
	}

	private static void getScore() {
		int start = 0, link = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N && i!=j; j++) {
				if(person[i] && person[j]) start += (arr[i][j]+ arr[j][i]);
				else if(!person[i] && !person[j]) link += (arr[i][j]+ arr[j][i]);
			}
		}
		
		min = min < Math.abs(link-start) ? min : Math.abs(link-start);
		
	}
}
