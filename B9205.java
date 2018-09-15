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
 * @name		: 맥주마시면서 걸어가기
 * @description : 	 
     *             sorting하느니 while문 돌려서 비교해가며 1000미만이 있으면 삭제하는게 편한듯..? 어떻게 이런 기특한
	 *             생각을 했지..? 결국 솔팅을 하긴 해야되네...
	 * 
	 *             단순한 sorting으로 인한 문제풀이가 정답이 될 수 없는 이유: 자표의 값 x, y가 음수도 포함되기 때문에,
	 *             편의점의 위치가 제 2, 3, 4 사분면의 값이 나타날 수 있다. 그렇게 되면, 단순한 sorting을 했을 때 제
	 *             2, 3, 4 분면의 거리가 짧은 점들이 포함되어 실제로는 happy한 경우의 수이지만 음수의 값과 펜타포트의 거리가
	 *             길어 sad하다고 결과가 나올 수도 있다. 예를 들어, (0,0), (1000,0), (-1000,0),
	 *             (2000,0)으로 좌표가 주어지는 경우.
	 * 
	 *             따라서 정확한 해법은
	 * 
	 *             1) 각각의 좌표간의 거리가 1000 이하일 때만 edge를 그어 그래프를 그린다. 2) 1번 완료 후, 목적지의
	 *             값이 그래프에 없으면 sad, 있으면 happy를 print
	 * 
	 *             구체적 방안. 2중 ArrayList를 통해서 거리가 1000미만인 좌표들을 연결한다. dfs를 통해 그리면 간편.
	 *             ArrayList의 Iterator를 만들어서, pentaport의 좌표가 있는지 확인.
	 * 
	 *             -------------------------------------------------------------------------------------------------------------------------------------------
	 *             결국 sorting이 필요 없이, 주어진 좌표들이 담긴 배열을 처음부터 끝까지 검색하는 것을 여러번 반복해서 결과가
	 *             나올 때까지 지속하면 된다. 너무 빙빙 꼬아서 생각한 문제.

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
			
			//편의점 개수
			int N = Integer.parseInt(br.readLine());
			location = new Point[N+2];
			check = new boolean[N+2];
			for(int n = 0 ; n < N+2 ; n ++) {
				String[] str; 
				str = br.readLine().split(" ");
				//집과 편의점, 펜타포트의 좌표 입력 완료 
				location[n] = new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			q.add(location[0]);
			Point end = location[N+1];
			
//			탐색하는 방식이 queue의 형태기 때문에 구현 방식을 빌리는 것 뿐! 
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
