package 보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1493 {
	
	static int T, P, Q, p_x, p_y, q_x, q_y;
	static int[] ks;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ks = new int[400]; //계차수열 
		for(int i=0; i<400; i++) {
			ks[i] = 1+(i*(i-1))/2; 
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			
			int num = findLoc(P);
			p_x = P-ks[num]+1;
			p_y = (num+1)-p_x;
			num = findLoc(Q);
			q_x = Q-ks[num]+1;
			q_y = (num+1)-q_x;
			
			int ans = findNum(p_x+q_x , p_y+q_y);
			
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

	//수 -> 좌표 
	static int findLoc(int n) {
		int idx = 0;
		for(int i=1; i<200; i++) {
			if(n < ks[i]) {
				idx = i-1;
				break;
			}
		}
		return idx;
	}
	
	//좌표 -> 수 
	static int findNum(int x, int y) {
		
		return ks[x+y-1] + x-1;
	}
}
