package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나무 재테크
public class BOJ16235 {

	static int n, m, k;
	static int[][] arr; //추가하는 양분의 양 
	static int[][] map; //현재 양분의 양 
	static LinkedList<Tree> list; //나무 정보 
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	
	static class Tree implements Comparable<Tree>{
		int x, y, age;
		boolean die;
		
		public Tree(int x, int y, int age, boolean die) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.die = die;
		}

		//위치가 같은 경우 나이 적은 순서로 정렬 
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + "] \n";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		map = new int[n+1][n+1];
		list = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				map[i][j] = 5;
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			list.add(new Tree(x, y, age, false));
		}
		
		/////////////////////////////////////////////////////
		
		
		for(int i=0; i<k; i++) {
			process();
		}
		
		int ans = 0;
		for(Tree tree : list) {
			if(!tree.die) ans++;
		}
		System.out.println(ans);
	}


	private static void process() {
		Collections.sort(list); //위치가 같다면 나이가 적은 순서대로 정렬 
		
		// 봄 
		for(Tree tree: list) {
			
			if(map[tree.x][tree.y] >= tree.age) { 
				map[tree.x][tree.y] -= tree.age;
				tree.age += 1;
			} else {
				tree.die = true;
			}
		}
		
		//여름 
		for(Iterator<Tree> it = list.iterator(); it.hasNext();) {
			Tree tree = it.next();
			if(tree.die) {
				map[tree.x][tree.y] += (tree.age/2);
				it.remove();
			}
		}
		
		// 가을
		LinkedList<Tree> newlist = new LinkedList<>();
		for(Tree tree : list) {
			if(tree.die) continue;
			if(tree.age % 5 == 0) {
				for(int d=0; d<8; d++) {
					int nx = tree.x + dx[d];
					int ny = tree.y + dy[d];
					
//					System.out.println("여기는 8방탐색 ");
					if(1<=nx && nx<n+1 && 1<=ny && ny<n+1)
						newlist.add(new Tree(nx, ny, 1, false));
				}
			}
		}
		list.addAll(0,newlist);
		
		//겨울
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				map[i][j] += arr[i][j]; 
			}
		}
	}
}
