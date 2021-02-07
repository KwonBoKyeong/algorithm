package day0205;

import java.util.Scanner;

public class BOJ3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt(); //케이크 길이
		int N = sc.nextInt(); //방청객 수 
		boolean[] cake = new boolean[L+1];
		
		int eMax = 0, eIdx = 0; //기대번호 정보
		int rMax = 0, rIdx = 0; //실제번호 정보 
		int p,k;
		
		for(int i=1; i<=N; i++) {
			p = sc.nextInt();
			k = sc.nextInt();
			
			if (eMax < (k-p+1)) {
				eMax = k-p+1;
				eIdx = i;
			}
			
			int cnt = 0;
			for(int j=p; j<=k; j++) {
				if(cake[j] == false) {
					cake[j] = true;
					cnt++;
				}
			}

			if(rMax < cnt) {
				rMax = cnt;
				rIdx = i;
			}
		}
		
		System.out.println(eIdx + "\n" + rIdx);
	}

}
