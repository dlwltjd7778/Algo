package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2589_보물섬 {

	static int N, M;				   // map의 행, 열 크기
	static int[] di = { 1, -1, 0, 0 }; // 사방 탐색을 위한 i,j좌표
	static int[] dj = { 0, 0, 1, -1 };
	static char[][] map;			   // map 정보를 저장할 2차원 배열
	static boolean[][] visit;		   // map의 좌표를 방문했는지 확인할 visit 배열

	public static int execute() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;	// 최단거리 시간을 구할 정답 변수

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // end input

		// Logic
		// > 좌표값이 L인 모든 지점에서부터 최단 거리로 가면서 가장 오래 걸리는 시간을 계산하고, 그중에서 가장 큰 값을 답으로 return 한다
		
		for (int i = 0; i < N; i++) {			// 좌표값이 L인 모든 지점 탐색
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') { 		// 만약 현재 지도 위치가 땅(L)이라면 탐색한다.
					visit = new boolean[N][M];  // 방문했는지 체크할 visit배열 선언
					answer = Math.max(answer, bfs(i, j));	// bfs 메소드의 return값과, 현재 answer 값 비교해서 더 오래 걸리는 시간을 return
					//System.out.println(i + " , " + j + ", max : " + answer);
				}
			}
		}

		return answer; // 리턴값을 수정하세요
	} // end of execute

	static int bfs(int i, int j) {	// 특정 좌표로부터 가장 멀리 있는 칸 수를 계산해준다( 최단 거리로 계산 )
		
		int count = -1; // 최대 몇칸 가는지 return해준다. 자기 자신은 빼주기 위해 초기값은 -1

		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(i, j));	// 처음 시작좌표를 큐에 넣고 visit처리 해준다
		visit[i][j] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();	// 큐의 크기만큼 돌면서 안의 값을 poll해준다.

			for (int s = 0; s < size; s++) {
				Point p = queue.poll();

				for (int d = 0; d < 4; d++) { // 사방탐색을 진행한다
					int ni = p.i + di[d];
					int nj = p.j + dj[d];

					if (chkIdx(ni, nj) && map[ni][nj] == 'L' && !visit[ni][nj]) {
						// 사방탐색 후 좌표인 ni,nj 가 배열 안의 인덱스이고, 땅이며, 방문기록이 없을 경우,
						queue.add(new Point(ni, nj));	// 큐에 넣어주고 visit 처리
						visit[ni][nj] = true;
					}
				}

			} // end queueSize
			count++;	// 큐의 크기만큼 돌고 나면, 현재 내 좌표로부터 1시간 거리의 구간은 다 체크해본 것이다.. 
		}

		return count;
	}

	static boolean chkIdx(int i, int j) { // map 배열의 idx 유효성을 확인하는 chkIdx 메소드
		if (i < 0 || j < 0 || i > N - 1 || j > M - 1)
			return false;
		return true;
	}

	static class Point { // 좌표 정보를 저장하는 Point class
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}
} // end of class

