package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {

	static int t, n, w, h;
	static int[][] map, tmp;
	static int[] ball, arr; //구슬 쏠 곳 순서
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int ans;
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 구슬 쏘는 횟수
			w = Integer.parseInt(st.nextToken()); // w -> j
			h = Integer.parseInt(st.nextToken()); // h -> i
			map = new int[h][w];
			tmp = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			////////////////// 인풋 끝 ///////////////////////
			
			// step1: 구슬 순서대로 어느 열에 쏠건지 정해 -> 그건 중복순열 
			ball = new int[n];
			arr = new int[w];
			for(int i=0; i<w; i++) {
				arr[i] = i; 
			}
			
			ppp(0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void ppp(int cnt) {
		if(cnt == n) {
			//중복순열 구했으니까 구슬 쏘자 
			shoot();
			return;
		}
		
		for(int i=0; i<w; i++) {
			ball[cnt]= arr[i];
			ppp(cnt+1);
		}
	}

	// step2: 구슬 쏘기 
	private static void shoot() {
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				tmp[i][j]= map[i][j];
			}
		}

		for(int b=0; b<ball.length; b++) { // 구슬 개수만큼 쏜다 
			
			int nowBall = ball[b];
			Queue<Point> queue = new LinkedList<>();
			visited = new boolean[h][w];

			// 맨 위의 벽돌 
			int start = -1;
			for(int i=0; i<h; i++) {
				if(tmp[i][nowBall] != 0) {
					start = i;
					break;
				}
			}
			
			if(start >= 0) {
				// 1인 경우 바로 깨짐 
				if(tmp[start][nowBall] == 1)
					tmp[start][nowBall] = 0;
				
				else { // 1보다 큰 경우 
					queue.add(new Point(start, nowBall));
					visited[start][nowBall] = true;
				
					while(!queue.isEmpty()) {
						Point point = queue.poll();
						
						int num = tmp[point.x][point.y]; //깰 벽돌 개수 
						tmp[point.x][point.y] = 0;
						for(int i=0; i<4; i++) {
							int nx = point.x;
							int ny = point.y;
							
							for(int j=0; j<num-1; j++) {
								nx += dx[i];
								ny += dy[i];
								
								if(0>nx || nx >=h || 0>ny || ny >=w) break;
								
								if(!visited[nx][ny] && tmp[nx][ny] > 1) {
									queue.add(new Point(nx, ny));
									visited[nx][ny] = true;
								} 
								else if (!visited[nx][ny] && tmp[nx][ny] == 1){
									tmp[nx][ny] = 0;
									visited[nx][ny] = true;
								}
							}
						}
					}
					
					//빈 곳 채우기 
					for(int i=0; i<w; i++) {
						Queue<Integer> q = new LinkedList<>();
						for(int j=h-1; j>=0; j--) {
							if(tmp[j][i] > 0) {
								q.add(tmp[j][i]);
								tmp[j][i]=0;
							}
						}
						
						int idx = h-1;
						while(!q.isEmpty()) {
							if(idx >= 0) {
								tmp[idx][i] = q.poll();
								idx--;
							}
						}
					}
				}
			}
			//벽돌 수 세기 
			int cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(tmp[i][j]> 0) cnt++;
				}
			}
			
			ans = Math.min(cnt, ans);	
		}
		

		
		
	}

}
