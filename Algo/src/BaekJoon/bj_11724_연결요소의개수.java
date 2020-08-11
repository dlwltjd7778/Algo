package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_11724_연결요소의개수 {

	static boolean[] visit;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
			
	}

	// Union Find
	class UnionFind{	
		int V;
		int[] parents;
		
		public UnionFind(int v) {
			V = v;
		}
		void make() {
			parents = new int[V];
			for (int i = 0; i < V; i++) {
				parents[i] = i;
			}
		}
		int find(int a) {
			if(parents[a]==a) return a;
			return parents[a] = find(parents[a]);	// path compression
		}
		
		boolean union(int a, int b) {
			int aRoot = find(a);
			int bRoot = find(b);
			if(aRoot == bRoot) return false;
			
			parents[bRoot] = aRoot;
			return true;
		}
	} // unionFind end
	
	
	
}
