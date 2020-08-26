package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1987_알파벳 {
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int R,C;
	static int max;
	static char[][] board;
	static boolean[] visit;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = 0;	// 답으로 쓸 카운트
		
		board = new char[R][C];
		visit = new boolean[26];	// 알파벳 방문 체크
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}
		
		dfs(0,0,1);
		
		System.out.println(max);
	}
	
	static void dfs(int si, int sj, int cnt) {

		visit[board[si][sj] - 'A'] = true;
		for(int d=0;d<4;d++) {
			
			int ni = si + di[d];
			int nj = sj + dj[d];
			if(ni>=0 && nj>=0 && ni<R && nj<C) {
				if(!visit[board[ni][nj] - 'A']) {
					dfs(ni,nj,cnt+1);
				} else {
					if(max<cnt) max = cnt;
				}
			}
		}
		visit[board[si][sj] - 'A'] = false;
		
		
		
		
	}
	
	
	static class Point{
		int i,j,cnt;
		Point(int i,int j, int cnt){
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}
