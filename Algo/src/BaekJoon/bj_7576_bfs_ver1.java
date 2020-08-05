package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_7576_bfs_ver1 {

	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int[][] tomato;
	static boolean[][] visit;
	static int day;
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		day = 0;

		int maxDay =-1;
		
		tomato = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) {
					q.add(new Point(i, j));				// 이미 익은 토마토를 큐에 저장
				}
				
			}
		}
		
		// 안익은 토마토가 없을 경우 0 을 출력하고 return
		boolean allGrown = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					allGrown = false;
				}
			}
		}
		if(allGrown) {					
			maxDay = 0;
			System.out.println(maxDay); 
			return;
		}
		
		// bfs 시작
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			
			for(int s=0;s<size;s++) {
				
				Point now = q.poll();
				int nowi=now.i, nowj=now.j;
				
				for(int d=0;d<4;d++) {
					int ni = nowi + di[d];
					int nj = nowj + dj[d];
					
					if (ni < 0 || nj < 0 || ni > N-1 || nj > M-1) continue; // 배열 범위 체크
					
					if (tomato[nowi][nowj] == 1 
							&& tomato[ni][nj] == 0 
							&& !visit[ni][nj]) {
						tomato[ni][nj] = 1;
						visit[ni][nj] = true; // 방문 표시
						q.add(new Point(ni, nj));
					}
				}	// 상,하,좌,우 탐색 끝
				
			} // size 순회 끝
			maxDay++;
			
		} // bfs end
		
		
		// 안익은 토마토가 있는지 확인, 있으면 -1 return
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					maxDay = -1;
					System.out.println(maxDay);
					return;
				}
			}
		}
		
		// 위의 경우가 전부 아닐때
		System.out.println(maxDay);
		
		
	} // main end
	
	static class Point{
		int i,j;	// i,j 좌표가 한 정점이 됨!
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
}
