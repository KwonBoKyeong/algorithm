package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class BOJ13414 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		LinkedHashMap<String, Integer> student = new LinkedHashMap<>(l);
		for(int i=0; i<l; i++) {
			String s = br.readLine(); 
			if(student.get(s) != null) {
				student.remove(s);
			}	
			student.put(s, 1);
		}

		int cnt = 0;
		for(String string : student.keySet()) {
			cnt++;
			System.out.println(string);
			if(cnt == k) break;
		}
	}
}
