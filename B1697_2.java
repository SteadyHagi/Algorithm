package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 
 * @author thkan0107
 * @start		: 20181006
 * @end			: 20181007
 * @category	: bfs & backtracking
 * @name		: 숨바꼭질
 * @description : dfs로 풀면 적합하지 않은 문제이기 때문에, bfs로 풀되 유망성 검사를 통해 backtracking 알고리즘을 구현해야 한다. 
 * 				꼭 정해진 틀이 아니라 다른 유형으로도 backtracking의 알고리즘을 적용할 수 있어야 한다. 
 * 
 * 				잘 적용 했고, 함수에서 빠져나와서 메인에서 print 할 필요 없이, 함수 들어간 상태에서 조건 만족하면 print하는 것이 더 빠른 결과. 
 * 				최적화되어있는듯. 
 * */
public class B1697_2 {
	private static int N, K, cnt;
	private static boolean[] visited = new boolean[100001];
	
	public static void Finding(int n, int cnt) {
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(n, cnt));
		visited[n] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int temp_n = p.x;
			int temp_cnt = p.y;
			
			if(temp_n == K) { int ans= temp_cnt;
			System.out.println(ans); break;}
			if(0 <= temp_n-1 && !visited[temp_n-1]) {
				q.add(new Point(temp_n-1, temp_cnt+1)); visited[temp_n-1] = true;
			}
			
			if(temp_n+1 <= 100000 && !visited[temp_n+1]) {
				q.add(new Point(temp_n+1, temp_cnt+1)); visited[temp_n+1] = true;
			}
			
			if(temp_n*2 <= 100000 && !visited[temp_n*2]) {
				q.add(new Point(temp_n*2, temp_cnt+1)); visited[temp_n*2] = true;
			}
		}
		
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		Finding(N, cnt);
	}

}