package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author		: thkang0107
 * @start		: 20180828
 * @end			: 20180830
 * @category	: dp & dfs
 * @name		: 퇴사
 * @description : 
 *  Point
 *  T(걸리는 일수)를 먼저 계산하느냐, P(얻을 수 있는 이익)을 먼저 계산하느냐 
 *  
 *  P(이익)를 먼저 계산한다면, 계산한 후에 일자가 적합하지 않아서 다시 T를 계산해야 하는 경우의 수가 발생하기 때문에 
 *  처음부터 T를 계산하고, 그 안에서 P를 계산하는 것이 맞다! 
 *  
 *  dp문제. -> 항상 구하고자 하는 것 위주로, 구하고자 하는 것을 추적하는 방식으로 들어간다.! 
 *  dfs문제로도 풀 수 있다! dfs로 푼다고 했을 때 직관적으로 풀이가 생각남. dp는 안남. 
 */

public class B14501 {
	
	private static int N; 
	private static int[] T;
	private static int[] P;
	private static int[] dp;
	
	public static int dp (int start) {
//		System.out.println(start);
//		System.out.println(P[start]);
//		System.out.println(dp[start]);
		
		if(start > N+1) return -987654321;
		
		if(start == N+1) return 0;
		
		if(dp[start] > 0) return dp[start];
		
		return dp[start] = Math.max(dp(start+1), dp(start+T[start]) +P[start]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = new int[N+1];
		P = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1 ; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dp(1);
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}
	
}
