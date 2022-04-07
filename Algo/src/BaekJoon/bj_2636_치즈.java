package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2636_치즈 {

	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int[][] cheese;
	static int H,W;
	static Queue<Point> queue;
	static boolean[][] visit;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		H =  sc.nextInt();
		W = sc.nextInt();
		
		queue = new LinkedList<>();
		
		int time = 1;
		int cheeseCnt = 0;
		
		cheese = new int[H][W];
		visit = new boolean[H][W];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				cheese[i][j] = sc.nextInt();
				if(cheese[i][j]==1) {
					cheeseCnt++;
				} 
			}
		}
		
		while(!queue.isEmpty()) {
			
			
			
			
			
		}
		
	}
	
	static int chkMelt() {
		int melt = 0;		// 녹을 치즈 개수
		
		while(!queue.isEmpty()) {
			
			Point p = queue.poll();
			
			for(int d=0;d<4;d++) {
				int ni = p.i + di[d];
				int nj = p.j + dj[d];
				
				if(ni>=0 && nj>=0 && ni<H && nj<W ) {
					
				}
			}
			
			
			
		}
		
		return melt;
	}
	
	
	static class Point {
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "("+i + ", " + j+")";
		}
	}
}
