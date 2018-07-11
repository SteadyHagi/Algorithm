package B1697;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
	/**
	 * 숨바꼭질
	 * bfs
	 * 20180710
	 * bfs의 특성을 잘 알면 쉽게 풀 수 있는 문제. 
	 * bfs를 좀 더 능숙하게 쓸 수 있도록 노력해야겠다. 
	 *  + 여러 조건들을 잘 세워야 하고, Point를 통해 bfs의 레벨을 숫자와 매칭하는 것이 진정한 포인트! 
	 */
	
	static Queue<Point> q = new LinkedList<Point>();
	static int start; 
	static int goal;
	static int step;
	static boolean[] visited = new boolean[100001];
	
	public static void bfs() {
		int fadeoutx=0;
		int fadeouty=0;
		q.add(new Point(start, step));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			fadeoutx = q.peek().x;
			fadeouty = q.peek().y;
			if(fadeoutx== goal){
				System.out.println(fadeouty);
				break;
			}
			q.poll();
			if(fadeoutx-1>= 0 && !visited[fadeoutx-1]) {
				q.add(new Point(fadeoutx-1, fadeouty+1)); 
				visited[fadeoutx-1] = true;
			}
			
			if(fadeoutx+1<= 100000 && !visited[fadeoutx+1]) {
				q.add(new Point(fadeoutx+1,fadeouty+1));
				visited[fadeoutx+1] = true;				
			}
			
			if(fadeoutx*2 <= 100000 && !visited[fadeoutx*2]) {
				q.add(new Point(fadeoutx*2,fadeouty+1));
				visited[fadeoutx*2] = true;				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		
		bfs();
	}
	
}