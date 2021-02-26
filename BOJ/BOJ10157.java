package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157 {
	static int col, row, num, x, y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken()); //가로 (y축)
		row = Integer.parseInt(st.nextToken()); //세로 (x축) 
		num = Integer.parseInt(br.readLine());
		
		if(col*row< num) {
			System.out.println(0);
		} else {
			int cnt = 0;
			x = 1;
			y = 0;
			int tmp = 1;
			
			while(true) {
				for(int i=0; i<row; i++) {
					y += tmp;
					cnt++;
					if(cnt == num) {
						System.out.println(x + " " + y);
						return;
					}
				}
				col--;
				
				for(int i=0; i<col; i++) {
					x += tmp;
					cnt++;
					if(cnt == num) {
						System.out.println(x + " " + y);
						return;
					}
				}
				row--;
				tmp *= -1;
			}
			
		}
	}
}
