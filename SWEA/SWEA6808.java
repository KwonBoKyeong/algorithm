package day0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6808 {
	
	static int T, win, lose;
	static int[] kCard = new int[9];
	static int[] iCard = new int[9];
	static int[] num = new int[9];
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			win = 0;
			lose = 0;
			check = new boolean[19];
			st = new StringTokenizer(br.readLine(), " ");
			
			//규영이 카드 정보 
			for(int i=0; i<9; i++) {
				int num = Integer.parseInt(st.nextToken());
				kCard[i] = num;
				check[num] = true;
			}
			
			//인영이 카드 정보
			int idx = 0;
			for(int i=1; i<=18 && idx < 9; i++) {
				if(check[i] == false) {
					iCard[idx] = i;
					idx++;
				}
			}
			cardPerm(0);
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	static boolean[] v = new boolean[9];	//한번 들렸던 원소 체크 
	private static void cardPerm(int cnt) {
		//끝나는 조건 => 점수 비교 
		if(cnt == 9) { 
			int score_i = 0;
			int score_k = 0;
			
			for(int i=0; i<9; i++) {
				if(kCard[i] > num[i]) score_k += (kCard[i] + num[i]);
				else if(kCard[i] < num[i]) score_i += (kCard[i] + num[i]);
			}
			
			if(score_k > score_i) win++;
			else if(score_k < score_i) lose++;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(v[i]) continue;
			v[i] = true;
			num[cnt] = iCard[i];
			cardPerm(cnt+1);
			v[i]= false; 
		}
		
	}

}
