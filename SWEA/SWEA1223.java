package day0205;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SWEA1223 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			Stack<Character> pStack = new Stack<>();
			Stack<Integer> calStack = new Stack<>();
			int n = sc.nextInt();
			String str = sc.next();
			String post = "";
			
			//후위 표기식으로 변환
			for(int i=0; i<n; i++) {
				char c = str.charAt(i);
				if(c == '+') {
					while(true) {
						if(!pStack.isEmpty() && (pStack.peek() == '*' || pStack.peek() == '+')) {
							post += pStack.pop();
						} else break;
					}
					pStack.push(c);
				} else if(c =='*') {
					pStack.push(c);
				} else {
					post += c;
				}
			}
				
			while(true) {
				if(pStack.isEmpty()) break;
				post += pStack.pop();
			}
			
			//후위표기식 계산
			for(int i=0; i<n; i++) {
				char c = post.charAt(i);
				if(Character.isDigit(c)){
					calStack.push(c - '0');
				} else {
					int num1 = calStack.pop();
					int num2 = calStack.pop();
					
					if(c == '*') {
						calStack.push(num1*num2);
					} else if(c == '+') {
						calStack.add(num1+num2);
					}
				}
			}
			System.out.println("#" + t + " " + calStack.peek());
		}

	}

}
