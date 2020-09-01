package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1753_최단경로 {

	static int N, K; 			// 정점개수, 간선개수
	static int start; 			// 출발정점
	static List<Edge>[] list;	// 인접 리스트 : 하나하나가 리스트!! 리스트 배열을 만든다..
	static StringBuilder sb;	// 출력이 많아서 이어붙이기 할 때 쓸거임..
	static boolean[] visit;
	static int[] distance;		// 출발점에서 다른 모든 정점까지의 거리 기록하는 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];	// 0번 안쓰고 1번 ~ N번까지 리스트 쓰려구..
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();	// 각 정점마다 리스트 생성해주기
		}
		
		visit = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0;i<K;i++) { // 간선정보 입력
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());	// 간선 출발 정점 
			int to = Integer.parseInt(st.nextToken());	// 간선 도착 정점
			int d = Integer.parseInt(st.nextToken());	// 간선 길이
			list[from].add(new Edge(to, d));
		} // input end
		
		// 드디어 입력 및 초기화 끝..
		
		// 다익스트라 시작!
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.add(new Edge(start, 0));	// 스타트가 경유지처럼 처리되게 하려고!! 거리를 0으로 해서 start에게 오는..?
		
		while(!pq.isEmpty()) {	// pq에 있는 가장 짧은 간선 먼저 나온다..!
			
			int now = pq.poll().num;	// pq에서 가장 짧은걸 꺼낸다 >> 현재 경유지
			
			if(visit[now]) continue;	// 이미 방문했던 경유지면 제낌..ㅎ
			
			visit[now] = true;	// 경유지를 방문처리함
			
			for(Edge e: list[now]) { // 현재 경유지에서 나가는(출발하는) 간선을 다 꺼내보자..!
				if(distance[e.num] > distance[now] + e.dist) {	
					// 현재 간선을 따라가면 있는 정점까지의 기존거리보다 now를 거쳐가는게 나으면
					distance[e.num] = distance[now] + e.dist;
					pq.add(new Edge(e.num, distance[e.num]));	
					
				}
			}
		}
		
		sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			sb.append((distance[i]==Integer.MAX_VALUE?"INF":distance[i]) +  "\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	
	static class Edge implements Comparable<Edge>{	// 누구에게 가는 간선인지, 길이가 몇인지를 저장하는 클래스
		int num, dist;	// 								> num			> dist
		
		Edge(int num, int dist){
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;	// 거리순으로 정렬..
		}
	}
			
}
