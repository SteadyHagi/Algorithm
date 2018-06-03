package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author thkan
 * @category algorithm - Depth First Search
 * @version 1.0.0
 * @date 18.06.03
 * @function dfs(int start) - 깊이 우선 탐색을 실행하는 함수
 *
 */

public class DFS {
	static int nV;
	static int nE;
	static int start;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adList = new ArrayList<>();

	public static void dfs(int start) {
		visited[start] = true;
		
		System.out.print(start + " ");
		
		for(int i : adList.get(start-1)) {
			if(!visited[i]) dfs(i);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		
//		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1]; 
		nV = Integer.parseInt(st.nextToken());
		visited = new boolean[nV+1];
		nE = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < nV ; i++) adList.add(new ArrayList<>());
		
		for(int i = 0 ; i < nE ; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adList.get(v1-1).add(v2);
			adList.get(v2-1).add(v1);
		}
		
		dfs(start);
	}	 

}
