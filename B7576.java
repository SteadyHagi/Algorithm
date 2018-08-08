package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 
 * 20180808
 * 토마토
 * BFS문제. 이전에 풀었던 문제와 유사하여, 4가지 경우의 수로 나누어 if문을 활용하려 했으나 
 * 복잡하게 if문을 다 쓰는 것보다 해당 내용에 맞는 경우를 행렬에 담아서 활용하는 아이디어가 돋보였던 문제. 
 * 행렬을 사용하는 bfs 문제에서 이 방식이 유용하게 사용될 것으로 보인다. */

public class B7576 {
	static int row;
	static int col;
	static int[][] tomato;
	static int maxDepth;
	
	public static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(new Point(i, j)));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.p.x;
			int y= node.p.y;
			
			/* 행렬의 row와 col 움직임을 배열에 담아 차례로 (+1,0), (-1,0), (0,+1), (0, -1)으로 구성되게 한다.*/
			int[] dx = {1,-1,0,0};
			int[] dy = {0,0,1,-1};
			
			int newx, newy;
			
			
			for(int k = 0 ; k < 4 ; k++) {
				newx = x + dx[k];
				newy = y + dy[k];
				
				/* 기존에 경우의 수를 나누어 분기했던 조건을 하나의 조건문에 모두 넣은 뒤
				 * if문으로 4가지 경우를 나누어 -1, +1을 붙여가며 썼던 것과 달리 
				 * 각 경우가 newx, newy로 통일되므로 tomato[newx][newy] == 0 의 조건을 사용.*/
				if(newx >= 0 && newx < row && newy >= 0 && newy < col) {
					/*인접한 행렬 좌표는 +1 이상의 값을 가질 수 없기 때문에 +1이라는 조건을 사용. 이 부분이 핵심 포인트인듯....*/
					if(tomato[newx][newy] == 0 || tomato[newx][newy] > tomato[x][y] +1) {
						tomato[newx][newy] = tomato[x][y]+1;
						q.add(new Node(new Point(newx ,newy)));
					}
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		tomato = new int[row][col];
		
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < col ; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*1. 이미 모두 익어있는 상태 - 어차피 최대값은 1 (자동으로 0 출력)*/
		/*2. 익히는 과정을 실행(bfs)*/
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(tomato[i][j] == 1) bfs(i,j);
			}
		}
			
		/*3. 익히는 과정이 모두 끝나고, 최소값을 출력
		*/
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				/*   만약 모두 익을 수 없는 경우라면, -1 출력*/
				if(tomato[i][j] == 0) {
					System.out.println(-1); 
					return;
				}
				else if(maxDepth < tomato[i][j]) maxDepth = tomato[i][j];
			}
		}
		System.out.println(maxDepth-1);
	}
	
	public static class Node{
		Point p = new Point();
		
		Node(Point p){
			this.p = p;
		}
	}
}
