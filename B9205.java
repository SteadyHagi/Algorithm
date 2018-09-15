package src;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author thkan
 * @start		: 20180809
 * @end			: 20180915
 * @category	: dfs
 * @name		: ���ָ��ø鼭 �ɾ��
 * @description : 	 
     *             sorting�ϴ��� while�� ������ ���ذ��� 1000�̸��� ������ �����ϴ°� ���ѵ�..? ��� �̷� ��Ư��
	 *             ������ ����..? �ᱹ ������ �ϱ� �ؾߵǳ�...
	 * 
	 *             �ܼ��� sorting���� ���� ����Ǯ�̰� ������ �� �� ���� ����: ��ǥ�� �� x, y�� ������ ���ԵǱ� ������,
	 *             �������� ��ġ�� �� 2, 3, 4 ��и��� ���� ��Ÿ�� �� �ִ�. �׷��� �Ǹ�, �ܼ��� sorting�� ���� �� ��
	 *             2, 3, 4 �и��� �Ÿ��� ª�� ������ ���ԵǾ� �����δ� happy�� ����� �������� ������ ���� ��Ÿ��Ʈ�� �Ÿ���
	 *             ��� sad�ϴٰ� ����� ���� ���� �ִ�. ���� ���, (0,0), (1000,0), (-1000,0),
	 *             (2000,0)���� ��ǥ�� �־����� ���.
	 * 
	 *             ���� ��Ȯ�� �ع���
	 * 
	 *             1) ������ ��ǥ���� �Ÿ��� 1000 ������ ���� edge�� �׾� �׷����� �׸���. 2) 1�� �Ϸ� ��, ��������
	 *             ���� �׷����� ������ sad, ������ happy�� print
	 * 
	 *             ��ü�� ���. 2�� ArrayList�� ���ؼ� �Ÿ��� 1000�̸��� ��ǥ���� �����Ѵ�. dfs�� ���� �׸��� ����.
	 *             ArrayList�� Iterator�� ����, pentaport�� ��ǥ�� �ִ��� Ȯ��.
	 * 
	 *             -------------------------------------------------------------------------------------------------------------------------------------------
	 *             �ᱹ sorting�� �ʿ� ����, �־��� ��ǥ���� ��� �迭�� ó������ ������ �˻��ϴ� ���� ������ �ݺ��ؼ� �����
	 *             ���� ������ �����ϸ� �ȴ�. �ʹ� ���� ���Ƽ� ������ ����.

 * */
public class B9205 {

	private static Point[] location;
	private static boolean check[];
	private static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TestCase; tc++) {
			boolean success = false;
			
			//������ ����
			int N = Integer.parseInt(br.readLine());
			location = new Point[N+2];
			check = new boolean[N+2];
			for(int n = 0 ; n < N+2 ; n ++) {
				String[] str; 
				str = br.readLine().split(" ");
				//���� ������, ��Ÿ��Ʈ�� ��ǥ �Է� �Ϸ� 
				location[n] = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			q.add(location[0]);
			Point end = location[N+1];
			
//			Ž���ϴ� ����� queue�� ���±� ������ ���� ����� ������ �� ��! 
			while(!q.isEmpty()) {
				
				Point temp = q.poll();
				
				if(temp == end) {
					success = true;
					break;
				}
				
				for(int n = 1 ; n < N+2 ; n++) {
					if( check[n] == false && (Math.abs(temp.x - location[n].x) + Math.abs(temp.y - location[n].y)) <= 1000) {
						q.add(location[n]);
						check[n] = true;
					}
				}
			}
			
			if(success == true) {
				System.out.println("happy");				
			}
			else {
				System.out.println("sad");
			}
		}
	}
}
