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
 * @name		: 영역 구하기
 * @description : 
 * 주어진 matrix가 실제 구현할 수 있는 행렬과 형태 및 입력 방법이 달라서 조금 당황했던 문제. 
 * 하지만 주어진 모형만 동일하다면 어차피 주어진 도형을 돌린 것에 불과하기 때문에 상관없다고 생각했고, 그냥 입력받아서 dfs 논리를 통해 풀었다. 
 * 논리만 동일하다면 형태는 별로 신경안써도 된다는 것을 깨닫게 됨. 
 *
 *	문제 푼 순서 및 논리 
 *	
 *	Point
 *	1. 0이 이루고 있는 도형이 몇개로 분기하는 지 어떻게 파악하는가? ->2중 for문을 통해 모두 검색 & 지나온 자취는 1으로 convert
 *	2. 0이 이루고 있는 도형의 넓이는 어떻게 파악? ->		dfs
 *
 *	각 직사각형의 좌표를 Point로 설정하여 좌표를 파악하기 쉽게 설정. 
 */
public class B2583 {
	private static int N,M,K, devision_count, area_ =1;
	private static int[][] map;
	private static ArrayList<Integer> area = new ArrayList<>();
	private static Point[][] rec;
	
	public static int dfs(int m, int n) {
		//방문했다는 표시
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
