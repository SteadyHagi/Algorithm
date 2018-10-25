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
 * @name		: �̷�Ž��
 * @description : 
 * 			���� �������� dfs���� Ȥ�� dfs+backtracking������� �����ߴ�. �׷��� �پ��� �õ��� �غ���, �������˻��� ���� ������ �ɾ���� ��� 
 * 			'�ð��ʰ�'�� �߻��Ѵ�. 
 * 			���� ������ �а� �ذ����� ã�� �Ϳ� �ͼ����� ����������. 
 * 
 * 			�� ������ bfs�� Ǯ�� �ս��� Ǯ���� ������� �Ѵ�.
 * 			�����غ��� bfs�� Ǫ�� Ǯ�̴�,
 * 			�� ���� bfs�� �Ⱦ ������ ��忡 �� �ܰ辿 ������ depth�� update���ָ� ������ N,M������ �ش� depth�� ������ֱ⸸ �ϸ� ���̴�. 
 * 			�� ���� bfs�� �ذ�� ������ dfs+backtracking�� ���� dfs�� ���ʹ� �������� �ð��ʰ��� �ߴ� �� �翬�� ������ �ʹ�.
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
