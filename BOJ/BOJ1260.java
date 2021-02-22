package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	static int N, M, V;
	static int[][] map;
	static boolean[] check;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); //정점의 개수 
		M = Integer.parseInt(st.nextToken()); //간선의 개수 
		V = Integer.parseInt(st.nextToken()); //정점의 번호 
		map = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map[v1][v2] = 1;
			map[v2][v1] = 1; 
		}
		
		dfs(V);
		System.out.println();
		check = new boolean[N+1];
		bfs(V);
	}
	
	public static void dfs(int v) {
		check[v] = true;
		System.out.print(v + " ");
		
		for(int i=1; i<=N; i++) {
			if(!check[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		check[v] = true; 
		queue.offer(v);
		while(!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n + " ");
			
			for(int i=1; i<=N; i++) {
				if(!check[i] && map[n][i] == 1) {
					check[i]= true; 
					queue.offer(i);
				}
			}
			
		}
		
	}
}