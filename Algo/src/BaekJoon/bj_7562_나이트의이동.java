package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7562_나이트의이동 {

	static int[] di = {-2,-1,1,2,-2,2,-1,1};
	static int[] dj = {1,2,2,1,-1,-1,-2,-2};
	
	static int TC, I;	// 테스트 케이스 수, 체스판 크기
	static Queue<Point> queue;	
	static boolean[][] visit;		// 방문 체크할 배열
	static int si,sj,ei,ej;			//  시작좌표, 끝좌표
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			
			I = sc.nextInt();
			si = sc.nextInt();		// 시작 i ( start i )
			sj = sc.nextInt();		// 시작 j ( start j )
			ei = sc.nextInt();		// 끝 i ( end i )
			ej = sc.nextInt();		// 끝 j ( end j )
			// input end
			
			visit = new boolean[I][I];
			queue = new LinkedList<Point>();
			queue.add(new Point(si, sj));

			boolean goBfs = true;	// bfs함수 진행할것인가..
			if(si==ei && sj==ej) {
				System.out.println(0);
				goBfs = false;
			}
			
			
			if(goBfs) bfs();
			
		}	// tc end
	} // main end
	static void bfs() {
		int cnt = 0;
		boolean chk = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				Point p = queue.poll();
				
				int pi = p.i;
				int pj = p.j;
				
				for(int d=0;d<8;d++) {
					int ni = pi + di[d];
					int nj = pj + dj[d];
					
					if(ni>=0 && nj>=0 && ni<I && nj<I && !visit[ni][nj]) {	// 범위 체크
						if(ni==ei && nj==ej) {		  // 움직인 곳이 원하는 좌표면
							System.out.println(cnt+1);
							return;
						}
						queue.add(new Point(ni, nj)); // 아니면 q에넣기
						visit[ni][nj] = true;		  // 방문처리 하기
					}
				}
				
			}
			cnt++;
			
		}
		System.out.println(cnt);
	}
	static class Point {
		int i,j;
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
		
	}
}
