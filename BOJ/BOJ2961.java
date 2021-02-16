package day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {

	static int N;		//재료의 개수 
	static long[] S; 	//재료의 신맛 
	static long[] B; 	//재료의 쓴맛 
	static long ans = 999999999; //신맛과 쓴맛의 차이가 가장 작은 요리 
	static boolean[] isSelected ; //부분집합 포함 여부 저장할 배열 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new long[N];
		B = new long[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
        }
		
		//부분집합을 통해 답을 구하는 food() 함수 호출
		food(0);
		//결과 출력
        System.out.println(ans);
		
	}
	
	static void food(int cnt) {
		if(cnt == N) {
			long s=1, b=0; 
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					s *= S[i];
					b += B[i];
				}
			}
			//새로운 최솟값의 등장 시 업데이트
			if(b != 0) {
				ans = Math.abs(s-b) > ans ? ans : Math.abs(s-b);
			}
			return;

		} else {
			isSelected[cnt] = true;
			food(cnt+1);
			isSelected[cnt] = false;
			food(cnt+1);
		}
	}

}
