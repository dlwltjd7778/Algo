package BaekJoon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_3190_뱀 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};	// 우 하 좌 상 
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		Queue<Point> snake = new LinkedList<>();
		
		int appleCnt = sc.nextInt();
		
		for(int i=0;i<appleCnt;i++) {
			int ai = sc.nextInt()-1;
			int aj = sc.nextInt()-1;
			map[ai][aj] = 1;
		}
		
		int dirCnt = sc.nextInt();
		Queue<DirectionInfo> queue = new LinkedList<>();
		for(int i=0;i<dirCnt;i++) {
			int time = sc.nextInt();
			char direction = sc.next().charAt(0);
			queue.add(new DirectionInfo(time, direction));
		} // end input
		
		
		int si = 0;	// 뱀 i좌표
		int sj = 0;	// 뱀 j좌표
		int sd = 0;	// 뱀 방향
		boolean isGo = true;
		
		int time = 0;
		snake.add(new Point(0, 0));
		
		while(true) {
			
			int ni = si + di[sd];
			int nj = sj + dj[sd];
			
			if(ni<0 || nj<0 || ni>N-1 || nj>N-1) break;	// 범위넘으면 게임종료
			
			Iterator<Point> iterator = snake.iterator();
			while(iterator.hasNext()) {
				Point np = iterator.next();
				if(np.i==ni && np.j==nj) {
					isGo = false;
					break;
				}
			}

			if(!isGo) break; // 자기 몸에 머리닿으면 종료
			
			snake.add(new Point(ni, nj));
			si = ni;
			sj = nj;
			if(map[ni][nj]==0) {
				snake.poll();
			} else {
				map[ni][nj] = 0;
			}
			
			
			time++;
			if(!queue.isEmpty() && queue.peek().time==time) {
				DirectionInfo info = queue.poll();
				if(info.direction == 'L') {
					if(sd==0) sd=3;
					else sd--;
				} else {
					if(sd==3) sd=0;
					else sd++;
				}
			}
			
			
		}
		System.out.println(time+1);
		
	}
	static class Point{
		int i,j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "("+i+","+j+")";
		}
	}
	
	static class DirectionInfo{
		int time;
		char direction;
		public DirectionInfo(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
		@Override
		public String toString() {
			return "t:"+time + ",d:" + direction;
		}
	}
}
