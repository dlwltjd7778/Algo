package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178_미로탐색 {

	// 입력 : N개의 줄에 M개의 정수 > N: 행, M: 열
	static int N, M;
	static BufferedReader br;
	static StringTokenizer st;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };
	static int[][] map; // 미로
	static boolean[][] visit; // 방문 확인
	static Queue<Point> queue; // 방문 큐
	static int[][] min;			// 최솟값 찾는 배열

	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		min = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			Arrays.fill(min[i], Integer.MAX_VALUE); // 최댓값으로 채우기
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		} // input end

		queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visit[0][0] = true;
		min[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int pi = p.i;
			int pj = p.j;
			
			if(map[pi][pj]==1) {
				for(int d=0;d<4;d++) {
					int ni = pi+di[d];
					int nj = pj+dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M 
							&& map[ni][nj]==1 && !visit[ni][nj]
							&& min[ni][nj] > min[pi][pj]+1) {
						queue.add(new Point(ni, nj));
						visit[ni][nj]=true;
						min[ni][nj] = min[pi][pj]+1;
						
					}
				}
				
			}
			
		}
		System.out.println(min[N-1][M-1]);
		
	} // main end

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
} // class end
