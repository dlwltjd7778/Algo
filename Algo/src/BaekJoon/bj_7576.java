package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7576 {

	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int[][] tomato;
	static boolean[][] visit;
	static int day;
	static Queue<Point> q = new LinkedList<>();
	static ArrayList<Point> ansPointList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		day = 0;

		int maxDay =0;
		
		tomato = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tomato[i][j] = sc.nextInt();
				if(tomato[i][j]==1) {
					q.add(new Point(i, j, day));		// 이미 익은 토마토를 큐에 저장
					ansPointList.add(new Point(i, j, day));		// 이미 익은 토마토를 정답 후보에 저장
				}
				
			}
		}
		
		boolean allGrown = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					allGrown = false;
				}
				
			}
		}
		
		if(allGrown) {
			System.out.println(maxDay); 
			return;
		}
		
		
		while(!q.isEmpty()) {
			
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
					q.add(new Point(ni, nj, now.day + 1));
					ansPointList.add(new Point(ni, nj, now.day + 1));
				}
				
			}	// 상,하,좌,우 탐색
			
		} // while end
		
		boolean chk = true;			// 안익은 토마토가 있는지 확인
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					chk = false;
					maxDay = -1;
					break;
				}
				
			}
			if(!chk) break;
		}
		
		if(chk) {
			for(int i=0;i<ansPointList.size();i++) {
				int nowDay = ansPointList.get(i).day;
				if(nowDay>maxDay) maxDay = nowDay;
			}
		} 
		
		System.out.println(maxDay);
		
		
	} // main end
	
	static class Point{
		int i,j;
		int day;	// i,j 좌표가 한 정점이 됨!
		Point(int i,int j,int d){
			this.i = i;
			this.j = j;
			this.day = d;
		}
	}
}
