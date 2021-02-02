package problem;

import java.util.Scanner;

public class BOJ1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T, stu = 0;
		T = sc.nextInt();
		
		int[] arr = new int[T+1];
		
		for(int i=1; i<=T; i++) {
			arr[i] = sc.nextInt();
		}
		
		stu = sc.nextInt();
		for(int i=0; i<stu; i++) {
			int a = sc.nextInt(); //성별 
			int b = sc.nextInt(); //받은 수 
			
			if(a == 1) {
				for(int j=b; j<=T; j+=b) {
					arr[j] = arr[j] == 0 ? 1 : 0;
				}
			} else {
				arr[b] = arr[b] == 0 ? 1 : 0;
				int j=1;
				while(b+j <= T && b-j > 0) {
					if(arr[b+j] == arr[b-j]) {
						arr[b+j] = arr[b+j] == 0 ? 1 : 0;
						arr[b-j] = arr[b-j] == 0 ? 1 : 0;
						j++;
					} else {
						break;
					}
					
				}
				
			}
		}
		
		for(int i=1; i<=T; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
	}
}
