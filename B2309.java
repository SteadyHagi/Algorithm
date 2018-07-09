package B2309;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2309 {
	static int[] numbers = new int[9];
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 9 ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers[i] = Integer.parseInt(st.nextToken());
			sum += numbers[i];
		}
		
		firstLoop:
        for(int i = 0 ; i < 9 ; i++) {
			for(int j = i+1 ; j < 9 ; j++) {
				if((numbers[i]+numbers[j]) == (sum-100)) {
					numbers[i] = 101; numbers[j] = 101;
					break firstLoop;
				}
			}
		}
		
		Arrays.sort(numbers);
		for(int i = 0 ; i < 7 ; i++) {
			System.out.println(numbers[i]);
		}		
	}
}