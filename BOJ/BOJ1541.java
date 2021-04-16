package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		ArrayList<Character> operator = new ArrayList(); //연산자 
		ArrayList<Integer> num = new ArrayList(); //숫자 
		
		String s = "";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '-' || c == '+') {
				num.add(Integer.parseInt(s));
				s = "";
				operator.add(c);
			} else {
				s += c;
			}
		}
		num.add(Integer.parseInt(s));
		
		///////////////////////////////////////////////
		
		int ans = num.get(0);
		boolean check = false;
		for(int i=1; i<num.size(); i++) {
			char op = operator.get(i-1);
			if(op == '-') {
				ans -= num.get(i);
				check = true;
			} else if(op == '+'){
				if(check == false)
					ans += num.get(i);
				else 
					ans -= num.get(i);
			} 
		}
		
		System.out.println(ans);
		
 	}

}
