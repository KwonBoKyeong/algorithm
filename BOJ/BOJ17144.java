package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미세먼지 안녕 ! 

public class BOJ17144 {
	
	static int R, C, T, cleaner;
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Pos> queue;
	static class Pos {
		int x, y, m;
		
		public Pos(int x, int y, int m) {
			this.x = x;
			this.y = y;
			this.m = m;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) cleaner = r; //공기청정기 위치 = [r-1][0] , [r][0]
			}
		}
		
		for(int i=0; i<T; i++) {
			queue = new LinkedList<>();
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(map[r][c] != 0 && map[r][c] != -1)
						queue.add(new Pos(r, c, map[r][c]));
				}
			}
			
			munji();
			clear_up(cleaner-1);
			clear_down(cleaner);
		}
		
		int sum = 0;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] != -1) 
					sum += map[r][c];
			}
		}
		
		System.out.println(sum);
	}
	
	private static void munji() {
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			int x = now.x;
			int y = now.y;
			int munji = now.m/5; 
			
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(0>nx || 0>ny || nx>=R || ny>=C || map[nx][ny]==-1) continue;
				
				map[nx][ny] += munji;
				map[x][y] -= munji; 
			}
		}
	}

	private static void clear_up(int r) {
		
		//위 -> 아래 
		for(int i=r-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		
		//오른쪽 -> 왼쪽
        for (int j=0; j<C-1; j++) {
        	map[0][j] = map[0][j+1];
        }

		//아래 -> 위
        for (int i=0; i<r; i++) {
        	map[i][C-1] = map[i+1][C-1];
        }

		//왼쪽 -> 오른쪽
        for (int j=C-1; j>1; j--) {
        	map[r][j] = map[r][j-1];
        }

        map[r][1] = 0;
		
	}
	
	private static void clear_down(int r) {

		//아래 -> 위
		for(int i=r+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		
		//오른쪽 -> 왼쪽
		for(int j=0; j<C-1; j++) {
			map[R-1][j] = map[R-1][j+1];
		}
		
		//위 -> 아래 
		for(int i=R-1; i>r; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		
		for(int j=C-1; j>1; j--) {
			map[r][j] = map[r][j-1];
		}
		
        map[r][1] = 0;
	}

	
}
