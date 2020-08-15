package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1012_유기농배추_bfs {

	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int TC, N, M, K; 		// 테스트케이스, 행, 열, 배추 개수
	static int[][] map;				// 배추 심어진 위치
	static boolean[][] visit;		// 배추밭 방문 위치
	static Queue<Point> queue;		// 방문 확인 큐
	
 	public static void main(String[] args) throws IOException {
 		
 		br = new BufferedReader(new InputStreamReader(System.in));
 		TC = Integer.parseInt(br.readLine());
 		
 		for(int tc=1;tc<=TC;tc++) {
 			st = new StringTokenizer(br.readLine()," ");
 			N = Integer.parseInt(st.nextToken());
 			M = Integer.parseInt(st.nextToken());
 			K = Integer.parseInt(st.nextToken());
 			
 			map = new int[N][M];
 			visit = new boolean[N][M];
 			queue = new LinkedList<>();
 			
 			for(int k=0;k<K;k++) {
 				st = new StringTokenizer(br.readLine()," ");
 				int i = Integer.parseInt(st.nextToken());
 				int j = Integer.parseInt(st.nextToken());
 				map[i][j] = 1;	// 배추위치 표시하기
 			} // input end
 			
 			int count = 0;	// 필요한 벌레 개수 카운트
 			
 			for(int i=0;i<N;i++) {   // 전체 배추밭 탐색 
 				for(int j=0;j<M;j++) {
 					
 					if(map[i][j]==1 && !visit[i][j]) {	// 배추가 존재하고 방문하지 않은위치라면,
 						count++;
 						queue.add(new Point(i, j));	// 큐에 추가
 						visit[i][j] = true;			// 방문 표시
 						
 						while(!queue.isEmpty()) {
 							Point p = queue.poll();
 							
 							int pi = p.i;
 							int pj = p.j;
 							
 							for(int d=0;d<4;d++) {
 								int ni = pi + di[d];
 								int nj = pj + dj[d];
 								
 								if(ni>=0 && ni<N && nj>=0 && nj<M 
 										&& map[ni][nj]==1 && !visit[ni][nj]) {
 									queue.add(new Point(ni, nj));
 									visit[ni][nj] = true;
 								}
 							}
 						}
 					}
 				} // 전체 배추밭 탐색 end
 			} // 전체 배추밭 탐색 end
 			
 			System.out.println(count);	// 정답 출력
 			
 		} // tc end
	} // main end
 	
 	
 	// 밭의 위치를 표시하는 포인트 클래스
 	static class Point{
 		int i,j;
 		Point(int i,int j){
 			this.i = i;
 			this.j = j;
 		}
 	} // Point class end
} // class end
