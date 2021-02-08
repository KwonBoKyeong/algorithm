package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++)
				list.add(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			while(true)
			{
				if(n==0) break;
				if(st.nextToken() == "I") continue;
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int i=0; i<y; i++) {
					list.add(x+i, st.nextToken());
				}
				n--;
			}
			System.out.print("#" + t);
			
			for(int i=0; i<10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
		
	}

}
