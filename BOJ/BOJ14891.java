package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int k;
	static LinkedList<Integer>[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new LinkedList[5];
		
		for(int i=1; i<=4; i++) {
			arr[i]= new LinkedList<Integer>(); 
			
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				arr[i].add(s.charAt(j)-'0'); 
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()); //톱니바퀴 번호 
			int dir = Integer.parseInt(st.nextToken()); //방향 
			
			left(num, -dir);
			right(num, -dir);
			rotate(num, dir);
		}
		
		int ans = 0;
		for(int i=1; i<=4; i++) {
			if(arr[i].get(0) == 1) ans += Math.pow(2, i-1);
		}
		System.out.println(ans);
	}

	private static void left(int num, int dir) {
		if(1 > num-1) return;
		if(arr[num-1].get(2) != arr[num].get(6))  {
			left(num-1, -dir);
			rotate(num-1, dir);
		}
	}
	
	private static void right(int num, int dir) {
		if(num+1 >= 5) return;
		if(arr[num].get(2) != arr[num+1].get(6))  {
			right(num+1, -dir);
			rotate(num+1, dir);
		}
	}
	
	private static void rotate(int num, int dir) {
		if(dir == 1) {
			int tmp = arr[num].pollLast();
			arr[num].addFirst(tmp);
		} else {
			int tmp = arr[num].pollFirst();
			arr[num].addLast(tmp);
		}
	}

}
