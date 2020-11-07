package Swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class swea_파핑파핑지뢰찾기 {

	static int N;
	static char[][] map;
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	static int[][] mineCntMap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			
			for(int i=0;i<N;i++) {
				map[i] = sc.next().toCharArray();
			}
			
			List<Point> zeroList = new ArrayList<>();
			
			mineCntMap = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='.') {
						mineCntMap[i][j] = findMine(i, j);
						if(mineCntMap[i][j]==0) zeroList.add(new Point(i, j));
					}
				}
			}
			
			// 0 먼저 클릭
			int click = 0;
			for(int i=0;i<zeroList.size();i++) {
				Point p = zeroList.get(i);
				if(map[p.i][p.j]=='.') {
					bfs(p.i,p.j,0);
					click++;
				}
			}
			
			// 0아닌거 클릭
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='.') {	// 클릭 가능
						click++;
						int mineCnt = mineCntMap[i][j];
						map[i][j]=(char)(mineCnt+'0');
					}
				}
			}
			System.out.println("#"+tc+" "+click);
			
			
		} // end tc
	} // end main
	
	// 주위 지뢰 개수가 0인경우 bfs
	static void bfs(int i, int j, int cnt) {
		
		map[i][j] = (char)(cnt+'0');
		Queue<Point> queue = new LinkedList<>();
		
		if(map[i][j]=='0') {
			queue.add(new Point(i, j));
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				
				for(int d=0;d<8;d++) {
					int ni = p.i+di[d];
					int nj = p.j+dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]=='.') {
						int mineCnt = mineCntMap[ni][nj];
						if(mineCnt==0) queue.add(new Point(ni, nj));
						map[ni][nj] = (char)(mineCnt+'0');
					}
				}
			}
		}
	}

	// 8방에 지뢰 몇개 있는지 개수 return
	static int findMine(int i, int j) {
		int cnt = 0;
		for(int d=0;d<8;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]=='*') {
				cnt++;
			}
		} 
		return cnt;
	}
	static class Point{
		int i,j;
		Point(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
} // end class
 