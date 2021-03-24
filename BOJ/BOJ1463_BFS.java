package day0324;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1463_BFS {
	static int X;
	static class Info {
		int x, cnt; 
		public Info(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		int ans = 0;
		
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(X, 0));
		
		while(!queue.isEmpty()) {
			Info now = queue.poll();
			int x = now.x;
			int cnt = now.cnt;
			if(x == 1) {
				ans = cnt;
				break;
			}
			
			if( x % 3 == 0) queue.add(new Info(x/3, cnt+1));
			if(x % 2 == 0) queue.add(new Info(x/2, cnt+1));
			queue.add(new Info(x-1, cnt+1));
		}
		
		System.out.println(ans);
	}

}
