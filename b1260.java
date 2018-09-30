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
 * @name		: DFS�� BFS
 * @description : 
 *  DFS �� BFS�� �󸶳� �� �����ϰ� �ִ°� �� ���� ����. 
 *  ����ؼ� �����ߴ� ���� 
 *  1. �������� NODE�� ���� �� ���� ���ں��� Ž���ؾ��Ѵٴ� ������ ���Ծ���. 
 *  2. ArrayList�� ������ �� ������ N���� �ؾ��ߴµ� N-1�� �ߴ�. 
 *  3. bfs���� �Լ��� �Ķ���Ͱ� �ƴ� q���� peek�� ���ڸ� adList�� �˻��������� �־�� �ϴµ� �� ó�� �Լ��� �ԷµǴ� �Ķ���͸� ���� �˻����� �ִ� �Ǽ��� �ؼ� 
 *  bfs�� ������ ���� �ʰ� ù��° ��常 Ž���ϰ� �������ȴ�. 
 *  ���⼭�� ���� ���� ����Ʈ�� �˻��Ͽ����� ��������Ʈ�� �迭 Ȥ�� ����������� �����ص� ���� �� ����. 
 *  (��� �� ���� �����ս��� �� �� ����.) 
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
