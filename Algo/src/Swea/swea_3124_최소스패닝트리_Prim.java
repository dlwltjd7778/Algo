package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_3124_최소스패닝트리_Prim {

	static int TC, V, E;	// 테스트케이스 수, 정점개수, 간선개수
	static List<Edge>[] list;	// 간선 정보 담을 배열.. > V+1 개 만큼의 배열 가짐
	static boolean[] visit;	// 정점 방문 확인 여부 .. > V+1개 ( 0번 인덱스는 안씀 )
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			visit = new boolean[V+1];
			
			for(int i=0;i<=V;i++) {
				list[i] = new ArrayList<>();	// 각 리스트 선언해놓기..
			//	minEdge[i] = Integer.MAX_VALUE;	// 최댓값으로 채워놓기..
			}
			for(int i=1;i<=E;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[start].add(new Edge(end, weight));	// 리스트에 연결 정보 추가해준다..
				list[end].add(new Edge(start,weight));	// 양방향..
			} // input end
			
			long result = 0;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(1, 0));	// 처음 시작 값 넣어준다..
			
			
			while(!pq.isEmpty()) {
				
				Edge now = pq.poll(); // pq에서 가장 짧은걸 꺼낸다 >> 현재 경유지
				if (visit[now.end])
					continue; // 이미 방문했던 경유지면 제낌..ㅎ
				
				visit[now.end] = true; // 경유지를 방문처리함
				
				result += now.weight;

				for (Edge e : list[now.end]) { // 현재 경유지에서 나가는(출발하는) 간선을 다 꺼내기..
					if (!visit[e.end]) {
						// 나와 연결된 정점들을 돌면서 방문 안했으면.. 추가해줌
						pq.add(e);
					}
				}
				
				
				
			}
			
			System.out.println("#" + tc + " " + result);
			
		} // tc end
		
	}
	
	static class Edge implements Comparable<Edge>{
		int end, weight; // 누구에게 가는 간선인지.. 가중치는 몇인지..
		Edge(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight- o.weight;	// 비용 priority queue로 비교하기 위해,,
		}
	}
}
