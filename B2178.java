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
 * @start		: 20181017
 * @end			: 20181024
 * @category	: BFS
 * @name		: 미로탐색
 * @description : 
 * 			나는 전형적인 dfs문제 혹은 dfs+backtracking문제라고 생각했다. 그런데 다양한 시도를 해봐도, 유망성검색을 통해 조건을 걸어봐도 계속 
 * 			'시간초과'가 발생한다. 
 * 			아직 문제를 읽고 해결방안을 찾는 것에 익숙하지 않은가보다. 
 * 
 * 			이 문제는 bfs로 풀면 손쉽게 풀리는 문제라고 한다.
 * 			생각해보니 bfs로 푸는 풀이는,
 * 			한 번만 bfs로 훑어서 각각의 노드에 한 단계씩 진행한 depth를 update해주면 마지막 N,M에서는 해당 depth를 출력해주기만 하면 끝이다. 
 * 			한 번의 bfs로 해결될 문제를 dfs+backtracking을 통해 dfs를 수십번 찍어댔으니 시간초과가 뜨는 건 당연한 논리이지 싶다.
 * */
public class B2178 {
	private static int[][] maze;
	private static int N, M, cnt;
	private static boolean[][] visited;
	
	public static int mazeRun(int y, int x, int count) {
		visited[y][x] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(new Point(y, x), count));
		
		Loop1: while(!queue.isEmpty()) {
			Node newNode = queue.poll();
			
			int idx_y = newNode.p.x;
			int idx_x = newNode.p.y;
			int idx_cnt = newNode.cnt;
			
			int[] dy = {1, 0, -1, 0};
			int[] dx = {0, 1, 0, -1};
			
			for(int i = 0 ; i < 4 ; i++) {
				int newy = idx_y + dy[i];
				int newx = idx_x + dx[i];
				
				if(0 <= newy && newy < N && 0 <= newx && newx < M && !visited[newy][newx] && maze[newy][newx] == 1) {
					visited[newy][newx] = true;
					if(newy == N-1 && newx == M-1) {
						cnt = idx_cnt +1;
						break Loop1;
					}
					queue.add(new Node(new Point(newy, newx), idx_cnt+1));
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n = 0 ; n < N ; n++) {
			String line = br.readLine();
			char[] temp = line.toCharArray();
			for(int m = 0 ; m < M ; m++) {
				maze[n][m] = temp[m] - '0';
			}
		}
		
		System.out.println(mazeRun(0,  0, 1));
	}
	
	public static class Node{
		Point p;
		int cnt;
		
		Node(Point p, int cnt){
			this.p = p;
			this.cnt = cnt;
		}
	}
}
