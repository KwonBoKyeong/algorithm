package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int com = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[com][com];
		boolean[] check = new boolean[com];
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a][b] = true;
			arr[b][a] = true; 
		}
		
		int ans = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		check[0] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0; i<com; i++) {
				if(arr[now][i] && !check[i]) {
					queue.add(i);
					check[i]= true;
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}

}
