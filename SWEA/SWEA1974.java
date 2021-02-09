package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974 {
	static int[][] sudo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			sudo = new int[9][9];
			for(int i=0; i<9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<9; j++) {
					sudo[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			boolean ans = true;
			//로직 1: 행을 위에서 아래로 이동하면서 중복체크 
			for(int i=0; ans && (i<9); i++) {
				ans = rowCheck(new boolean[9],i);
			}
			//로직 2: 열을 왼쪽에서 오른쪽으로 이동하면서 중복체크
			for(int i=0; ans && (i<9); i++) {
				ans = colCheck(new boolean[9],i);
			}
			//로직 3: 3x3 중복체크 
			for(int i=0; ans && (i<9); i+=3) {
				for(int j=0; ans && (j<9); j+=3) {
					ans = check(new boolean[9], i, j);
				}
			}
			//출력 
			System.out.println("#" + t + " " + (ans?1:0));
		}
	}

	static boolean rowCheck(boolean[] v, int r) {
		//1~9 -> 0~8로 바꿈 
		for(int c=0; c<9; c++) {
			if(v[sudo[r][c]-1]) return false;
			else v[sudo[r][c]-1] = true;
		}
		return true;
	}
		
	static boolean colCheck(boolean[] v, int c) {
		//1~9 -> 0~8로 바꿈 
		for(int r=0; r<9; r++) {
			if(v[sudo[r][c]-1]) return false;
			else v[sudo[r][c]-1] = true;
		}
		return true;
	}
	
	static boolean check(boolean[] v, int r, int c) {
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(v[sudo[i][j]-1]) return false;
				else v[sudo[i][j]-1] = true;
			}
		}
		return true;
	}

}
