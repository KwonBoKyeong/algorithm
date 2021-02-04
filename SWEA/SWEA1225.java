package day0204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			
			int tc = sc.nextInt();
			
			for(int i=0; i<8; i++) {
				int n = sc.nextInt();
				queue.add(n);
			}
			
			int cnt = 1;
			while(true) {
				int aaa = queue.poll();
				aaa -= cnt;
				if(aaa <= 0) {
					queue.add(0);
					break;
					
				} else {
					queue.add(aaa);
					cnt++;
					if(cnt == 6) cnt = 1;
				}
				
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}

	}

}
