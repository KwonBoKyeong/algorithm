package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2458 {

	static int N, M;
	static boolean[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = true; 
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int gt = gtbfs(i, new boolean[N+1]);
			int lt = ltbfs(i, new boolean[N+1]);
			if(gt+lt == N-1) ans++;
		}
		
		System.out.println(ans);
	}


	private static int ltbfs(int n, boolean[] check) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		check[n]= true; 
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=1; i<=N; i++) {
				if(!check[i] && arr[i][now]) {
					queue.add(i);
					check[i]= true; 
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int gtbfs(int n, boolean[] check) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		check[n]= true; 
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=1; i<=N; i++) {
				if(!check[i] && arr[now][i]) {
					queue.add(i);
					check[i]= true; 
					cnt++;
				}
			}
		}
		return cnt;
	}

}
