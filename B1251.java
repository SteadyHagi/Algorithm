package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1251 {
	/**
	 * 20180712
	 * �ܾ����
	 * ���Ʈ����
	 * �׳� �������� �ܾ �����ϴ� �������� ������ 
	 * ������ ������ �ּڰ� ����ϸ� ��. 
	 * string�� �ּڰ� �ľǰ� string -> char[] , char[] -> string �κ��� ��������. 
	 */
	/**
	 * 
	 * @param string
	 * @return string
	 */
	public static String reverseWord(String string) {
		char[] str = string.toCharArray();
		
		for(int i = 0 ; i < str.length/2 ; i++) {
			char temp = str[i];
			str[i] = str[str.length-i-1];
			str[str.length-1-i] = temp;
		}
		
		string = String.valueOf(str);
		return string;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String word = st.nextToken();
		String minimum = "z";
		int a = 0;
		for(int i = 1; i < word.length() ; i++) {
			for(int j = i + 1 ; j < word.length() ; j++) {
				String compare = reverseWord(word.substring(0,i)) + reverseWord(word.substring(i, j)) +reverseWord(word.substring(j,word.length()));  
				if( a < minimum.compareTo(compare) ){ minimum = compare;}
			}
		}
		System.out.println(minimum);
	}
}
