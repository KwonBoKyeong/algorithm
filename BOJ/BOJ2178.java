package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	static int N, M;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String string = br.readLine();
			for(int j=0; j<string.length(); j++) {
				map[i][j] = string.charAt(j)-'0'; 
			}
		}
		
		bfs(0,0);	
		
		System.out.println(map[N-1][M-1]);
	}

	static void bfs(int x, int y) {
		
		Queue<P> queue = new LinkedList<>();

		queue.offer(new P(x, y));
		check[x][y]= true;
		
		while(!queue.isEmpty()) {
			P point = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(map[nx][ny] == 1 && !check[nx][ny]) {
						check[nx][ny]= true;
						queue.offer(new P(nx, ny));
						map[nx][ny] = map[point.x][point.y]+1; 
					}
				}
			}
		}
	}
	
}

//위치 클래스 
class P{
	int x, y;
	
	P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
