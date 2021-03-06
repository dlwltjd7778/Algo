package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2206_벽부시고이동 {

	// Q에다가 0,0 을 넣고, 꺼내면서 사방탐색
	// 만약 탐색한 ni,nj 가 0이면 칸 개수를 더해준다..
	// 만약 탐색한 ni,nj 가 1이면 이전에 부수지 않았다면 일단 부수고 부셨다고 체크해준다..
	// 이때 위의 모든 경우에서 이미 칸에 저장된 값보다 지금 개수 값이 크면 큐에 추가 ,리셋 안한다
	
	static BufferedReader br;
	static StringTokenizer st;
	static int N,M;
	static int[][] map;
	static int[][] min;
	static boolean[][] visit;
	static Queue<Point> queue;
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		min = new int[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			Arrays.fill(min[i], Integer.MAX_VALUE);
			for(int j=0;j<M;j++) {
				map[i][j] = tmp.charAt(j) -'0';
			}
		} // end input
		
		bfs(0,0);
		
		System.out.println(min[N-1][M-1]==Integer.MAX_VALUE?-1:min[N-1][M-1]);
		
	}
	
	static void bfs(int i, int j) {
		
		queue.add(new Point(i, j, false, 1));
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			
			Point p = queue.poll();
			
			for(int d=0;d<4;d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<M && !visit[ni][nj]) {
					
					if(map[ni][nj]==0) {	// 움직이려는 칸이 0일때
						if(min[ni][nj]>p.cnt+1) {	// 그 칸이 최소라면
							queue.add(new Point(ni, nj, p.isDestroy, p.cnt + 1));
							min[ni][nj] = p.cnt+1;	// min 값 갱신
						}
					} else {	// 움직이려는 칸이 1일때(벽일때)
						
						if(!p.isDestroy && min[ni][nj]>p.cnt+1) {	
							// 현재까지 왔을 때 벽을 안부셨고, 그 칸이 최소인경우..
							queue.add(new Point(ni, nj, true, p.cnt+1));	// 벽은 부순 처리해줌
							min[ni][nj] = p.cnt+1;
						}
					}
				}
			}
			
		}
		
		
		
	}
	
	static class Point {
		int i,j;
		boolean isDestroy;	//	벽을 이미 부순 상태면 true, 아니면 false
		int cnt;			// 현재까지 칸 개수 카운트
		Point(int i, int j, boolean isDestroy, int cnt){
			this.i = i;
			this.j = j;
			this.isDestroy = isDestroy;
			this.cnt = cnt;
		}
	}
	
}
