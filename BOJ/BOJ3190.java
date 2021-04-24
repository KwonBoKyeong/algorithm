package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
	static int n, k, l;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상 
	static int[] dy = {1, 0, -1 ,0}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 999; //사과  
		}
		
		Queue<Integer> qTime = new LinkedList<Integer>();
		Queue<Character> qDir = new LinkedList<Character>();
		
		l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			qTime.add(a);
			qDir.add(b);
		}
		
		////////////////////////////////////////////
		
		int ans = 0;
		
		LinkedList<Point> list = new LinkedList<>(); //뱀의 위치를 담을 리스트. 
		list.add(new Point(0, 0)); 
		map[0][0] = -1;
		
		int d = 0; //처음 방향은 오른쪽!
		
		while(true) {
			ans++;
			
			int nx = list.get(0).x + dx[d];
			int ny = list.get(0).y + dy[d];
			
			//벽 또는 자기자신의 몸과 부딪히면 게임 끝 
			if(0>nx || nx >=n || 0>ny || ny>=n || map[nx][ny]== -1) break;
			
			//일단 머리를 다음 칸에 위치시키자 
			list.addFirst(new Point(nx, ny));
			
			if(map[nx][ny] == 999) { //사과가 있다면?
				map[nx][ny] = -1; //뱀으로 표시해버려
			} else if(map[nx][ny] == 0){ //사과가 없다면 ?
				Point tmp = list.pollLast(); //꼬리자르기
				map[tmp.x][tmp.y] = 0; //다시 빈 공간으로 되돌려 
				map[nx][ny] = -1;
			}
			
			if(!qTime.isEmpty() && qTime.peek() == ans) { //방향전환 
				qTime.poll();
				char c = qDir.poll();
				if(c == 'D') {//시계방향 
					d = (d+1) % 4;
				} else { //반시계방향 
					d = (d+3) % 4;
				}
			}
		}
		
		System.out.println(ans);
	}

	public static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
