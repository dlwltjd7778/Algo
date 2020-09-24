package BaekJoon;

import java.util.Scanner;

public class bj_9205_맥주 {

	static int[][] adj;
	static int end;
	static boolean[] visit;
	static boolean answer;
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=0;tc<TC;tc++) {
			
			
			int num = sc.nextInt();
			end = num+1;
			Point[] points = new Point[num+2];
			for(int i=0;i<num+2;i++) {
				points[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			
			adj = new int[num+2][num+2];	// 집이랑 락페 위치 추가
			visit = new boolean[num+2];
			for(int i=0;i<adj.length;i++) {
				for(int j=0;j<adj.length;j++) {
					if(i==j) continue;
					int distance =  Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y);
					if(distance<=1000)
						adj[i][j] = 1;
				}
			} // 가중치 저장
			
			visit[0] = true;
			answer = false;
			dfs(0);
			if(answer) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	
	private static void dfs(int start) {
		visit[start] = true;
		
		if(start==end) {
			answer = true;
			return;
		}
		
		for(int i=0;i<adj.length;i++) {
			if(adj[start][i]==1 && !visit[i]) {
				
				dfs(i);
			}
		}
	}


	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
