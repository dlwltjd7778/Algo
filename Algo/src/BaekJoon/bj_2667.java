package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2667 {

	static int N;					// 단지의 크기
	static int map[][];				// 단지 지도
	static boolean visit[][];		// 방문 확인
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,1,-1};
	static ArrayList<Integer> count;
	static int danji;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		// 배열 입력 받기
		for(int i=0;i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		// 전체 배열 순회
		danji = 0; // 단지 개수
		count = new ArrayList<Integer>(); 
			// 집의 개수 담을 리스트, 인덱스  = 단지 번호-1
			// 단지가 몇개 생길지 몰라서 arraylist로 선언..
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] == 1) { // 집이 있는 위치이고
					if (!visit[i][j]) { // 방문하지 않았다면
						danji++; // 새로운 단지가 생겼으니까 단지 늘려줌

						queue.add(new Point(i, j)); // 큐에 하나 추가
						visit[i][j] = true; // 자기자신 방문처리
						count.add(1); // 새로운 단지의 집 개수 추가

						while (!queue.isEmpty()) {

							int size = queue.size();
							for (int s = 0; s < size; s++) {

								Point nowP = queue.poll();

								int nowi = nowP.i;
								int nowj = nowP.j;
								for (int d = 0; d < 4; d++) {
									int ni = nowi + di[d];
									int nj = nowj + dj[d];

									if (ni < 0 || nj < 0 || ni > N - 1 || nj > N - 1)
										continue;

									if (map[ni][nj] == 1 && !visit[ni][nj]) {

										count.set(danji - 1, count.get(danji - 1) + 1);
										queue.add(new Point(ni, nj));
										visit[ni][nj] = true;
									}
								}

							}

						}

					}
				}
			} // 배열 순회 j 끝
		} // 배열 순회 i 끝

		Collections.sort(count);
		System.out.println(danji);
		for (int i = 0; i < count.size(); i++) {
			System.out.println(count.get(i));
		}

	}
	
	static class Point{
		int i,j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
