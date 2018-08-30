package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 		: thkan
 * @start		: 20180808
 * @finish		: 20180830
 * @category	: DP(Dynamic Programming)
 * @name 		: �����ܼ�
 * @description	: ��ȭ���� ������ ������ Ǫ�� dp����
 * 				 ����������, �����δ� ���� Ǯ���� ���������� 
 * 				�ش� ������ �ڵ�� �Űܼ� ¥�� ���� ������� ����. 
 * 				���� Ǯ�̿� ���� ������ �߸��ϱ⵵ �� ����. 
 * 				ó���� '��'�� ġ���ؼ� ���� � ���ڰ� ���� �� ���ڰ� � ���ڶ� ����Ǵ����� �ľ��ϰ�, 
 * 				�׷��� �� ����Ǵ� ���ڸ� Ʈ�����·� ���� ������ ���� ������ ���� ��θ� Ʈ�����·� �����ؼ� �����ϱ⿣ 
 * 				�����͵� �ʹ� ���� ��ȿ�����̴�. ���, ã�� ������ Ȯ���Ͽ� '���ڸ��� ����' �� ������ �ξ� �����ϴ�. 
 * 				������� �迭���·� ��° �ڸ� ������ ��ܼ��� ��� �ִ�. �� ����, ����(-1, +1)�� ���·� �����ϴ� ���� Ű����Ʈ.
 * 				��� ���ʿ� ��ȭ���� ���� �� �ִ� ���� ����� ~�� ~���� ���� �ۿ� ����!��   
 */

public class B10844 {
	
	private static int number;
	private static long[][] dp;
	
	public static void easyStairs(int N) {
		dp = new long[N+1][11];

		/*ù°�� �ʱ�ȭ*/
		for(int i = 1 ; i < 10 ; i++) {
			dp[1][i] = 1;
		}

		for(int k = 2 ; k <= N ; k++) {
			dp[k][0] = dp[k - 1][1];
			for(int j = 1 ; j <= 9 ; j++) {
				/*	if(j==0) {
						dp[k][j] = (dp[k-1][j+1]);
					}else if(j == 9) {
						dp[k][j] = (dp[k-1][j-1]);
					}else {
						dp[k][j] = (dp[k-1][j-1] + dp[k-1][j+1]);
					}
					�� ���¸� ���ٸ�, j==0 �� �Ϲ� �Ŀ��� �������� �κ��� dp[k-1][j-1] �κ�. 
					�� �κ��� �����, j�׸��� 0�� �� �ڰ� +1�̹Ƿ� 1���� �и��س� �� �ִ�. 
					���� j==9 �� ����, ���ʿ� �迭�� 11���� �дٸ� 10�� �ǹ� ���� ����(0)�� �Ǿ� �������� �ǹ̰� �����Ƿ� 
					���ʿ��� �ڵ� ����(if��)�� ���� �� �ִ�.  
				*/
				dp[k][j] = (dp[k - 1][j - 1] + dp[k - 1][j + 1]) % 1000000000;
				
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		
		number = Integer.parseInt(st.nextToken());
		
		easyStairs(number);
		
		for(int i = 0 ; i < 10 ; i++) {
			sum += dp[number][i];
		}
		System.out.println(sum%1000000000);
	}

}

