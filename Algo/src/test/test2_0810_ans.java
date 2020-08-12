package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs 풀면 시간초과 날 확률이 매~~~우 큰 문제!!!
// bfs 로 푸는 것이 좋을듯..


public class test2_0810_ans {

	static int[] di = { -1,1,0,0};	// 좌, 우, 상, 하 로 이동할 수 있는 델타
	static int[] dj = { 0,0,-1,1};
	
	static BufferedReader br;		// 입력 관련.
	static StringTokenizer st;
	static int N,M;				// 행, 열
	static int[][] map; 		// 미로
	static int[][] wallCnt;		// visit 관리까지 되는 배열
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];	// 미로 배열 선언
		wallCnt = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		} // 입력 end
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				wallCnt[i][j] = Integer.MAX_VALUE;	// 가장 큰 값으로 채워놓기
			}
		}
		
		bfs();
		System.out.println(wallCnt[N-1][M-1]);
		
	} // main end

	// bfs 
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));	// 0,0부터 시작, 
		
		wallCnt[0][0] = map[0][0];
		
		// 탐색 시작
		while(!queue.isEmpty()) {
			Point now = queue.poll();	// 순서대로 꺼내기
			
			for(int d=0;d<4;d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				if(ni>=0 && ni<N && nj>=0 && nj<M 	// 배열 범위 안넘고,
					&& (wallCnt[ni][nj] > wallCnt[now.i][now.j] + map[ni][nj])) {	
					queue.add(new Point(ni,nj));
					wallCnt[ni][nj] = wallCnt[now.i][now.j] + map[ni][nj];
				}
			}
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
