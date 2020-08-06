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

// ���� ���� �����ϴ� Ŭ����
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
		return Integer.compare(this.weightVal, o.weightVal);	// ���� ��� �� ���� �ذ�
	}
	
} // �������� class end

public class swea_3124_�ּҽ��д�Ʈ�� {
	
	// main start
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());		// ���� ����
			int E = Integer.parseInt(st.nextToken());		// ���� ����
			InfoE[] infoE = new InfoE[E];					// ���� ���� �����ϴ� �迭
			
			for(int e=0;e<E;e++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;		// ��������
				int end = Integer.parseInt(st.nextToken())-1;			// ������
				int weightVal = Integer.parseInt(st.nextToken()); 	// ����ġ
				infoE[e] = new InfoE(start, end, weightVal);
			} // �Է� end
			
			Arrays.sort(infoE);	// ���� ����ġ�� �������� ����
			
			UnionFind uf = new UnionFind(V);
			
			uf.make();			// �����
			
			int count=0;
			
			long weight = 0;		// ����ġ
			for (int i = 0; i < E; i++) {
				if (!(uf.union(infoE[i].start, infoE[i].end))) {
					continue; // union ���� �� �����ϰ� ���� ��������
				}
				weight += infoE[i].weightVal; // ����ġ �����ֱ�
				count++;
				if (count == V - 1) { // V-1���� ������ �̾����� �ݺ��� ����
					break;
				}
			}
			
			System.out.println("#" + tc + " " +weight);
			
		} // tc end
		
	} // main end

} // class end
