package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA6485 {
	static int T, N, A, B, P;
	static Queue<Integer> bus;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//테스트 케이스 개수
		T = Integer.parseInt(br.readLine()); 
		for(int t=1; t<=T; t++) {
			bus = new LinkedList<>();
			
			//버스 노선 개수 
			N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				bus.add(Integer.parseInt(st.nextToken()));	//Ai
				bus.add(Integer.parseInt(st.nextToken()));	//Bi
			}
			
			//해당 정류장에 다니는 버스 노선 
			int[] cnt = new int[5001];
			for(int i=0; i<N; i++) {
				if(bus.isEmpty()) break;
				A = bus.poll();
				B = bus.poll();
				for(int j=A; j<=B; j++)
					cnt[j]++; 
			}
			
			P = Integer.parseInt(br.readLine());
			int[] busStop = new int[P];
			for(int i=0; i<P; i++)
				busStop[i]= Integer.parseInt(br.readLine()); 

			System.out.print("#" + t + " ");
			for(int i=0; i<P; i++) {
				System.out.print(cnt[busStop[i]] + " ");
			}
			System.out.println();
		}
	}

}
