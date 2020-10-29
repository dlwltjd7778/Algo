package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea_1249_보급로 {

	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] chk = new int[N][N];
			
			Queue<Point> queue = new LinkedList<>();
			
			for(int i=0;i<N;i++) {
				String tmp = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = tmp.charAt(j) - '0';
					chk[i][j] = Integer.MAX_VALUE;
				}
			}	// end input
			
			
			queue.add(new Point(0, 0));
			chk[0][0] = 0;
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				int pi = p.i;
				int pj = p.j;
				for(int d=0;d<4;d++) {
					int ni = pi + di[d];
					int nj = pj + dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<N 
						&& chk[ni][nj] > map[ni][nj] + chk[pi][pj]) {
						chk[ni][nj] = map[ni][nj] + chk[pi][pj];
						queue.add(new Point(ni, nj));
					}
				}
			}
			
			System.out.println("#"+ tc + " " + chk[N-1][N-1]);
			
			
			
		} // end tc
		
	} // end main
	
	static class Point{
		int i,j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
