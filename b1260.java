package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author		: thkang0107
 * @start		: 20180913
 * @end			: 20180930
 * @category	: dfs & bfs
 * @name		: DFS와 BFS
 * @description : 
 *  DFS 와 BFS를 얼마나 잘 이해하고 있는가 를 묻는 문제. 
 *  계속해서 실패했던 이유 
 *  1. 여러개의 NODE가 있을 때 작은 숫자부터 탐색해야한다는 조건을 빼먹었다. 
 *  2. ArrayList를 정렬할 때 범위를 N까지 해야했는데 N-1로 했다. 
 *  3. bfs에서 함수의 파라미터가 아닌 q에서 peek한 숫자를 adList의 검색조건으로 넣어야 하는데 맨 처음 함수에 입력되는 파라미터를 조건 검색으로 넣는 실수를 해서 
 *  bfs가 끝까지 돌지 않고 첫번째 노드만 탐색하고 끝나버렸다. 
 *  여기서는 이중 인접 리스트로 검색하였으나 인접리스트의 배열 혹은 인접행렬으로 구현해도 좋을 것 같다. 
 *  (사실 더 나은 퍼포먼스를 낼 것 같다.) 
 */

public class b1260 {
	private static int N;
	private static int M;
	private static int V;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
	
	public static void dfs(int nV) {
		visited[nV] = true;
		System.out.print(nV + " ");
		
		for(int i : adList.get(nV)) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int nV) {
		Queue<Integer> q = new LinkedList<>();
		q.add(nV);
		visited[nV] = true;
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			System.out.print(temp + " ");
			
			for(int i : adList.get(temp)) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		
		N = Integer.parseInt(info[0]);
		visited = new boolean[N+1];
		M = Integer.parseInt(info[1]);
		V = Integer.parseInt(info[2]);
		
		for(int n = 0 ; n <= N ; n++) {
			adList.add(new ArrayList<>());
		}
		
		for(int m = 0 ; m < M ; m++) {
			String[] vertexs = br.readLine().split(" ");
			int v1 = Integer.parseInt(vertexs[0]);
			int v2 = Integer.parseInt(vertexs[1]);
			
			if(adList.get(v1).contains(v2) || adList.get(v2).contains(v1)) {
				continue;
			}else {
				adList.get(v1).add(v2);
				adList.get(v2).add(v1);
			}
		}

		for(int i = 0 ; i <= N ; i ++) {
			Collections.sort(adList.get(i));
		}
			
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
	}
}
