package src;

import java.io.*;

/**
 * 
 * @author thkan0107
 * @start		: 20190128
 * @end			: 2019
 * @category	: 
 * @name		: 
 * @description : boolean[] alpha�� ���̸� ���ĺ��� ������ŭ 26���� ����� �־��� ���� ���ĺ��� ���ڷ� ��ȯ�Ͽ� alpha[]�� ����. 
 * �׷��� BACKTRACKING�� �ƴ϶� �ܼ��� DFS?	 
 * 				
 * backtraing�� ���� ��������, �ᱹ �߿��� ���� dfs�� ���� �Լ��� ȣ��� �ִ��� Ƚ��(�� ��η� �� ���� �� Ƚ��)��� ���� ���޾Ҵ�!
 * */
public class B1987_2 {
	private static int R, C, max;
	//��ǥ�� ��Ÿ���� ���� ����
	private static int[] dy = {0, 1, 0, -1};
	private static int[] dx = {1, 0, -1, 0};
	//�迭�� ���̸� ���ĺ�������ŭ �༭ CHECKING�ϱ� ���ϵ��� ����
	private static boolean[] alpha = new boolean[26];
	private static String[] line;
	
	//�߿��� ����Ʈ�� �ᱹ �Լ��� ȣ��Ǵ� ���ڸ�ŭ ���ĺ��� ������ ���̹Ƿ� 'dfs�� �� ��ο� ���� ȣ��� �Լ��� ���� = ���ϰ��� �ϴ� �ִ� ĭ ��'�� �ȴ�.
	public static void alphabet(int y, int x, int cnt) {
		int loc = line[y].charAt(x) - 'A';//65�� �ϰų� 'A'�� �ϰų� ����� ����. 
		alpha[loc] = true;
		cnt++;
		if(max < cnt) max = cnt;
		for(int i = 0 ; i < 4 ; i++) {
			int newy = y + dy[i];
			int newx = x + dx[i];
			
			//�־��� Ʋ�� ����� �ʵ��� BOUNDARY ����
			if( 0<=newy && newy<R && 0<=newx && newx<C) {
				int newloc = line[newy].charAt(newx) - 'A';
				//�����ƴ� ���ĺ����� üũ
				if(!alpha[newloc]) {
					alpha[newloc] = true;
					alphabet(newy, newx, cnt);
					alpha[newloc] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine().split(" ");
		
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		line = new String[R];
		//�� ���ĺ��� ARRAY[INDEX1].CHARAT[INDEX2]�� ��Ÿ���� �־��� LINE�� ���� �ٲ��� �ʰ� �ٷ� ���
		//�� �׸��� ����ϴ°� ������ VS �̸� �Է°��� ���� �� ���ڷ� ��ȯ�ϴ� �� ������
		for(int r = 0 ; r < R ; r++) {
			line[r] = br.readLine();
		}
		alphabet(0,0,0);
		
		System.out.println(max);
	}
}
