package programmers;

import java.util.Arrays;


public class pg_네트워크 {
	
// Union Find
	static class UnionFind{	
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
			return parents[a] = find(parents[a]);	
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
	static class InfoE implements Comparable<InfoE>{
		int start,end,weightVal;
		
		public InfoE(int start, int end, int weightVal) {
			this.start = start;
			this.end = end;
			this.weightVal = weightVal;
		}
		@Override
		public int compareTo(InfoE o) {
			if(this.weightVal == o.weightVal) {
				return Integer.compare(this.start, o.start);
			}
			return Integer.compare(this.weightVal, o.weightVal);
		}
		
	} // 간선정보 class end
	public static int solution(int n, int[][] network, int[][] repair) {
		int infoENum = network.length + repair.length;
		InfoE[] infoE = new InfoE[infoENum];		// 간선 정보 저장하는 배열
		for(int i=0;i<network.length;i++) {
			int start = network[i][0]-1;
			int end = network[i][1]-1;
			int weightVal = 0;
			infoE[i] = new InfoE(start, end, weightVal);
		}
		for(int i=0;i<repair.length;i++) {
			int start = repair[i][0]-1;
			int end = repair[i][1]-1;
			int weightVal = repair[i][2];
			infoE[network.length+i] = new InfoE(start, end, weightVal);
		}
		
		Arrays.sort(infoE);	// 간선 가중치로 오름차순 정렬
		
		UnionFind uf = new UnionFind(n);
		
		uf.make();			// 만들기
		
		int count=0;
		
		int weight = 0;		// 가중치
		for (int i = 0; i < infoENum; i++) {
			if (!(uf.union(infoE[i].start, infoE[i].end))) {
				continue; // union 실패 시 중지하고 다음 간선으로
			}
			weight += infoE[i].weightVal; // 가중치 더해주기
			count++;
			if (count == n - 1) { // n-1개의 간선을 뽑았으면 반복문 중지
				return weight;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {

		int n = 6;
		int[][] network = {{1,2},{3,5},{4,2},{5,6}};
		int[][] repair = {{3,2,10},{5,4,15}};
		
//		int n = 4;
//		int[][] network = {{1,2}};
//		int[][] repair = {{2,3,10},{3,1,12}};
		
		System.out.println(solution(n, network, repair));
	}

} // class end
