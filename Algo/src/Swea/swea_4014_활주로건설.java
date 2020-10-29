package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class swea_4014_활주로건설 {

	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			answer = 0; // 정답

			int[][] map = new int[N][N]; 

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			func(map, N, X);

			System.out.println(answer);
			


		} // end tc
	} // end main

	static void func(int[][] map, int N, int X) {

		for (int i = 0; i < N; i++) {
			boolean[] runway = new boolean[N];
			exit: for (int j = 0; j < N - 1; j++) {
				if (map[i][j] - map[i][j + 1] == -1) {
					for (int r = j; r > j - X + 1; j--) { // 왼쪽으로 활주로가능?
						if (r >= 0 && 
								!runway[r] && 
								map[i][j] == map[i][r]) {
							runway[r] = true;
						} else
							break exit;
					}
				} else if (map[i][j] - map[i][j + 1] == 1) {
					for (int r = j + 1; r < j + X + 2; j++) { // 오른쪽으로 활주로가능?
						if (r < N && 
								!runway[r] && 
								map[i][j+1] == map[i][r]) {
							runway[r] = true;
						} else
							break exit;
					}
				}
				if(j==N-2) answer++;
			}
		}
	}
} // end class
