package src;

import java.util.*;
import java.io.*;

/**
 * 
 * @author thkan0107
 * @start		: 20190128
 * @end			: 20190128
 * @category	: BACKTRACKING
 * @name		: ��ȣ�����
 * @description : 	 
 * 				1. ���ڿ��� char[] / ArrayList / String
 * 	�� �� ��� ���� ���ΰ�. 
 *  �켱 String[]�� ��Ƽ� ���� �ڷᱸ���� �ű��ٵ�, �ű�� �� ���Ǵ� �뷮, �ð��� �ּ�ȭ�Ͽ� ����ȭ�� �ڷᱸ���� ��ġ. 
 * 
 * */
public class B1759_2 {
	//�ʱ⿡ �Է¹޴� L�� C�� ���� �ٸ� �Լ��� �����ϰ� ���� �� �ֱ� ������ STATIC���� ���� 
	private static int L, C;
	private static Stack<Integer> stack = new Stack<>();
	private static String[] line; 
	
	public static void makePasswd(int idx, int cnt) {
		if(cnt == L) {
			//stack�� ���� L���� ö�ڵ��� ����1�� ����2���� ��Ģ�� ���״��� �׽�Ʈ
			if(check()) {
				//��Ģ�� ���״ٸ� �״�� print
				for(int a = 0 ; a < stack.size() ; a++) {
					System.out.print(line[stack.get(a)]);
				}System.out.println();
			}
		}
		
		//�ñ��� �ֵ���
		for(int i = idx ; i < C ; i++) {
			stack.push(i);
			makePasswd(i+1, cnt+1);
			stack.pop();
		}
	}
	
	public static boolean check() {
		int cnt = 0;
		//stack�� ��� �͵� �߿��� ������ ������ cnt++
		for(int a = 0 ; a < stack.size() ; a++) {
			//���� String�� char�� �񱳰� ���� �ʾƼ� ���ο� �ڷᱸ���� �Է¹��� String�迭 ������ �Űܴ�ƾ� �ϳ� ���������, 
			//������ �� string �迭(line[]) �� ù��° ��ҵ鸸 �˻��ϱ� ������ object.charAt(0)�� �߰�. 
			if(line[stack.get(a)].charAt(0) == 'a' || line[stack.get(a)].charAt(0) == 'e' 
					|| line[stack.get(a)].charAt(0) == 'i' || line[stack.get(a)].charAt(0) == 'o' || line[stack.get(a)].charAt(0) == 'u') {
				cnt++;
			}
		}
		
		//������ ������ ������ ��й�ȣ�� ���� - ������ ���� 
		if(cnt >= 1 && L-cnt >= 2)
			return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine().split(" ");
		
		L = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		//makePasswd���� ������ �ڷᱸ���� ������� �ʰ� �Է¹��� �״�� ����ϱ� ���ؼ� String[] line�� ������ static���� ���ش�. 
		line = br.readLine().split(" ");
		
		//ö�ڼ����� �̷���� ��ȣ��� ������ �ֱ� ������ ������ ���ش�. 
		Arrays.sort(line);
		//backtracking�Լ� �ǽ� 
		makePasswd(0,0);
	}
}
