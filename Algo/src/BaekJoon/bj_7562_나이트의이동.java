package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7562_나이트의이동 {

	
	static int TC, I;	// 테스트 케이스 수, 체스판 크기
	static Queue<Point> queue;
	
	static int[] di = {-2,-1,1,2,-2,2,-1,1};
	static int[] dj = {1,2,2,1,-1,-1,-2,-2};
	static int si,sj,ei,ej;	//  시작좌표, 끝좌표
	static int count;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			
			I = sc.nextInt();
			si = sc.nextInt();
			sj = sc.nextInt();
			ei = sc.nextInt();
			ej = sc.nextInt();
			count = 0;
			
			////////input end
			
			queue = new LinkedList<Point>();
			queue.add(new Point(si, sj,count));
			func();

			
			
		}
		
	}
	static void func() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				Point p = queue.poll();
				
				int pi = p.i;
				int pj = p.j;
				for(int d=0;d<8;d++) {
					int ni = pi + di[d];
					int nj = pj + dj[d];
					
					if(ni>=0 && nj>=0 && ni<I && nj<I) {
						if(ni==ei && nj==ej) {
							System.out.println(p.count+1);
							return;
						}
						queue.add(new Point(ni, nj,p.count+1));
					}
				}
				
			}
			
		}
		System.out.println(0);
	}
	static class Point {
		int i,j,count;
		Point(int i,int j, int count){
			this.i = i;
			this.j = j;
			this.count = count;
		}
		
	}
}
