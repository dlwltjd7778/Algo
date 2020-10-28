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
					chkDirection(i, j);
				}
			}
		}
		
		
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int s=0;s<size;s++) {
				
				Point p = queue.poll();
				cheese[p.i][p.j] = 0;			// 치즈가 썩어버렸다..
				chkDirection(p.i, p.j);			// 주위에 0있나 확인
			}
			cheeseCnt -= size;
			time++;
			
		}
		System.out.println(cheeseCnt + " " + time);
	}
	static boolean chkDirection(int i, int j) { // false면 주위에 하나라도 0이다, true면 전부 1이다
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni>=0 && nj>=0 && ni<H && nj<W) {
				if(cheese[ni][nj]==1 && !visit[ni][nj]) {
					queue.add(new Point(ni, nj));
					visit[ni][nj] = true;
					return false;
				}
			}
		}
		return true;
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
