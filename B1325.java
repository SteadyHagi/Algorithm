package B1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1325 {
	static int nV;
	static int nE;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
	static int countNum[];
	static int max = 0;
	
	public static void dfs(int start) {
		visited[start] = true;
		
//		System.out.print(start + " ");
		
		for(int i : adList.get(start)) {
			if(!visited[i]) dfs(i);
		}
	}
	
	public static int count() {
		int temp = 0;
		for(int k = 0 ; k < nV+1; k++) {
			if(visited[k] == true)
				temp++;
		}
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nV = Integer.parseInt(st.nextToken());
		nE = Integer.parseInt(st.nextToken());
		visited = new boolean[nV+1];
		countNum = new int[nV+1];
		
		for(int i = 0 ; i < nV+1 ; i++) adList.add(new ArrayList<>());
		for(int i = 0 ; i < nE ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adList.get(v2).add(v1);
		}
		//adList ±¸Çö

		for(int i = 0 ; i < nV+1 ; i++) {

			dfs(i);
			countNum[i] = count();
			Arrays.fill(visited, false);
//			System.out.println(countNum[i]);
			if(countNum[i] > max) max = countNum[i];
		}
		
		for(int i = 0 ; i < nV+1 ; i ++) {
			if(countNum[i] == max) System.out.print(i + " ");
		}
	}
}