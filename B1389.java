package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author thkan0107
 * @start		: 20181015
 * @end			: 20181023
 * @category	: BFS
 * @name		: 케빈의 베이컨 6단계 법칙
 * @description : 
 * 		for(int value: adList.get(temp.x)){
 * 		}
 * 		라는 구문 때문에, 그리고 for문을 vertex 숫자만큼 돌려야 하는데 edge만큼 돌려서 한참을 헤맨 문제. 
 * 		어쩌면 처음부터 문제는 for(edge) 때문인지도 모르겠다. 
 * 		아무튼, for문을 돌려서 각 vertex마다 bfs를 돌려서 depth만큼씩 더해주는 문제.
 * 		알고리즘만 놓고 봤을 때는 그렇게 어렵지 않은 문제였다.  				
 * 
 * */
public class B1389 {
	private static ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
	private static boolean[] visited;
	private static int count;
	
	public static int BFS(int vertex, int cnt) {
		int sum = 0; 
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(vertex, cnt));
//		System.out.println(vertex);
		visited[vertex] = true;
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int newVertex = temp.x;
			int newCnt = temp.y;
			
			for(int i = 0 ; i < adList.get(newVertex).size() ; i++) {
				int newidx = adList.get(newVertex).get(i);
				if(!visited[newidx]) {
					queue.add(new Point(newidx, newCnt+1));
					sum += newCnt +1;
					visited[newidx] = true;
				}
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		Point min = new Point(9999, 0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		visited = new boolean[N+1];
		
		for(int n = 0 ; n < N+1 ; n++) {
			adList.add(new ArrayList<>());
		}
		
		for(int m = 0 ; m < M ; m++) {
			String[] line = br.readLine().split(" ");
			
			int v1 = Integer.parseInt(line[0]);
			int v2 = Integer.parseInt(line[1]);
			
			if( !(adList.get(v1).contains(v2) || adList.get(v2).contains(v1)) ) {
				adList.get(v1).add(v2);
				adList.get(v2).add(v1);
			}
		}
		
		for(int n = 1 ; n <= N ; n++) {
			int temp = BFS(n, count);
			Arrays.fill(visited, false);
			
			if(min.x > temp) {
				min.x = temp;
				min.y = n;
			}
		}
		
		System.out.println(min.y);
	}
}
