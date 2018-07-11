package B2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2579 {
	/**
	 * 20180712
	 * 계단오르기
	 * dp
	 * 점화식을 세우면 쉽게 풀 수 있는 문제. 
	 * 수기가 끝나는 시점에서 특성을 파악해 바로 점화식을 세울 수 있어야 한다. 
	 */
	
	static int TC;
	static int[] stairs;
	static int[] max;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		stairs = new int[TC];
		max = new int[TC];
		for(int i = 0 ; i < TC ; i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i] = Integer.parseInt(st.nextToken());
		}
		
		max[0] = stairs[0];
		max[1] = stairs[0]+stairs[1];
		max[2] = Math.max(stairs[2]+stairs[1], stairs[0]+stairs[2]);
		for(int i = 3; i < TC ; i++) {
			max[i] = Math.max(stairs[i] + max[i-2], stairs[i] + stairs[i-1] + max[i-3]);
		}
		
		System.out.println(max[TC-1]);
	}
}