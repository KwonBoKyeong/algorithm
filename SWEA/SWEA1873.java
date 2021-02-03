package problem;

import java.util.Scanner;

public class SWEA1873 {
	public static int[] dx = {-1, 1, 0, 0}; //up, down, left, right
	public static int[] dy = {0, 0, -1, 1};
	
	public static char[][] map = new char[20][20];
	public static int carx, cary, H, W, dir; 
	public static char[] car = new char[4]; //전차 모양 배열 
	
	
	public static void main(String[] args) {
		car[0] = '^';
		car[1] = 'v';
		car[2] = '<';
		car[3] = '>';
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			H = sc.nextInt(); //높이 
			W = sc.nextInt(); //너비
			
			//map 구성, 전차 위치 확인 
			for(int i=0; i<H; i++) {
				String s = sc.next();
				for(int j=0; j<W; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]==car[0]) {
						carx = i;
						cary = j;
						dir = 0;
					}else if(map[i][j]==car[1]) {
						carx = i;
						cary = j;
						dir = 1;
					} else if(map[i][j]==car[2]) {
						carx = i;
						cary = j;
						dir = 2;
					} else if(map[i][j]==car[3]) {
						carx = i;
						cary = j;
						dir = 3;
					}
				}
			}
			
			//사용자 입력 
			int inputSize = sc.nextInt();
			String s = sc.next();
			for(int i=0; i<inputSize; i++) {
				if(s.charAt(i) == 'S') {
					int nx = carx;
					int ny = cary;
					while(true) {
						nx += dx[dir];
						ny += dy[dir];
						
						//map 밖으로 나간 경우 , 벽에 부딪힌 경우 
						if(0 > nx || nx >= H || 0 > ny || ny >= W || map[nx][ny] == '#') break;
						else if(map[nx][ny] == '*')  {
							map[nx][ny] = '.';
							break;
						}
					}
				} else if(s.charAt(i) == 'U') {
					playMove(map, carx, cary, 0);
				} else if(s.charAt(i) == 'D') {
					playMove(map, carx, cary, 1);
				} else if(s.charAt(i) == 'L') {
					playMove(map, carx, cary, 2);
				} else if(s.charAt(i) == 'R') {
					playMove(map, carx, cary, 3);
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static void playMove(char[][] map, int x1, int y1, int ndir) {
		//전차가 바라보고 있는 방향 변경 
		dir = ndir;
		map[x1][y1] = car[dir];
		
		//다음 칸이 평지라면 그 칸으로 이동
		int nx = x1 + dx[dir];
		int ny = y1 + dy[dir];
		
		if(0 <= nx && nx < H && 0 <= ny && ny < W) {
			if(map[nx][ny] == '.') {
				map[x1][y1] = '.';
				carx = nx;
				cary = ny;
				map[nx][ny] = car[dir];
			}
		}
		
		
	}
}
