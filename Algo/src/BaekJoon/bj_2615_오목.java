package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_2615_오목 {

	static int[] di = { 0, 1, 1, 1 }; // 오른쪽, 왼쪽아래, 아래, 오른쪽아래
	static int[] dj = { 1, -1, 0, 1 };
	
	static int[] bi = {0,-1,-1,-1};	// 현재 탐색하는 방향의 반대방향
	static int[] bj = {-1,1,0,-1};

	static int[][] map; // 오목 맵
	static int count; // 오목 연달아서 세는 변수
	static ArrayList<Point> list; 	// 오목 정답 리스트

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[19][19];

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		if(game()) {
			Collections.sort(list);
			Point ans = list.get(0);
			System.out.println(map[ans.i][ans.j]);
			System.out.println((ans.i+1) + " " + (ans.j+1));
		} else
			System.out.println(0);
	}
	
	static boolean game() {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {

				if (map[i][j] == 1 || map[i][j] == 2) {

					int color = map[i][j];
					
					for (int d = 0; d < 4; d++) {
						count = 0;
						list = new ArrayList<>();
						list.add(new Point(i, j));
						int bx = i + bi[d];
						int by = j + bj[d];
						
						if(bx >= 0 && by >= 0 && bx < 19 && by < 19 && map[bx][by] == color)
							continue;	// 만약에 지금보는방향 반대방향이면 안됨
						
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni >= 0 && nj >= 0 && ni < 19 && nj < 19 && map[ni][nj] == color) {
							count++;
							list.add(new Point(ni, nj));
							boolean chk = dfs(ni, nj, d, color);
							if(chk) return true;
						}
					}
				}
			} // 전체 탐색
		} // 전체 탐색
		return false;	// 전체 다돌았는데 위에서 안걸리면 실패한것
	}

	static boolean dfs(int i, int j, int d, int color) {
		int ni = i+di[d];
		int nj = j+dj[d];
		
		if (ni >= 0 && nj >= 0 && ni < 19 && nj < 19 && map[ni][nj] == color) {
			count++;
			list.add(new Point(ni, nj));
			
			dfs(ni, nj, d, color);
		} 
		
		if(count==4) return true;
		else return false;
	}
	

	static class Point implements Comparable<Point> {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			if (this.j== o.j) {
				return this.i - o.i;
			}
			return this.j - o.j;
		}
	}

}
