package B11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11403 {
	/**
	 * date : 2018.07.05
	 * 문제 이름 : 경로찾기
	 * 알고리즘 분류 : DFS 
	 */
	static int N;
	static int[][] matrix;
	static boolean[] visited;
	static int nV;
	
	public static void DFS(int start) {
		visited[start] = true;
		
		for(int i = 1 ; i <= N ; i++) {
			if(matrix[start][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		matrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		nV = N;
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j<= N ; j++) {
				if(matrix[i][j] == 1)
					DFS(j);
			}
			for(int j = 1 ; j <= N ; j++) {
				if(visited[j] == true) System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
			Arrays.fill(visited, false);
		}
		
	}
}
