package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

// 간선 정보 저장하는 클래스
class InfoE implements Comparable<InfoE>{
	int start,end,weightVal;
	
	public InfoE(int start, int end, int weightVal) {
		this.start = start;
		this.end = end;
		this.weightVal = weightVal;
	}
	@Override
	public int compareTo(InfoE o) {
		// return this.weightVal - o.weightVal;
		return Integer.compare(this.weightVal, o.weightVal);	// 음수 양수 비교 문제 해결
	}
	
} // 간선정보 class end

public class swea_3124_최소스패닝트리_Kruskal {
	
	// main start
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());		// 정점 개수
			int E = Integer.parseInt(st.nextToken());		// 간선 개수
			InfoE[] infoE = new InfoE[E];					// 간선 정보 저장하는 배열
			
			for(int e=0;e<E;e++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;		// 시작정점
				int end = Integer.parseInt(st.nextToken())-1;			// 끝정점
				int weightVal = Integer.parseInt(st.nextToken()); 	// 가중치
				infoE[e] = new InfoE(start, end, weightVal);
			} // 입력 end
			
			Arrays.sort(infoE);	// 간선 가중치로 오름차순 정렬
			
			UnionFind uf = new UnionFind(V);
			
			uf.make();			// 만들기
			
			int count=0;
			
			long weight = 0;		// 가중치
			for (int i = 0; i < E; i++) {
				if (!(uf.union(infoE[i].start, infoE[i].end))) {
					continue; // union 실패 시 중지하고 다음 간선으로
				}
				weight += infoE[i].weightVal; // 가중치 더해주기
				count++;
				if (count == V - 1) { // V-1개의 간선을 뽑았으면 반복문 중지
					break;
				}
			}
			
			System.out.println("#" + tc + " " +weight);
			
		} // tc end
		
	} // main end

} // class end
