package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author		: thkang0107
 * @start		: 20181001
 * @end			: 20181001
 * @category	: dfs
 * @name		: 단지번호붙이기
 * @description : 
 *  	기본적인 dfs문제. 
 *  	출력문에서 각각 \n을 붙여야 한다는 걸 까먹어서 한번 틀렸고, 
 *  	dfs기 때문에 함수에 들어가자마자 visit표시를 해줘야 한다는 것을 간과해서 if문 이후에 visit check를 해서
 *  	dfs의 길이가 1일 때는 count되지 않아 그 내용으로 또 한 번 틀렸다. 
 *  
 *  	Point!
 *  	전형적인 dfs문제였으나 시간단축, 메모리단축을 더 할 수 있을 것 같다. ArrayList 대신에 면적을 넣을 자료구조를 더 생각해보고,  
 *  	dfs경로의 넓이를 구하는 과정에서 이중포문을 사용하는 것 대신 다른 방법이 있는지 알아볼 것. 
 *  	
 */
public class B2667 {
	public static int N, area_count;
	public static int[][] map;
	public static ArrayList<Integer> area = new ArrayList<>();
	
	public static int DFS(int x, int y) {
		area_count++;
		map[x][y] = 0 ;
		
		int[] dx = {1, -1, 0 ,0};
		int[] dy = {0, 0, 1, -1};
		
		for(int i = 0 ; i < 4 ; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			
			if(0 <= newx && newx < N && 0 <= newy && newy < N) {
				if(map[newx][newy] == 1) {
					DFS(newx, newy);
				}
			}
		}
		return area_count;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		N = Integer.parseInt(input);
		map = new int[N][N];
		
		for(int n = 0 ; n < N ; n++) {
			String line = br.readLine();
			for(int m = 0 ; m < N ; m++) {
				map[n][m] = (line.charAt(m)-48);
			}
		}

		for(int n = 0 ; n < N ; n++) {
			for(int m = 0 ; m < N ; m++) {
				if(map[n][m] == 1) {
					area.add(DFS(n,m));
					area_count = 0;
				}
			}
		}
		
		Collections.sort(area);
		System.out.println(area.size());
		for(int i = 0 ; i < area.size() ; i++) {
			System.out.println(area.get(i));
		}
	}
}	