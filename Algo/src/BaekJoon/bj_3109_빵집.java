package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3109_빵집 {

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int count;

	static int[] di = { -1, 0, 1 }; // 오른쪽위, 오른쪽, 오른쪽아래

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		} // input end

		count = 0; // 답 카운트

		for (int i = 0; i < R; i++) { // i행 0열부터 탐색..

			int si = i;
			int sj = 0;
			isGo = true;
			dfs(si, sj);

		}
		System.out.println(count);

	}

	static boolean isGo = true;	// 계속 진행 하는가

	static void dfs(int si, int sj) {

		if (sj == C - 1) { // 끝에 도착했을 때 답이다
			count++;
			isGo = false;
			return;
		}

		for (int d = 0; d < 3; d++) {
			if (!isGo)
				return; // 답을 찍고 재귀함수 리턴할 때 다음 for 타면 안됨
			int ni = si + di[d];
			int nj = sj + 1;

			if (ni >= 0 && nj >= 0 && ni < R && nj < C && !visit[ni][nj] && map[ni][nj] == '.') { // 배열 범위 안 & 방문 x

//				if (d == 0 && sj + 1 < C) { // 오른쪽 위로 가려는 경우
//					if (visit[si - 1][sj] && visit[si][sj + 1])
//						continue; // 내 윗칸과 오른쪽 칸이 사용한 칸이면 오른쪽 위로 올라갈 수 없다..
//				}

				visit[ni][nj] = true;
				dfs(ni, nj);
			}
		}

	}
}
