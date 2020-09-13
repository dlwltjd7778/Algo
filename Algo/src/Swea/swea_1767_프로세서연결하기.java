package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767_프로세서연결하기 {
	

	static int TC,N;
	static int[][] map;
	static boolean[][] state;
	static List<Point> coreList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			state = new boolean[N][N];	// 현재 맵 상태..-
			coreList = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(!(i==0 || j==0 || i==N-1 || j==N-1)) {
							coreList.add(new Point(i, j));
						}	// 가장자리가 아닌 코어들 넣기
					}
							
				}
			} // end input
			
			coreSize = coreList.size();
			
		}
	}
	
	static int coreSize;
	
	static void dfs(int idx, int distance) {
		
		if(idx==coreSize-1) {
			return;
		}
		
		Point now = coreList.get(idx);
		
		int nowDistance = chkLine(now);
		
		if(nowDistance!=0) {
			
			
			
		}
		
	}
	
	static int chkLine(Point p) {
		
		
		int coreCnt = 0; int lineDistance = 0;	// 코어 개수, 전선 길이
		
		for(int i=p.i-1;i>=0;i--) {	// 현재 내 위치에서 위쪽 탐색
			if(map[i][p.j]==0) {
				lineDistance++;
			} else {
				return 0;
			}
		}
		
		return lineDistance;
		

		
		
		
	}
	
	static class Point{
		int i,j;
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
}
