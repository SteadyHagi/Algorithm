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
 * @name		: ������ȣ���̱�
 * @description : 
 *  	�⺻���� dfs����. 
 *  	��¹����� ���� \n�� �ٿ��� �Ѵٴ� �� ��Ծ �ѹ� Ʋ�Ȱ�, 
 *  	dfs�� ������ �Լ��� ���ڸ��� visitǥ�ø� ����� �Ѵٴ� ���� �����ؼ� if�� ���Ŀ� visit check�� �ؼ�
 *  	dfs�� ���̰� 1�� ���� count���� �ʾ� �� �������� �� �� �� Ʋ�ȴ�. 
 *  
 *  	Point!
 *  	�������� dfs���������� �ð�����, �޸𸮴����� �� �� �� ���� �� ����. ArrayList ��ſ� ������ ���� �ڷᱸ���� �� �����غ���,  
 *  	dfs����� ���̸� ���ϴ� �������� ���������� ����ϴ� �� ��� �ٸ� ����� �ִ��� �˾ƺ� ��. 
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