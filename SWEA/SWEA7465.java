package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7465 {
	
	static int T, N, M, a, b, ans;
	static boolean[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new boolean[N+1][N+1];
			visited = new boolean[N+1];
			ans = 0;
			
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				arr[a][b] = arr[b][a] = true;  
			}
			
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {//아직 무리에 속하지 않은 경우
					ans++;
					
					//무리 탐색 시작이에오 
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.add(i);
					visited[i] = true;
					
					while(!queue.isEmpty()) {
						int now = queue.poll();
						
						for(int k=1; k<=N; k++) {
							if(arr[now][k] && !visited[k]) { //서로 알고 있는 관계 !
								queue.add(k);
								visited[k] = true;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

}
