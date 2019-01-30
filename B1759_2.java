package src;

import java.util.*;
import java.io.*;

/**
 * 
 * @author thkan0107
 * @start		: 20190128
 * @end			: 20190128
 * @category	: BACKTRACKING
 * @name		: 암호만들기
 * @description : 	 
 * 				1. 문자열은 char[] / ArrayList / String
 * 	셋 중 어디에 담을 것인가. 
 *  우선 String[]에 담아서 다음 자료구조로 옮길텐데, 옮기는 데 사용되는 용량, 시간을 최소화하여 최적화의 자료구조에 배치. 
 * 
 * */
public class B1759_2 {
	//초기에 입력받는 L과 C의 값이 다른 함수에 유용하게 쓰일 수 있기 때문에 STATIC으로 설정 
	private static int L, C;
	private static Stack<Integer> stack = new Stack<>();
	private static String[] line; 
	
	public static void makePasswd(int idx, int cnt) {
		if(cnt == L) {
			//stack에 쌓인 L개의 철자들이 모음1개 자음2개의 규칙을 지켰는지 테스트
			if(check()) {
				//규칙을 지켰다면 그대로 print
				for(int a = 0 ; a < stack.size() ; a++) {
					System.out.print(line[stack.get(a)]);
				}System.out.println();
			}
		}
		
		//궁극의 넣돌빼
		for(int i = idx ; i < C ; i++) {
			stack.push(i);
			makePasswd(i+1, cnt+1);
			stack.pop();
		}
	}
	
	public static boolean check() {
		int cnt = 0;
		//stack에 담긴 것들 중에서 모음이 있으면 cnt++
		for(int a = 0 ; a < stack.size() ; a++) {
			//본래 String과 char는 비교가 되지 않아서 새로운 자료구조에 입력받은 String배열 값들을 옮겨담아야 하나 고민했지만, 
			//어차피 각 string 배열(line[]) 중 첫번째 요소들만 검사하기 때문에 object.charAt(0)을 추가. 
			if(line[stack.get(a)].charAt(0) == 'a' || line[stack.get(a)].charAt(0) == 'e' 
					|| line[stack.get(a)].charAt(0) == 'i' || line[stack.get(a)].charAt(0) == 'o' || line[stack.get(a)].charAt(0) == 'u') {
				cnt++;
			}
		}
		
		//자음의 조건을 조합한 비밀번호의 갯수 - 모음의 갯수 
		if(cnt >= 1 && L-cnt >= 2)
			return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine().split(" ");
		
		L = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		//makePasswd에서 별도의 자료구조를 사용하지 않고 입력받은 그대로 사용하기 위해서 String[] line의 선언을 static으로 해준다. 
		line = br.readLine().split(" ");
		
		//철자순으로 이루어진 암호라는 조건이 있기 때문에 정렬을 해준다. 
		Arrays.sort(line);
		//backtracking함수 실시 
		makePasswd(0,0);
	}
}
