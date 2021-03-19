package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {

	static int N, K;
	static boolean check[] = new boolean[100010];
	static int n, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0));
	
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			n = now.n;
			cnt = now.cnt;
			
			if(n==K) {
				break;
			}
			
			if(n<0 || n>100000) continue;
			if(check[n]) continue;
			
			check[n] = true;
			
			queue.add(new Point(n-1, cnt+1));
			queue.add(new Point(n+1, cnt+1));
			queue.add(new Point(n*2, cnt+1));
			
		}

		
		System.out.println(cnt);
		
	}
	
	static class Point {
		int n, cnt;
		
		public Point(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	

}
