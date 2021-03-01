package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11723 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		boolean[] num = new boolean[21];
		
		for(int m=0; m<M; m++) {
			String line = br.readLine();
			if(line.equals("all")) {
				Arrays.fill(num, true);
			} else if(line.equals("empty")) {
				Arrays.fill(num, false);
			} else {
				st = new StringTokenizer(line, " ");
				String a = st.nextToken();
				int input = Integer.parseInt(st.nextToken());
				if(a.equals("add")) {
					num[input]= true; 
				}else if(a.equals("remove")) {
					num[input]= false;
				}else if(a.equals("check")) {
					if(num[input]) bw.write(1 + "\n");
					else bw.write(0 + "\n");
				}else if(a.equals("toggle")) {
					if(num[input]) num[input]= false;
					else num[input] = true;
				}
			}
		}
		bw.close();
	}

}
