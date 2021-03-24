package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {

	static int K, W, H; //말처럼 움직일 수 있는 횟수, 가로길이, 세로길이 
	static int[][] map;
	static boolean[][][] visited;
	static int[] m_x = {-1,0,1,0};
	static int[] m_y = {0,1,0,-1};
	static int[] h_x = {-1, -2, -1, -2, 1, 2, 1, 2};
	static int[] h_y = {-2, -1, 2, 1, -2, -1, 2, 1};
	static class Move {
		//x좌표,  y좌표 , 말처럼 움직인 횟수, 전체 이동횟수. 
		int x, y, k, total_move;
		public Move(int x, int y, int k, int total_move) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.total_move = total_move;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[K+1][H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		////////////// 입력 완료 ///////////////////
		
		int ans = -1;
		Queue<Move> queue = new LinkedList<>();
		
		queue.add(new Move(0, 0, 0, 0));
		
		while(!queue.isEmpty()) {
			Move now = queue.poll();
			
			if(now.x == H-1 && now.y == W-1) {
				ans = now.total_move;
				break;
			}
			
			//말처럼 움직일 수 있는 경우
			if(now.k+1 <=K)  {
				for(int d=0; d<8; d++) {
					int nx = now.x + h_x[d];
					int ny = now.y + h_y[d];
					
					if(0>nx || 0>ny || nx>=H || ny>=W || visited[now.k+1][nx][ny] || map[nx][ny]==1) continue;
					
					visited[now.k+1][nx][ny]= true;
					queue.add(new Move(nx, ny, now.k+1, now.total_move+1));
				}
			}
			
			for(int d=0; d<4; d++) {
				int nx = now.x + m_x[d];
				int ny = now.y + m_y[d];
				
				if(0>nx || 0>ny || nx>= H|| ny>=W || visited[now.k][nx][ny] || map[nx][ny]==1) continue;
				
				visited[now.k][nx][ny]= true;
				queue.add(new Move(nx, ny, now.k, now.total_move+1));
			}
		}
		System.out.println(ans);
	}

}
