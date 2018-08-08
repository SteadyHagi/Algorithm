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
 * �丶��
 * BFS����. ������ Ǯ���� ������ �����Ͽ�, 4���� ����� ���� ������ if���� Ȱ���Ϸ� ������ 
 * �����ϰ� if���� �� ���� �ͺ��� �ش� ���뿡 �´� ��츦 ��Ŀ� ��Ƽ� Ȱ���ϴ� ���̵� �������� ����. 
 * ����� ����ϴ� bfs �������� �� ����� �����ϰ� ���� ������ ���δ�. */

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
			
			/* ����� row�� col �������� �迭�� ��� ���ʷ� (+1,0), (-1,0), (0,+1), (0, -1)���� �����ǰ� �Ѵ�.*/
			int[] dx = {1,-1,0,0};
			int[] dy = {0,0,1,-1};
			
			int newx, newy;
			
			
			for(int k = 0 ; k < 4 ; k++) {
				newx = x + dx[k];
				newy = y + dy[k];
				
				/* ������ ����� ���� ������ �б��ߴ� ������ �ϳ��� ���ǹ��� ��� ���� ��
				 * if������ 4���� ��츦 ������ -1, +1�� �ٿ����� ��� �Ͱ� �޸� 
				 * �� ��찡 newx, newy�� ���ϵǹǷ� tomato[newx][newy] == 0 �� ������ ���.*/
				if(newx >= 0 && newx < row && newy >= 0 && newy < col) {
					/*������ ��� ��ǥ�� +1 �̻��� ���� ���� �� ���� ������ +1�̶�� ������ ���. �� �κ��� �ٽ� ����Ʈ�ε�....*/
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
		
		/*1. �̹� ��� �;��ִ� ���� - ������ �ִ밪�� 1 (�ڵ����� 0 ���)*/
		/*2. ������ ������ ����(bfs)*/
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(tomato[i][j] == 1) bfs(i,j);
			}
		}
			
		/*3. ������ ������ ��� ������, �ּҰ��� ���
		*/
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				/*   ���� ��� ���� �� ���� �����, -1 ���*/
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
