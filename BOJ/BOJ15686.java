package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {

	static int N, M;
	static ArrayList<Point> city = new ArrayList<>(); //집 
	static ArrayList<Point> chicken = new ArrayList<>(); //치킨집 
	static int ans = Integer.MAX_VALUE; //도시의 치킨 거리 최솟값 
	static boolean[] isSelected; //조합 구하기 위한 배열 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //도시 수 
		M = Integer.parseInt(st.nextToken()); //폐업시키지 않을 치킨집 수 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) city.add(new Point(i, j));
				else if(input == 2) chicken.add(new Point(i, j));
			}
		}
		
		isSelected = new boolean[chicken.size()];
		
		loc(0, 0);
		
		System.out.println(ans);
	}
	
	static void loc(int idx, int cnt) {
		if(cnt == M) {
			//치킨집 조합과 도시의 치킨 거리
			int sum = 0;
			
			for(Point cityP : city) {
				int min = Integer.MAX_VALUE;
				
				for(int i=0; i<chicken.size(); i++) { 
					if(isSelected[i]) {
						int dist = getDist(cityP , chicken.get(i));
						min = dist < min? dist : min;
					}
				}
				sum += min;
			}
			
			//새로운 최솟값
			ans = sum > ans ? ans : sum;
		
			return;

		} else if(idx == chicken.size()) {
			return;
		} else {
			//현재 선택 
			isSelected[idx] = true;
			loc(idx+1, cnt+1);
			//현재 노선택 
			isSelected[idx] = false;
			loc(idx+1, cnt);
		}
	}
	
	//두 칸 사이 거리 구하기 
	public static int getDist(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}
	
}

//위치 클래스 
class Point{
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
