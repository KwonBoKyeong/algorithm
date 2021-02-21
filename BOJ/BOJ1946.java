package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1946 {

	static int T, N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수 
		for(int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine()); //지원자의 수 
			int[][] arr = new int[N][2]; //지원자의 서류심사, 면접 성적 순위 
			int ans = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//서류기준 오름차순 정렬 
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				if(arr[i][1] < min) {
					ans++;
					min = arr[i][1];
				}
			}
			
			System.out.println(ans);
		}
		
	}
}
