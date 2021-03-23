package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PrimitiveIterator.OfDouble;

public class BOJ10830 {
	static int N;
	static long B;
	
	static int[][] arr, unit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        B = Long.parseLong(strs[1]);
        
		arr = new int[N][N];
		unit = new int[N][N];
		
		for(int i=0; i<N; i++) {
			strs = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] =  Integer.parseInt(strs[j]) % 1000;
				if(i==j) {
					unit[i][j]=1; 
				}
			}
		}
		
		int[][] ans = pow(B);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] pow(long b) {
		
		if(b==0) {
			return unit;
		} 
		else if (b==1) {
			return arr;
		}
		
		int[][] m = pow(b/2);
		int[][] tmp = powMatrix(m, m);
		
		if(b%2 == 0) {
			return tmp;
		} else {
			return powMatrix(tmp, arr);
		}
	}
	
	static int[][] powMatrix(int[][] a, int[][] b) {
	    int[][] result = new int[N][N];

	    for (int i = 0; i < N; i++) {
	      for (int j = 0; j < N; j++) {
	        for (int k = 0; k < N; k++) {
	          result[i][j] += (a[i][k] * b[k][j]) % 1000;
	        }
	        result[i][j] %= 1000;
	      }
	    }

	    return result;
	  }
}
