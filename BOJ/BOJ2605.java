package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(list.size()-num, i+1);
		}
		for(int i : list)
			System.out.print(i + " ");
		
		System.out.println();
	}

}
