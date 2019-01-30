package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author thkan
 *
 *
 *	조건을 빼먹음. 최소 한개의 모음과 두개의 자음. 
 *  y는 모음이 아니다. 
 *  
 *//**
 * 
 * @author thkang0107
 * @start		: 20180915
 * @end			: 20181006
 * @category	: BACKTRACKING
 * @name		: 알파벳
 * @description : 	 
 * 				여러가지 경로를 비교해야 하는 문제. 
 * 				왔던 경로를 되돌아가는 백트래킹이 섞여있는 문제이다. 
 * 				다시 풀어보고 정확하게 이해할 것!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * */
public class B1759 {
	private static int L, C;
	private static char[] passwd;
	private static Stack<Character> s = new Stack<>();
	
	public static void backtracking(int count, int cnt) {
		
		if(cnt == L) {
			if(check()) {
				for(int i = 0 ; i < L ; i++) {
					System.out.print(s.get(i));
					if(i == (L-1)) System.out.println();
				}return;
			}
		}
		
		for(int i = count ; i < C ; i++) {
			s.push(passwd[i]);
			backtracking(i+1, cnt+1);
			s.pop();
		}
	}
	
	public static boolean check() {
		int moum = 0;
		
		for(int i = 0 ; i < s.size() ; i++){
			if(s.get(i).equals('a') || s.get(i).equals('e') || s.get(i).equals('i') || s.get(i).equals('o') || s.get(i).equals('u')) {
				moum++;
			}
		}
		if( moum >= 1 && (s.size() - moum)>=2 ) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		passwd = new char[C];
		
		String line = br.readLine();
		line = line.replace(" ","");
		passwd = line.toCharArray();
		
		Arrays.sort(passwd);
		
		backtracking(0,0);
	}
}
