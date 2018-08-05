package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589 {
	static int row;
	static int col;
	static int[][] map;
	static boolean[][] visited;
	static int maxDepth;
	static int depth;
	static Queue<Node> q = new LinkedList<>();
	
	public static void bfs(int i, int j) {
		visited[i][j] = true;
		q.add(new Node(new Point(i, j), depth));
		
		/* bfs 시작*/
		while(!q.isEmpty()) {
			Node newnode = q.poll();
			int newx = newnode.p.x;
			int newy = newnode.p.y;
			int newdepth = newnode.depth;
			if(newdepth> maxDepth) maxDepth = newdepth;
			
			/* (i+1, j) */
			if(newx+1 < row  && (map[newx+1][newy] ==1 ) && !visited[newx+1][newy]) {
				visited[newx+1][newy] = true;
				q.add(new Node(new Point(newx+1, newy),newdepth+1));
				if(q.peek().depth > maxDepth) maxDepth = q.peek().depth;
			}
			/* (i-1, j) */
			if(newx-1 >= 0 && (map[newx-1][newy] ==1 ) && !visited[newx-1][newy]) {
				visited[newx-1][newy] = true;
				q.add(new Node(new Point(newx-1, newy),newdepth+1));
				if(q.peek().depth > maxDepth) maxDepth = q.peek().depth;
			}
			/* (i, j+1) */
			if(newy+1 < col  && ( map[newx][newy+1] ==1 ) && !visited[newx][newy+1]) {
				visited[newx][newy+1] = true;
				q.add(new Node(new Point(newx, newy+1),newdepth+1));
				if(q.peek().depth > maxDepth) maxDepth = q.peek().depth;
			}
			/* (i, j-1) */
			if(newy-1 >= 0  && (map[newx][newy-1] ==1 ) && !visited[newx][newy-1]) {
				visited[newx][newy-1] = true;
				q.add(new Node(new Point(newx, newy-1),newdepth+1));
				if(q.peek().depth > maxDepth) maxDepth = q.peek().depth;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		
		/*보물 지도를 입력받음*/
		for(int i = 0 ; i < row ; i ++) {
			st = new StringTokenizer(br.readLine());
			String tempStr = st.nextToken();
			for(int j = 0 ; j < col ; j++) {
				if(tempStr.charAt(j) == 'W') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		for(int i = 0 ; i < row ; i ++) {
			for(int j = 0 ; j < col ; j++) {
				if(map[i][j] == 1) { /* System.out.println("bfs Start: " + i +" "+ j); */bfs(i, j);}
				for(boolean[] row : visited) {
					Arrays.fill(row, false);
				}
			}
		}
		
		System.out.println(maxDepth);
	}
	
	/* 행렬의 row, col좌표를 입력받을 Point p와 각 지점사이의 거리를 파악할 depth */
	public static class Node{
		Point p = new Point();
		int depth;
		
		Node(Point p, int depth){
			this.p = p;
			this.depth = depth;
		}
	}

}
