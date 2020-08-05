package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2667 {

	static int N;				// 단지의 크기
	static int map[][];			// 단지 지도
	static boolean visit[][];		// 방문 확인
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		// 배열 입력 받기
		for(int i=0;i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		// 전체 배열 순회
		int danji = 0;					// 단지 개수
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
			if(map[i][j]==1) {			// 집이 있는 위치이고 방문하지 않았다면
				if(!visit[i][j]) {
					danji++;
					int count = 1;						// 집의 개수 초기화
					queue.add(new Point(i, j, count));	// 큐에 하나 추가
					
					while(!queue.isEmpty()){
						
						int nowi = i;
						int nowj = j;
						
						for(int d=0;d<4;d++) {
							int ni = nowi + di[d];
							int nj = nowj + dj[d];
							
							if(ni<0 || nj<0 || ni>N-1 || nj>N-1) continue;
							
							if(map[ni][nj]==1 && !visit[ni][nj]) {
								queue.add(new Point(ni, nj, count+1));
								visit[ni][nj] = true;
							}
						}
						
					}
					
					
					
				}
			}
			} // 배열 순회 끝
			
			System.out.println(danji );
		}
		
		
		
		
	}
	
	static class Point{
		int i,j;
		int count;	// 집개수
		public Point(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
}
