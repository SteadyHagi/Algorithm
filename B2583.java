package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
/**
 * 
 * @author		: thkang0107
 * @start		: 20180930
 * @end			: 20180930
 * @category	: dfs
 * @name		: ���� ���ϱ�
 * @description : 
 * �־��� matrix�� ���� ������ �� �ִ� ��İ� ���� �� �Է� ����� �޶� ���� ��Ȳ�ߴ� ����. 
 * ������ �־��� ������ �����ϴٸ� ������ �־��� ������ ���� �Ϳ� �Ұ��ϱ� ������ ������ٰ� �����߰�, �׳� �Է¹޾Ƽ� dfs ���� ���� Ǯ����. 
 * ���� �����ϴٸ� ���´� ���� �Ű�Ƚᵵ �ȴٴ� ���� ���ݰ� ��. 
 *
 *	���� Ǭ ���� �� �� 
 *	
 *	Point
 *	1. 0�� �̷�� �ִ� ������ ��� �б��ϴ� �� ��� �ľ��ϴ°�? ->2�� for���� ���� ��� �˻� & ������ ����� 1���� convert
 *	2. 0�� �̷�� �ִ� ������ ���̴� ��� �ľ�? ->		dfs
 *
 *	�� ���簢���� ��ǥ�� Point�� �����Ͽ� ��ǥ�� �ľ��ϱ� ���� ����. 
 */
public class B2583 {
	private static int N,M,K, devision_count, area_ =1;
	private static int[][] map;
	private static ArrayList<Integer> area = new ArrayList<>();
	private static Point[][] rec;
	
	public static int dfs(int m, int n) {
		//�湮�ߴٴ� ǥ��
		map[m][n] = 1;
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for(int i = 0 ; i < 4 ; i++) {
			int newx = m + dx[i];
			int newy = n + dy[i];
			
			if(0 <= newx && newx < M && 0 <= newy && newy < N && (map[newx][newy] == 0)) {
				area_++;
				dfs(newx, newy);
			}
		}
		return area_;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		map = new int[M][N];
		rec = new Point[K][2];
		
		for(int k = 0 ; k < K ; k++) {
			String[] xy = br.readLine().split(" ");
			rec[k][0] = new Point(Integer.parseInt(xy[0]),Integer.parseInt(xy[1]));
			rec[k][1] = new Point(Integer.parseInt(xy[2]), Integer.parseInt(xy[3]));
		}
		
		for(int k = 0 ; k < K ; k++) {
			for(int x = rec[k][0].x ; x < rec[k][1].x ; x++) {
				for(int y = rec[k][0].y ; y < rec[k][1].y ; y++) {
					map[x][y] = 1;
				}
			}
		}

		//dfs
		for(int m = 0 ; m < M ; m++) {
			for(int n = 0 ; n < N ; n++) {
				if(map[m][n] == 0) {
					devision_count++;
					area.add(dfs(m,n));
				}
				area_ = 1;
			}
		}
		//result sort
		Collections.sort(area);

		System.out.println(devision_count);
		
		for(int value = 0 ; value < area.size() ; value++)
			System.out.print(area.get(value) + " ");
		
	}

}
