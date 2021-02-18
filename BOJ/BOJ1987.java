import java.util.Scanner;

public class BOJ1987 {

	static int R, C, max = Integer.MIN_VALUE;
	static boolean[] alpha = new boolean[26];
	static char[][] map ;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = sc.next();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j); 
			}
		}
		
		//처음 말의 x좌표, y좌표, 이동 칸의 수 
		move(0, 0, 1);
		
		System.out.println(max);
	}

	public static void move(int x, int y, int cnt) {
		alpha[map[x][y]-'A'] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && 0<=ny && nx < R && ny < C ) {
				if(alpha[map[nx][ny]-'A']) {
					max = cnt > max ? cnt : max;
					continue;
				}
				move(nx, ny, cnt+1);
				alpha[map[nx][ny]-'A'] = false;
			}
		}
		return;
	}
	
	

}
