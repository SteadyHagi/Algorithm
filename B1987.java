package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author thkang0107
 * @start		: 20180915
 * @end			: 20181006
 * @category	: DFS&BACKTRACKING
 * @name		: ���ĺ�
 * @description : 	 
 * 				�������� ��θ� ���ؾ� �ϴ� ����. 
 * 				�Դ� ��θ� �ǵ��ư��� ��Ʈ��ŷ�� �����ִ� �����̴�. 
 * 				�ٽ� Ǯ��� ��Ȯ�ϰ� ������ ��!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * */

public class B1987 {
	private static int R, C, max;
	private static char[][] map;
	private static boolean[] alphabet = new boolean[26];
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, 1, 0, -1};
	
	public static void DFS_BACK(int y, int x, int cnt) {
		int idx = map[y][x] - 'A';
		alphabet[idx] = true;
		if(max < cnt) max = cnt;
		
		for(int i = 0 ; i < 4 ; i++) {
			int newy = y + dy[i];
			int newx = x + dx[i];
			
			if(0 <= newy && newy < R && 0 <= newx && newx < C ) {
				int new_idx = map[newy][newx] - 'A';
				
				if(!alphabet[new_idx]) {
					alphabet[new_idx] = true;
					DFS_BACK(newy, newx, cnt+1);
					alphabet[new_idx] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		map = new char[R][C];
		
		for(int r = 0 ; r < R ; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		DFS_BACK(0,0,1);
		System.out.println(max);
	}
}