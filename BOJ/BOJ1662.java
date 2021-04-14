package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		Stack<Integer> stack = new Stack<>();
		
		int ans = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stack.push(Integer.MAX_VALUE);
			} else if(c == ')') {
				int tmp = 0;
				
				//괄호 안의 문자들 구하기 
				while(!stack.isEmpty()) {
					int n = stack.pop();
					if(n == Integer.MAX_VALUE) break;
					tmp += n;
				}
				
				int r = 0;
				if(!stack.isEmpty())
					r = stack.pop();
				stack.add(r * tmp);
			} else if(i+1 < str.length() && str.charAt(i+1) == '(') {
				stack.add(str.charAt(i)-'0');
			} else {
				stack.push(1);
			}
		}
		
		while(!stack.isEmpty()) {
			int n = stack.pop();
			if(n == Integer.MAX_VALUE) continue;
			ans += n;
		}
		
		System.out.println(ans);
	}
}