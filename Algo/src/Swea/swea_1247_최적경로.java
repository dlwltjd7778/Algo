package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1247_최적경로 {

	static int TC, N; // 테케 수, 고객 수
	static boolean[] isSelected; // 고객 뽑았는지 체크 배열
	static Point[] customerHouse; // 뽑은 고객 집
	static Point[] list; // 고객 리스트
	static Point office;
	static Point house;
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			list = new Point[N]; // 고객 집 리스트 배열 생성
			customerHouse = new Point[N];
			isSelected = new boolean[N]; // 뽑기 배열..

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			office = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < N; i++) {
				list[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} // input end

			perm(0);

			System.out.println("#" + tc + " " +min);
		} // tc end

	}

	static void perm(int cnt) {

		if (cnt == N) {
			func(customerHouse);
			return;
		}

		for (int i = 0; i < N; i++) {

			if (isSelected[i])
				continue;

			isSelected[i] = true;
			customerHouse[cnt] = list[i];
			perm(cnt + 1);
			isSelected[i] = false;
		}

	}

	static void func(Point[] ch) {
		int sum = 0;
		// 첫 시작은 회사
		sum += Math.abs(ch[0].i - office.i) + Math.abs(ch[0].j - office.j); // 회사에서 처음 고객까지의 거리

		for (int c = 1; c < ch.length; c++) {
			sum += Math.abs(ch[c].i - ch[c - 1].i) + Math.abs(ch[c].j - ch[c - 1].j);
		}

		// 끝은 집
		sum += Math.abs(ch[N-1].i - house.i) + Math.abs(ch[N-1].j - house.j); // 마지막 고객집에서 집까지의 거리

		if (min > sum)
			min = sum;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return i + " " + j;
		}
	}
}
