package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1249 {
	
	static int T, N;
	static int[][] map;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j) -'0'; 
					arr[i][j] = Integer.MAX_VALUE; 
				}
			}
			
			int ans = Integer.MAX_VALUE;
			
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(0, 0));
			arr[0][0] = 0;
			
			while(!queue.isEmpty()) {
				Point now = queue.poll();
				
				if(now.x == N-1 && now.y == N-1) {
					if(ans > arr[N-1][N-1]) 
						ans = arr[N-1][N-1];
				}
				
				for(int d=0; d<4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					
					if(0>nx || nx>=N || 0>ny || ny>=N) continue;
					if(arr[nx][ny] != Integer.MAX_VALUE && arr[nx][ny] <= arr[now.x][now.y] + map[nx][ny]) continue;
					
					arr[nx][ny] = arr[now.x][now.y] + map[nx][ny];
					queue.add(new Point(nx, ny));
//					System.out.println("[" + nx+ "]" + "[" + ny+ "]" + " = " + arr[nx][ny]);
				}
			}
//			for(int i=0; i<4; i++) {
//				for(int j=0; j<4; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

