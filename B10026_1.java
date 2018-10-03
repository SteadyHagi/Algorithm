package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 
 * @author thkan
 * @start		: 20181002
 * @end			: 20181002
 * @category	: dfs
 * @name		: 적록색약
 * @description : 
 *  간단한 dfs 문제. 
 *  다만, 구현 방법에서 
 *  	1. visited를 두 개로 나누어 2개의 조건읠 통해서 한 번의 2중 for문으로 구현하는 방법 
 *  	2. visited를 한 개로 두고 2번의 2중 for문으로 구현하는 방법 
 *  둘 중 어느 것이 더 빠른지 테스트 해볼 것. 
 *  
 *  여기서 구현한 방법은 2번. 
 */
public class B10026_1 {
	private static int N, normal_count, RG_count;
	private static char[][] map;
	private static boolean[][] visited;
	
	
	public static void normal_DFS(int x, int y) {
		visited[x][y] = true; 
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for(int i = 0 ; i < 4 ; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			
			if(0 <= newx && newx < N && 0 <= newy && newy < N && (map[x][y] == map[newx][newy]) && !visited[newx][newy]) {
				normal_DFS(newx, newy);
			}
		}
	}
	
	public static void RG_DFS(int x, int y) {
		visited[x][y] = true; 
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		
		for(int i = 0 ; i < 4 ; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			
			if(0 <= newx && newx < N && 0 <= newy && newy < N && !visited[newx][newy]) {
				//RG를 거르는 조건 
				if( (map[x][y] == 'R' && map[newx][newy] == 'G') || (map[x][y] == 'G' && map[newx][newy] == 'R') || map[x][y] == map[newx][newy]) {
					RG_DFS(newx, newy);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int n = 0 ; n < N ; n++) {
			String line = br.readLine();
			map[n] = line.toCharArray();
		}
		
		for(int n = 0 ; n < N ; n++) {
			for(int i = 0 ; i < N ; i++) {
				if(!visited[n][i]) {
					normal_count++;
					normal_DFS(n,i);
				}
			}
		}
		
		for(boolean[] values : visited)
			Arrays.fill(values, false);
		
		for(int n = 0 ; n < N ; n++) {
			for(int i = 0 ; i < N ; i++) {
				if(!visited[n][i]) {
					RG_count++;
					RG_DFS(n,i);
				}
			}
		}
		System.out.println(normal_count +" " + RG_count);
	}

}
