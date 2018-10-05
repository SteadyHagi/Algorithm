package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author		: thkang0107
 * @start		: 20181005
 * @end			: 20181005
 * @category	: dfs & bfs
 * @name		: DFS와 BFS
 * @description : 
 *  DFS 와 BFS를 얼마나 잘 이해하고 있는가 를 묻는 문제. 
 * 	인접행렬으로 구현한 것이고, 인접리스트가 훨씬 낫다 
 */
public class B1260_matrixing {
	private static int[][] map;
	private static int N, M, V;
	private static boolean[] visited; 
	
	public static void DFS(int V) {
		System.out.print(V + " ");
		visited[V] = true; 
		
		for(int n = 1 ; n <= N ; n++) {
			if(map[V][n] == 1 && !visited[n]) {
				DFS(n);
			}
		}
	}
	
	public static void BFS(int V) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(V);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			visited[node] = true;
			
			System.out.print(node + " ");
			for(int n = 1 ; n <= N ; n++) {
				if(map[node][n] == 1 && !visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int m = 0 ; m < M ; m++) {
			String[] line = br.readLine().split(" ");
			int v1 = Integer.parseInt(line[0]);
			int v2 = Integer.parseInt(line[1]);
			
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		DFS(V);
		System.out.println();
		Arrays.fill(visited, false);
		BFS(V);
	}

}
