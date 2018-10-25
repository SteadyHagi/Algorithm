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
 * @name		: 로또
 * @description : 	 
 * 		Backtracking의 전형적인 형태. 자료구조에 넣고, 함수를 돌리고, 자료구조(Stack)에서 가장 위에 있는 데이터를 뽑고.
 * 		cnt는 stack을 count하기 위한 용도. 필요한 만큼 stack이 채워지면, 값은 print하고 맨 위의 값은 pop. 
 * 		idx는 stack에 넣을 데이터의 index를 가늠하기 위한 용도. 각 데이터를 순차적으로 스택에 집어넣음. 		
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
