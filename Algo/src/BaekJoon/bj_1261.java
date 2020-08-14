package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1261 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,1,-1};
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N,M;				// 행, 열
	static int[][] map;			// 미로 상태 받는 배열
	static int[][] min;			// 최솟값 저장할 배열
	static Queue<Point> queue;	// 큐
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = new int[N][M];
		for(int i=0;i<N;i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		
		queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		} // input end
		
		queue.add(new Point(0, 0));
		min[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int pi = p.i;
			int pj = p.j;
			
			for(int d=0;d<4;d++) {
				
				int ni = pi + di[d];
				int nj = pj + dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<M) {	// 배열 범위 & 방문상태 체크
					
					if(min[pi][pj] + map[ni][nj] < min[ni][nj]) {
						min[ni][nj] = min[pi][pj] + map[ni][nj];
						queue.add(new Point(ni, nj));
					}
				}
			}
			
			
		} // 큐 while end
		
		System.out.println(min[N-1][M-1]);
		
		
		
		
	}
	
	static class Point{
		int i,j;
		public Point(int i,int j) {
			this.i = i;
			this.j = j;
		}
	}
}
