package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author thkang0107
 * @start		: 20181005
 * @end			: 20181005
 * @category	: Brute Force / DFS - Backtracking
 * @name		: �ζ�
 * @description : 	 
 * 		Backtracking�� �������� ����. �ڷᱸ���� �ְ�, �Լ��� ������, �ڷᱸ��(Stack)���� ���� ���� �ִ� �����͸� �̰�.
 * 		cnt�� stack�� count�ϱ� ���� �뵵. �ʿ��� ��ŭ stack�� ä������, ���� print�ϰ� �� ���� ���� pop. 
 * 		idx�� stack�� ���� �������� index�� �����ϱ� ���� �뵵. �� �����͸� ���������� ���ÿ� �������. 		
 * 				
 * */
public class B6603 {
	private static int[] S;
	private static int K, G_S = 6;
	private static Stack<Integer> stack = new Stack<>();
	
	public static void backtracking(int idx, int cnt ) {
		
		if(cnt == G_S) {
			for(int i = 0 ; i < G_S ; i++ ) {
				System.out.print(stack.get(i) + " ");
			}System.out.println();return ;
		}
		
		for(int k = idx ; k < K ; k++) {
			stack.push(S[k]);
			backtracking(k + 1, cnt+1);
			stack.pop();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] line = br.readLine().split(" ");
			
			K = Integer.parseInt(line[0]);
			
			if(K == 0) {
				return ;
			}
			
			S = new int[K];
			for(int tc = 1 ; tc <= K ; tc++) {
				S[tc-1] = Integer.parseInt(line[tc]);
			}
			
			backtracking(0,0);
			System.out.println();
		}
	}
}
