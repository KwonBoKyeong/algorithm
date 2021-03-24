package day0324;

import java.util.Scanner;

public class BOJ1463_DFS {
	static int X, ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		dfs(X, 0);

		System.out.println(ans);
	}


	private static void dfs(int x, int cnt) {
		if(x == 1) {
			ans = ans > cnt ? cnt : ans;
			return;
		}
		
		if(cnt >= ans) return;
		
		if(x%3==0) dfs(x/3, cnt+1);
		if(x%2==0) dfs(x/2, cnt+1);
		dfs(x-1, cnt+1);
	}

}
