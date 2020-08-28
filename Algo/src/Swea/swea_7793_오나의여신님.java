package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7793_오나의여신님 {

	static int TC,N,M;
	static char[][] map;
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	static Queue<Point> devilQ;
	static Queue<Point> suyeonQ;
	
	static Point D;	// 여신 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			devilQ = new LinkedList<>();
			suyeonQ = new LinkedList<>();
			
			map = new char[N][M];
			
			for(int i=0;i<N;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<M;j++) {
					if(map[i][j]=='S') suyeonQ.add(new Point(i, j));
					if(map[i][j]=='D') D = new Point(i, j);
					if(map[i][j]=='*') devilQ.add(new Point(i, j));
				}
			} // input end
			
			
			System.out.println("#" + tc + " ");
			if(bfs()) {
				System.out.println(time);
			} else
				System.out.println("GAME OVER");
		} // tc end
		
		
	}
	static int time;
	static boolean bfs() {
		
		time=0;
		
		while(!suyeonQ.isEmpty()) {
			
			int dsize = devilQ.size();
			
			for(int ds=0;ds<dsize;ds++) {
				Point p = devilQ.poll();
				
				for(int d=0;d<4;d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M  
							&&( map[ni][nj]=='.' || map[ni][nj]=='S')) {
						devilQ.add(new Point(ni, nj));
						map[ni][nj] = '*';
					}
				}
			} // size 가 다 돌면 1초 지난것
		
			int ssize = suyeonQ.size();
			
			for(int ss=0;ss<ssize;ss++) {
				Point p = suyeonQ.poll();
				
				if(p.i==D.i && p.j==D.j) return true;
				
				for(int d=0;d<4;d++) {
					int ni = p.i + di[d];
					int nj = p.j + dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M  
							&& map[ni][nj]=='.') {
						suyeonQ.add(new Point(ni, nj));
						map[ni][nj] = 'S';
					}
				}
			}
			
			time++;
			
		}
		return false;
	}

	
	
	static class Point{
		int i,j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
