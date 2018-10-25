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
 * @name		: �ɺ��� ������ 6�ܰ� ��Ģ
 * @description : 
 * 		for(int value: adList.get(temp.x)){
 * 		}
 * 		��� ���� ������, �׸��� for���� vertex ���ڸ�ŭ ������ �ϴµ� edge��ŭ ������ ������ ��� ����. 
 * 		��¼�� ó������ ������ for(edge) ���������� �𸣰ڴ�. 
 * 		�ƹ�ư, for���� ������ �� vertex���� bfs�� ������ depth��ŭ�� �����ִ� ����.
 * 		�˰��� ���� ���� ���� �׷��� ����� ���� ��������.  				
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
