package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_4963 {
	
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};

	static int w,h;					// 너비, 높이
	static int[][] map;				// 지도
	static boolean[][] visit;		// 방문여부
	static int landCnt;				// 섬 개수
	static Queue<Point> queue;		// 방문체크 큐
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			// 입력부분
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;	// 높이와 너비 모두 0이면 입력 그만받기
			
			map = new int[h][w];
			visit = new boolean[h][w];
			landCnt = 0;
			queue = new LinkedList<>();
			
				
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			/////////////////////////////////////////////////////////
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {		// 하나씩 다 돌면서
					
					if(map[i][j]==1 && !visit[i][j]) {	// map[i][j] 가 땅이고 아직 방문 전이라면
						
						queue.add(new Point(i, j)); // 큐에 추가
						visit[i][j] = true;			// 방문처리
						landCnt++;
						
						while(!queue.isEmpty()) {
							Point nowP = queue.poll();
							int nowi = nowP.i;
							int nowj = nowP.j;
							
							for(int d=0;d<8;d++) {
								int ni = nowi + di[d];
								int nj = nowj + dj[d];
								
								if(ni<0 || nj<0 || ni>h-1 || nj>w-1) continue;
								if(map[ni][nj]==1 && !visit[ni][nj]) {
									queue.add(new Point(ni, nj));   // 큐에 추가
									visit[ni][nj] = true;			// 방문처리
								}
							}
						}
						
						
					}
					
					
				}
			}
			// 섬 개수 출력
			System.out.println(landCnt);
			
		}
		
	}

	static class Point{
		int i,j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
}
