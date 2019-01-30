package src;

import java.io.*;

/**
 * 
 * @author thkan0107
 * @start		: 20190128
 * @end			: 2019
 * @category	: 
 * @name		: 
 * @description : boolean[] alpha의 길이를 알파벳의 개수만큼 26개로 만들어 주어진 값의 알파벳을 숫자로 변환하여 alpha[]에 대입. 
 * 그런데 BACKTRACKING이 아니라 단순한 DFS?	 
 * 				
 * backtraing에 관한 문제였고, 결국 중요한 것은 dfs를 통해 함수가 호출된 최대의 횟수(한 경로로 쭉 많이 간 횟수)라는 것을 깨달았다!
 * */
public class B1987_2 {
	private static int R, C, max;
	//좌표를 나타내기 위한 설정
	private static int[] dy = {0, 1, 0, -1};
	private static int[] dx = {1, 0, -1, 0};
	//배열의 길이를 알파벳개수만큼 줘서 CHECKING하기 편하도록 설정
	private static boolean[] alpha = new boolean[26];
	private static String[] line;
	
	//중요한 포인트는 결국 함수가 호출되는 숫자만큼 알파벳을 지나는 것이므로 'dfs로 한 경로에 많이 호출된 함수의 숫자 = 구하고자 하는 최대 칸 수'가 된다.
	public static void alphabet(int y, int x, int cnt) {
		int loc = line[y].charAt(x) - 'A';//65로 하거나 'A'로 하거나 결과는 동일. 
		alpha[loc] = true;
		cnt++;
		if(max < cnt) max = cnt;
		for(int i = 0 ; i < 4 ; i++) {
			int newy = y + dy[i];
			int newx = x + dx[i];
			
			//주어진 틀을 벗어나지 않도록 BOUNDARY 설정
			if( 0<=newy && newy<R && 0<=newx && newx<C) {
				int newloc = line[newy].charAt(newx) - 'A';
				//지나쳤던 알파벳인지 체크
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
		//각 알파벳을 ARRAY[INDEX1].CHARAT[INDEX2]로 나타내어 주어진 LINE을 따로 바꾸지 않고 바로 계산
		//각 항목을 계산하는게 빠를까 VS 미리 입력값을 받을 때 숫자로 변환하는 게 빠를까
		for(int r = 0 ; r < R ; r++) {
			line[r] = br.readLine();
		}
		alphabet(0,0,0);
		
		System.out.println(max);
	}
}
