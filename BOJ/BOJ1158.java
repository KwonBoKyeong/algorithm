package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String ans = "<";
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i<N; i++) {
			queue.add(i+1);
		}

		int idx = 1;
		while(true) {
			if(queue.isEmpty()) break;
			if(idx % K == 0) {
				ans += Integer.toString(queue.remove());
				if(queue.size() != 0)
					ans += ", ";
			} else {
				queue.add(queue.remove());
			}
			idx++;
		}
		
		System.out.println(ans + ">");
	}
}
