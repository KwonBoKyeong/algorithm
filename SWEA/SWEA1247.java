package SWEA;
// [S/W 문제해결 응용] 3일차 - 최적 경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {

	static int T, N;
	static Point com, home;	
	static Point[] person;
	static boolean[] v;	//한번 들렸던 원소 체크 
	static Point[] arr;
	static int min; //최단거리 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			person = new Point[N];
			arr = new Point[N];
			v = new boolean[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			//회사 좌표
			int com_x = Integer.parseInt(st.nextToken());
			int com_y = Integer.parseInt(st.nextToken());
			com = new Point(com_x, com_y);
			
			//집 좌표 
			int home_x = Integer.parseInt(st.nextToken());
			int home_y = Integer.parseInt(st.nextToken());
			home = new Point(home_x, home_y);

			for(int i=0; i<N; i++) {
				//고객 좌표 리스트 
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				person[i] = new Point(n1, n2); 
			}
			
			nPr(0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void nPr(int cnt) {
		//끝나는 조건 
		if(cnt == N) {
			int sum = getDist(com, arr[0]);
			for(int i=0; i<N-1; i++) {
				sum += getDist(arr[i], arr[i+1]);
				if(sum > min) break;
			}
			sum += getDist(arr[N-1], home);
			min = sum < min ? sum : min;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			arr[cnt] = person[i];
			nPr(cnt+1);
			v[i]= false; 
		}
	}

	//두 위치 사이의 거리 
	public static int getDist(Point p1, Point p2) {
		
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}
	
}

//위치 좌표 
class Point{
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

