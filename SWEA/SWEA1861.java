package day0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1861 {

	static int pivot, max, cnt, N;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1}; 
	
	static int[][] arr;
	static int[] check;  //idx에서 시작했을 때 갈 수 있는 거리 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine()); 
			arr = new int[N][N];
			check = new int[N*N*2];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					pivot = arr[i][j];
					//해당 반 이동 수 구한 경우 
					if(check[pivot] != 0) continue;
					//사방의 방 중 번호가 현재-1 이고 그 방의 이동 수가 구해진 경우라면
					//현재방은 그 방-1 이다 ! 
					else if(check(i, j)) continue;
					find(i, j, pivot); 
				}
			}
			
			int idx = 0, max = 0;
			for(int i=1; i<=N*N; i++) {
				if(check[i] > max) {
					idx = i;
					max = check[i];
				}
			}
			System.out.println("#" + t + " " + idx + " " + max);
		}
	
	}
	
	public static boolean check(int i, int j) {
		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(arr[nx][ny] != pivot-1) continue;
			check[pivot]= check[pivot-1] - 1; 
			return true;
		}
		return false;
	}

	public static void find(int i, int j, int start) {
		check[pivot] += 1;
		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(arr[nx][ny] == start + 1) {
				find(nx, ny, arr[nx][ny]);
				break;
			} else continue;
		}
	}
}
