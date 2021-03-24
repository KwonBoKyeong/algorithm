package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {

	static int R, C, cnt, ans; 
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cheese = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<C; c++) {
				cheese[r][c] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int time = 0;
		while(true) {
			cnt = 0;
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(cheese[r][c] == 1) cnt++;
				}
			}
			if(cnt == 0) break;
			
			time++;
			ans = cnt;
			visited = new boolean[R][C];
			
			Queue<Pos> queue = new LinkedList<>();
			queue.add(new Pos(0, 0));
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {
				Pos now = queue.poll();
				int x = now.x;
				int y = now.y;
				
				for(int d=0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if(0 > nx || nx >= R || 0 > ny || ny >= C || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					//공기 만나는 경우 확장 
					if(cheese[nx][ny] == 0) {
						queue.add(new Pos(nx,ny));
					} 
					//치즈 만나는 경우 녹이기 
					else if(cheese[nx][ny] == 1) {
						cheese[nx][ny] = 0;
					}
				}
			}
		}
		
		System.out.println(time + "\n" + ans);
	}
}
