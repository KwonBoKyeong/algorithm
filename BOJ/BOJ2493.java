package day0204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		int N = Integer.parseInt(bReader.readLine());
		StringTokenizer stringTokenizer = new StringTokenizer(bReader.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> top = new Stack<>();
		
		for(int i=1; i<=N; i++) {
			int n = Integer.parseInt(stringTokenizer.nextToken());
			
			while(true) {
				if(stack.size() == 0) {
					stack.push(n);
					top.push(i);
					ans.append("0 ");
					break;
				} else if(stack.peek() > n) {
					ans.append(top.peek() + " ");
					stack.push(n);
					top.push(i);
					break;
				} else {
					stack.pop();
					top.pop();
				}
				
			}
		}
			
		System.out.println(ans);
			
	}
}
