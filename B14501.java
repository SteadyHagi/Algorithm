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
 * @name		: ���
 * @description : 
 *  Point
 *  T(�ɸ��� �ϼ�)�� ���� ����ϴ���, P(���� �� �ִ� ����)�� ���� ����ϴ��� 
 *  
 *  P(����)�� ���� ����Ѵٸ�, ����� �Ŀ� ���ڰ� �������� �ʾƼ� �ٽ� T�� ����ؾ� �ϴ� ����� ���� �߻��ϱ� ������ 
 *  ó������ T�� ����ϰ�, �� �ȿ��� P�� ����ϴ� ���� �´�! 
 *  
 *  dp����. -> �׻� ���ϰ��� �ϴ� �� ���ַ�, ���ϰ��� �ϴ� ���� �����ϴ� ������� ����.! 
 *  dfs�����ε� Ǯ �� �ִ�! dfs�� Ǭ�ٰ� ���� �� ���������� Ǯ�̰� ������. dp�� �ȳ�. 
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
