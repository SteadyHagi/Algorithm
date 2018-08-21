package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 		: thkang0107
 * @start  		: 20180820
 * @finish 		: 20180821
 * @category	: bfs
 * @name		: ������
 * @description	: ��İ��� bfs����.
 * 	������ Ǯ���� ����������, ��ļ��̱� ������ 4�ܰ踦 ���� ������ ������ Ǯ���� �Ͱ� �޸� 
 *  dx, dy�� ������ �迭�� ���� �ε����� ����� ��,��,��,�츦 �þ� �� �����ϰ� ������ Ǯ �� �ֵ��� ���Ӱ� ������ ǰ.   
 */
public class B2589_2 {
	private static int row;
	private static int col;
	private static int[][] map;
	private static boolean[][] visited;
	private static int maxDepth;
	
	public static void island(int i, int j){
		Queue<Node> q = new LinkedList<>();		
		q.add(new Node(new Point(i, j), 0));
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			Node newNode = q.poll();
			int x = newNode.p.x;
			int y = newNode.p.y;
			int newdepth = newNode.depth;
			
			/*��, ��, ��, ��*/
			int[] dx = {0, 0, -1, +1};
			int[] dy = {+1, -1, 0, 0};
			int newx=0;
			int newy=0;
			
			for(int k = 0 ; k < 4 ; k++) {
				newx = x+dx[k];
				newy = y+dy[k];
				if(newx>=0 && newx < row && newy >=0 && newy< col) {
					if(map[newx][newy] == 1 && !visited[newx][newy]) {
						q.add(new Node(new Point(newx, newy), newdepth+1));
						visited[newx][newy] = true;
						if (maxDepth < newdepth+1) maxDepth = newdepth+1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		
		for(int i = 0 ; i < row ; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j = 0 ; j < col ; j++) {
				if(temp.charAt(j) == 'W') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(map[i][j] == 1) island(i,j);
				for(boolean[] row: visited)
					Arrays.fill(row, false);
			}
		}
		
		System.out.println(maxDepth);
	}
	
	public static class Node{
		Point p = new Point();
		int depth; 
		
		Node(Point p, int depth){
			this.p = p;
			this.depth = depth;
		}
	}
}
