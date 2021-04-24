import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			System.out.print("#" + t + " ");
			int N = sc.nextInt();
			
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			
			for(int n=0; n<N; n++) {
				int in = sc.nextInt();
				if(in == 1){ //힙에 추가 
					in = sc.nextInt();
					heap.add(in);
				} else {
					// 비어있는 경우 -1을 출력 
					if(!heap.isEmpty())
						System.out.print(heap.poll() + " ");
					// 비어있지 않다면 하나 빼서 출력
					else 
						System.out.print("-1 ");
				}
			}
			System.out.println();
		}
	}
}
