package day0205;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA9280 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int ans = 0; //총 요금
			
			Queue<Integer> queue = new LinkedList<>(); //대기 줄 

			int n = sc.nextInt(); 		//주차장 자리 수 
			int m = sc.nextInt(); 		//자동차 수 
			int[] cost = new int[n];	//주차장 자리 요금 
			int[] parking = new int[n];	//주차장 
			int[] w = new int[m+1]; 		//자동차 무게 
			 
			for(int i=0; i<n; i++)
				cost[i] = sc.nextInt();
			for(int i=1; i<=m; i++)
				w[i] = sc.nextInt();
			
			int cnt = 0; //현재 주차되어 있는 자동차 수 
			for(int i=0; i<2*m; i++) {
				int car = sc.nextInt(); //자동차의 인덱스 
				
				if(car > 0) { //주차장에 들어옴 
					if(cnt == n) queue.add(car); //꽉 차있으면 대기줄에 추가
					else {
						for(int j=0; j<n; j++) {
							if(parking[j] == 0) { //비어있는 곳에 주차 
								parking[j]= car;
								ans += (cost[j]* w[car]);
								cnt++;
								break;
							}
						}
					}
					
				} else { //주차장에서 나감
					car *= -1;
					for(int j=0; j<n; j++) {
						if(parking[j] == car) {
							if(queue.size() == 0) {
								parking[j] = 0; 
								cnt--;
							} else {
								int newCar = queue.poll();
								parking[j]= newCar;
								ans += (cost[j] * w[newCar]);
							}
						}
					}
					
				}
				
			}
				
			System.out.println("#" + t + " " + ans);
		}

	}

}