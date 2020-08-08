package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class swea_7733_치즈도둑 {

	static BufferedReader br;
	static StringTokenizer st;
	
	static int TC;					// 테케 개수
	static int N;					// 치즈 개수
	static int[][] cheese;			// 치즈 배열
	static boolean[][] visit;		// 치즈 방문 처리
	static int max;					// 치즈 덩어리 개수 최대값
	static Queue<Point> queue;		// 큐
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			max = 1;
			queue = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int day=1;day<=100;day++) {	// 100일 동안 반복
				visit = new boolean[N][N];	// 방문 배열 초기화
				int tempMax = 0;			// 일별 임시 치즈 덩어리 개수 맥스값 초기화
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(cheese[i][j]>day && !visit[i][j]) {	// 치즈맛이 날짜보다 크고, 방문하지 않았다면
							queue.add(new Point(i, j));			// 큐에 추가
							visit[i][j] = true;					// 방문배열에 true로 바꿔줌
							tempMax++;							// 치즈 덩어리 개수 추가

							while(!queue.isEmpty()) {		
								Point p = queue.poll();			// 큐에 들어있는거 하나뽑기
								
								int nowi = p.i;
								int nowj = p.j;
								
								for(int d=0;d<4;d++) {
									int ni = nowi+di[d];
									int nj = nowj+dj[d];
									
//									if(ni>=0 && nj>=0 && ni<N && nj<N 
//											&& cheese[ni][nj]>day && !visit[ni][nj]) {
//										queue.add(new Point(ni, nj));
//										visit[ni][nj] = true;
//									}
//									
									if (ni < 0 || nj < 0 || ni > N - 1 || nj > N - 1)
										continue;

									if (cheese[ni][nj] > day && !visit[ni][nj]) {
										visit[ni][nj] = true;
										queue.add(new Point(ni, nj));
									}
								}
								
								
							}
						}
						
					}
				}
				if(tempMax>max) max = tempMax;
				
				
				
			} // day for end
			
			System.out.println("#"+tc+" "+max);
		} // tc end
		
	} // main end
	
	static void bfs(int i, int j) {
		
	}
	
	static class Point{
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
