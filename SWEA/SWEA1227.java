package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1227 {

	static int[][] map;
	static Point start, end;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			map = new int[100][100];
			visited = new boolean[100][100];
			int ans = 0;
			String str = br.readLine();
			for(int i=0; i<100; i++) {
				str = br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = str.charAt(j)-'0';
					if(map[i][j] == 2) {
						start = new Point(i, j);
					} 
//					else if(map[i][j] == 3) {
//						end = new Point(i, j);
//					}
				}
			}
			
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(start);
			visited[start.x][start.y] = true;
			
			while(!queue.isEmpty()) {
				Point now = queue.poll();
				int x = now.x;
				int y = now.y;
				if(map[x][y] == 3 ) {
					ans = 1;
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(0>nx || 0>ny || nx>=100 || ny>=100) continue;
					if(visited[nx][ny] || map[nx][ny] ==1) continue;
					
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
					
				}
			}
			
			
			
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
