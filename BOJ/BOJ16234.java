package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//인구 이동 
public class BOJ16234 {

	static int N, L, R;
	static int[][] arr; //땅
	static boolean[][] visit;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static List<Point> unit; //연합할 나라들
	static Queue<Point> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//입력 값 집어넣자 
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		queue = new LinkedList<>();	
		unit = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		boolean checkMove = false;
		
		//이동이 없을 때까지 반복해 
		while(true) {
			
			visit = new boolean[N][N];
			checkMove = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visit[i][j]) continue;
					if(func(i, j)) checkMove=true;
				}
			}
			if(checkMove) ans++;
			else break;
		}
		System.out.println(ans);
	}

	public static boolean func(int x, int y) {
		
		queue.clear();
		unit.clear();
		
		//현재 나라 큐에 일단 넣어 
		queue.add(new Point(x, y));
		unit.add(new Point(x, y));
		visit[x][y] = true; 
		

		int sum = arr[x][y];
		while(!queue.isEmpty()) {
			//주변 나라 탐색한다 
			Point now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(0 > nx || nx >= N || 0 > ny || ny >= N || visit[nx][ny]) continue;
				
				int diff = Math.abs(arr[now.x][now.y]-arr[nx][ny]);
				if(L <= diff && diff <= R) {
					//조건되니까 여기는 이제 연합한다
					
					sum += arr[nx][ny];
					queue.add(new Point(nx, ny));
					unit.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
		
		if(unit.size() != 1) {
			//연합을 이루고 있는 각 칸의 인구수
			int num = sum / unit.size();
			//연합한 나라끼리 인구 이동해 
			for(Point coor : unit) {
				arr[coor.x][coor.y] = num;
			}
			return true;
		}
		return false;
	}
	
	static class Point {
		int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

