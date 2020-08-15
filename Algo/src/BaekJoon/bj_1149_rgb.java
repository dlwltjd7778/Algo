package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1149_rgb {

	static BufferedReader br;
	static StringTokenizer st;
	
	static int N;					// 집의 수
	static int[][] rgb;				// rgb 저장
	static Queue<Info> queue;		// 정보 저장 큐
	static int min;					// 색칠 합의 최솟값
	//static int hi,ci,sum;
	static Info now;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		rgb = new int[N][3];	// rgb 저장하기
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}	// input end
		
		// bfs();
		Info info = new Info(0, 0, rgb[0][0]);
		Info info1 = new Info(0, 0, rgb[0][1]);
		Info info2 = new Info(0, 0, rgb[0][2]);
		dfs(info);
		dfs(info1);
		dfs(info2);
		
		
		System.out.println(min);
		
		
	} // main end
	
	
	static void dfs(Info info) {
		

		int hi = info.houseIdx;
		int ci = info.colorIdx;
		int sum = info.sum;

		if(hi+1==N && min > now.sum) {
			min = now.sum;
			return;
		}
		
		for(int c=0;c<3;c++) {
			if(ci != c && hi+1<N) {
				now= new Info(hi+1, c, sum + rgb[hi+1][c]);
				dfs(now);
			}
		}
	}
	
//	static void bfs() {
//		queue = new LinkedList<Info>();
//		queue.add(new Info(0, 0, rgb[0][0]));
//		queue.add(new Info(0, 1, rgb[0][1]));
//		queue.add(new Info(0, 2, rgb[0][2]));
//		
//		while(!queue.isEmpty()) {
//			
//				Info now = queue.poll();
//				
//				int nowH = now.houseIdx;
//				int nowC = now.colorIdx;
//				int sum = now.sum;
//				
//				for(int color=0;color<3;color++) {
//					if(nowC!=color) {
//						if(nowH+1<N) {
//							queue.add(new Info(nowH+1, color, sum+rgb[nowH+1][color]));
//							if(nowH+1 == N-1 && min > sum+rgb[nowH+1][color]) {
//								min = sum + rgb[nowH+1][color];
//							}
//						}
//					}
//				}
//			
//		}
//	}
	static class Info {
		int houseIdx, colorIdx, sum;
		Info(int houseIdx, int colorIdx, int sum){
			this.houseIdx = houseIdx;
			this.colorIdx = colorIdx;
			this.sum = sum;
		}
	}
}