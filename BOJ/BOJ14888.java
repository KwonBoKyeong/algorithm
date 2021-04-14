package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//연산자 끼워넣기 
public class BOJ14888 {

	static int n;
	static int[] num, cal;
	static int[] p; //순열만들겨 
	static boolean[] isSelected;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		cal = new int[n-1];
		p = new int[n-1];
		isSelected = new boolean[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			int c = Integer.parseInt(st.nextToken());
			for(int j=0; j<c; j++) {
				cal[idx]= i; 
				idx++;
			}
		}
		
		perm(0);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int cnt) {
		
		if(cnt == n-1) {
			calcul();
			return;
		}
		
		for(int i=0; i<n-1; i++) {
			if(isSelected[i]) continue;
			
			p[cnt] = cal[i];
			isSelected[i]= true;
			perm(cnt+1);
			isSelected[i]= false; 
		}
		
	}

	private static void calcul() {
		int ans = num[0];
		
		for(int i=1; i<n; i++) { 
			switch (p[i-1]) {
			case 0: // +
				ans += num[i];
				break;
			case 1: // -
				ans -= num[i];
				break;
			case 2: // *
				ans *= num[i];
				break;
			case 3: // /
				ans /= num[i];
				break;
			
			}
		}
		
		if(ans > max) max = ans;
		if(ans < min) min = ans;
		
	}

}
