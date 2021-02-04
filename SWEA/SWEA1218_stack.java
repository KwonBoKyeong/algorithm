package day0204;

import java.util.Scanner;
import java.util.Stack;

public class SWEA1218_stack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t=1; t<=10; t++) {
			Stack<Character> st = new Stack<>();
			int len = sc.nextInt();
			String str = sc.next();
			
			for(int i=0; i<len; i++) {
				char next = str.charAt(i);

				if(st.size() == 0) st.push(next);
				else {
					if(next == '(' || next == '[' || next == '{' || next =='<')
						st.push(next);
					
					else {
						char c = st.peek();
						if((c == '(' && next == ')') || (c =='[' && next == ']') || (c =='{' && next == '}') ||  (c =='<' && next == '>') ){
							st.pop();
						} else {
							st.push(next);
						}
					}
				}
			}
			
			System.out.print("#" + t + " ");
			if(st.isEmpty()) 
				System.out.println(1);
			else 
				System.out.println(0);
		}
	}
}
