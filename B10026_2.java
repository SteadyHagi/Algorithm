package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author thkang0107
 * @start		: 20181002
 * @end			: 20181002
 * @category	: dfs
 * @name		: ���ϻ���
 * @description : 
 *  ������ dfs ����. 
 *  �ٸ�, ���� ������� 
 *  	1. visited�� �� ���� ������ 2���� ������ ���ؼ� �� ���� 2�� for������ �����ϴ� ��� 
 *  	2. visited�� �� ���� �ΰ� 2���� 2�� for������ �����ϴ� ��� 
 *  �� �� ��� ���� �� ������ �׽�Ʈ �غ� ��. 
 *  
 *  ���⼭ ������ ����� 1��. 
 *  
 *  ���� ���, 2������ 1���� �� ���ȴ�. 
 *  ������ ��� ���. �ѹ��� 2�������� �� ���� �� �˾Ҵµ� ���� �и��ؼ� �����ϴ� ���� �� ������! 
 */
public class B10026_2 {
	private static int N, normal_count, RG_count;
	private static char[][] map;
	private static boolean[][] normal_visited;
	private static boolean[][] RG_visited;
	
	public static void DFS(int x, int y, int check) {
		if(check == 1) normal_visited[x][y] = true; 
		else RG_visited[x][y] = true;
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for(int i = 0 ; i < 4 ; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			
			if(0 <= newx && newx < N && 0 <= newy && newy < N) {
				if(map[x][y] == map[newx][newy] && !normal_visited[newx][newy] && check == 1) {
					DFS(newx, newy, 1);
				}
				
				if(!RG_visited[newx][newy] && check == 2) {
					if((map[x][y] == 'R' && map[newx][newy] == 'G') || (map[x][y] == 'G' && map[newx][newy] == 'R') || map[x][y] == map[newx][newy]){
						DFS(newx, newy, 2);
					}
				}
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		normal_visited = new boolean[N][N];
		RG_visited = new boolean[N][N];
		
		for(int n = 0 ; n < N ; n++) {
			String line = br.readLine();
			map[n] = line.toCharArray();
		}
		
		for(int n = 0 ; n < N ; n++) {
			for(int i = 0 ; i < N ; i++) {
				if(!normal_visited[n][i]) {
					normal_count++;
					DFS(n,i,1);
				}
				
				if(!RG_visited[n][i]) {
					RG_count++;
					DFS(n,i,2);
				}
			}
		}
		
		System.out.println(normal_count +" " + RG_count);

	}

}
