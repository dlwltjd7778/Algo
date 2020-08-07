package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2468_안전영역 {

	// 지역 높이정보 파악 > map
	// 비가 내렸을 때 물에 잠기지 않는 안전영역 최대 몇개?
	// 비의 양 따라 일정 높이 이하는 다 잠김
	// 방문 배열 필요
	// 높이의 최소, 최대를 구해서 그 사이를 계산 > 반복문 돌리기
	// bfs로 구하기 > queue 필요
	
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N;				// 지역 크기
	static int[][] map;			// 높이를 나타내는 지도
	static boolean[][] visit;	// 방문 배열
	static int minHeight;		// 최소 높이
	static int maxHeight;		// 최대 높이
	static int safeMax;			// 안전지역 최대
	static Queue<Point> queue;	// 포인트 방문 체크하는 큐
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		minHeight = 100;
		maxHeight = 1;
		safeMax = 0;
		queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>maxHeight) maxHeight = map[i][j];	// 최대 높이 갱신
				if(map[i][j]<minHeight) minHeight = map[i][j];	// 최소 높이 갱신
			}
		} // 입력 end
		
		for(int h=minHeight-1;h<maxHeight;h++) {	// 건물 최소높이에서 최대높이까지 비의 양으로 생각
			int safeTmp = 0;	// 안전지역 개수 임시값
			visit = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(map[i][j]>h && !visit[i][j]) {	// 비의 높이보다 높고, 방문하지 않은 지점이라면
						
						queue.add(new Point(i, j));
						visit[i][j] = true;
						safeTmp++;
						
						while(!queue.isEmpty()) {
							Point nowP = queue.poll();
							
							int nowi = nowP.i;
							int nowj = nowP.j;
							
								
								for(int d=0;d<4;d++) {
									int ni = nowi + di[d];
									int nj = nowj + dj[d];
									
									if(ni<0 || nj<0 || ni>N-1 || nj>N-1) continue;
									
									if(map[ni][nj]>h && !visit[ni][nj]) {
										visit[ni][nj] = true;
										queue.add(new Point(ni, nj));
									}
								}
							
						} // queue while end
						if(safeTmp>safeMax) safeMax = safeTmp;
					}
					
					
				} // 비의 양 for end
				
			} // 전체 탐색 end
		} // 전체 탐색 end
		
		System.out.println(safeMax);
	} // main end
	
	static class Point{
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	
}
