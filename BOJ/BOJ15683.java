package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<CCTV> list; //cctv 객체 담는 리스트 
	static int[] dx = {-1,0,1,0}; //상, 좌, 하, 우 
	static int[] dy = {0,-1,0,1};
	static String[][] dir = {
			{},
			{"0","1","2","3"},
			{"02","13"},
			{"03","32","21","10"},
			{"012","123","230","301"},
			{"0123"} 
	};
	
	static class CCTV {
		int x, y, num;
		
		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6)  //CCTV 위치정보 저장 
					list.add(new CCTV(i, j, map[i][j]));
			}
		}
		
		see(0, map);
		
		System.out.println(ans);
	}

	private static void see(int cctv, int[][] map) {

		if(cctv == list.size()) {
			int tmp = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]== 0 ) tmp++;
				}
			}
			ans = Math.min(tmp, ans);
			return;
		}
		
		CCTV now = list.get(cctv);
		
		for(int i=0; i<dir[now.num].length; i++) {
			int[][] tmp = new int[N][M];
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					tmp[j][k]= map[j][k]; 
				}
			}
			
			for(int d=0; d<dir[now.num][i].length(); d++) {
				int nd = dir[now.num][i].charAt(d) -'0';
				int nx = now.x + dx[nd];
				int ny = now.y + dy[nd];
				
				while(true) {
					if(0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny] == 6)
						break;
					tmp[nx][ny]= -1;
					nx += dx[nd];
					ny += dy[nd];
				}
			}
			
			see(cctv+1, tmp);
		}
	}
}
