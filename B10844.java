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
 * @name 		: 쉬운계단수
 * @description	: 점화식을 세워서 문제를 푸는 dp문제
 * 				 수학적으로, 손으로는 쉽게 풀었던 문제이지만 
 * 				해당 내용을 코드로 옮겨서 짜는 것이 어려웠던 문제. 
 * 				또한 풀이에 대한 접근을 잘못하기도 한 문제. 
 * 				처음엔 '값'에 치중해서 끝에 어떤 숫자가 오면 그 숫자가 어떤 숫자랑 연결되는지를 파악하고, 
 * 				그래서 그 연결되는 숫자를 트리형태로 묶어 개수를 세려 했으나 숫자 모두를 트리형태로 연결해서 관리하기엔 
 * 				데이터도 너무 많고 비효율적이다. 대신, 찾는 범위를 확장하여 '끝자리당 갯수' 의 접근이 훨씬 수월하다. 
 * 				예를들어 배열형태로 몇째 자리 숫자의 계단수는 몇개가 있다. 를 이전, 이후(-1, +1)의 형태로 관리하는 것이 키포인트.
 * 				사실 애초에 점화식을 세울 수 있는 접근 방식은 ~당 ~갯수 형태 밖에 없음!ㅎ   
 */

public class B10844 {
	
	private static int number;
	private static long[][] dp;
	
	public static void easyStairs(int N) {
		dp = new long[N+1][11];

		/*첫째항 초기화*/
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
					의 형태를 본다면, j==0 과 일반 식에서 겹쳐지는 부분은 dp[k-1][j-1] 부분. 
					이 부분을 떼어내면, j항목이 0일 때 뒤가 +1이므로 1으로 분리해낼 수 있다. 
					또한 j==9 일 때는, 애초에 배열을 11까지 둔다면 10은 의미 없는 숫자(0)가 되어 더해지는 의미가 없으므로 
					불필요한 코드 구분(if절)을 줄일 수 있다.  
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

