package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_1251_하나로_pq {

	static int TC, N;	// 테스트케이스, 섬개수
	static double E;	// 세율
	static long[][] adjMatrix;	// 인접행렬
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			int[] x = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				x[i] = Integer.parseInt(st.nextToken());
			} // N개 섬의 x좌표
			
			int[] y = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				y[i] = Integer.parseInt(st.nextToken());
			} // N개 섬의 Y좌표
			
			adjMatrix = new long[N][N];
			
			// 인접 행렬에 섬들 사이의 거리를 계산해서 넣는다
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					adjMatrix[i][j] = adjMatrix[j][i] = getDistance(x[i],x[j],y[i],y[j]);
				}
			}
			
			double E = Double.parseDouble(br.readLine()); // 환경세율 받기
			// end input
			
			System.out.println("#" + tc + " " + Math.round(E*makeMST()));
			
		}
	}

	private static long makeMST() {

		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];
		
		long result = 0;	// 리턴해줄 최소신장트리비용 저장하는 result
		int cnt = 0;		// 처리한 정점수
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;	// 0번 섬을 시작섬으로 한다..
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(0,minEdge[0]));
		
		
		while(true) {
			
			// 1단계 : 신장트리에 포함되지 않은 정점 중에 최소간선비용의 정점을 선택한다
			
			Vertex minVertex = pq.poll(); // 간선이 최소인 정점이 튀어나온당..
			
			if(visited[minVertex.no]) {
				continue;	// 해당 정점이 이미 처리되었다면
			}
			
			visited[minVertex.no] = true;	// 정점 방문 처리(신장트리에 포함시킴!)
			result += minVertex.cost;	// 간선비용 누적
			
			cnt++;
			if(cnt==N) break;	// 처리된 정점 개수가 N개가 되면 끝내기

			// 2단계 : 선택된 정점에서 신장트리에 포함되지 않은 다른 정점들로의 간선의 비용을 고려하여 minEdge 업데이트
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex.no][i] > 0 && minEdge[i] > adjMatrix[minVertex.no][i]){
					// 선택되지 않은 정점이고 && i정점과 현재정점(minNo) 가 연결되어있고
					// && i정점으로 기존 간선비용(minEdge[i])이 현재정점에서 오는 간선비용보다 크다면
					minEdge[i] = adjMatrix[minVertex.no][i]; // 업데이트
					pq.add(new Vertex(i, minEdge[i]));
				}
			}
		}
		
		
		return result;
	}

	// 두 정점(섬들) 사이의 거리를 계산하는 메소드
	private static long getDistance(int x1, int x2, int y1, int y2) { 
		return (long) (Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no; 
		long cost;
		public Vertex(int no, long cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}

	
}
