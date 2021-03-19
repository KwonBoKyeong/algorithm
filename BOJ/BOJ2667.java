package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		int cnt = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		
		String s = "";
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j); 
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]== '1' && !visited[i][j]) {
					cnt++;
					//bfs탐색 시작 
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(i, j));
					visited[i][j] = true;
					int house = 0;
					while(!queue.isEmpty()) {
						house++;
						Point now = queue.poll();
						
						for(int d=0; d<4; d++) {
							int nx = now.x + dx[d];
							int ny = now.y + dy[d];

							if(0>nx || nx>=N || 0>ny || ny>=N) continue;
							if(map[nx][ny]=='0' || visited[nx][ny]) continue;
							
							queue.add(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
					
					ans.add(house);
				}
 			}
		}
		
		ans.sort(null);
		
		System.out.println(cnt);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		
		
	}

}
