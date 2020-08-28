package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_4012_요리사 {

	static int N; // 식재료
	static int[][] synergy; // 요리 시너지 정보
	static boolean[] select; // 식재료 뽑기

	static List<Integer> A; // 뽑힌 재료 번호를 각각 추가하기 위한 리스트
	static List<Integer> B;
	static boolean[] select2; // 두번째 순열
	static int[] sumIdx; // 더할 인덱스

	static int sumA, sumB;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			select = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			comb(0, 0);

			System.out.println("#" + tc + " " + min);
		} // end tc
	}

	// 재료 나누기 함수
	static void comb(int cnt, int idx) {

		if (cnt == N / 2) { // 각자 재료가 다 뽑혔으면( true : A, false : B)

			A = new ArrayList<Integer>(); // 뽑힌 재료 번호 리스트를 각각 추가하기 위함
			B = new ArrayList<Integer>();

			for (int n = 0; n < N; n++) { // 뽑힌 재료 번호 리스트를 추가해준다.
				if (select[n])
					A.add(n);
				else
					B.add(n);
			}

			select2 = new boolean[A.size()];

			sumA = 0; // 재료들의 시너지 합을 위한 변수
			sumB = 0;

			sumIdx = new int[2];
			comb2(0, true); // A값 더해주기
			sumIdx = new int[2];
			comb2(0, false); // B값 더해주기
			if (min > Math.abs(sumA - sumB))
				min = Math.abs(sumA - sumB);

			return;
		}

		for (int i = idx; i < N; i++) {

			select[i] = true;
			comb(cnt + 1, i + 1);
			select[i] = false;
		}

	}

	static void comb2(int cnt, boolean flag) { // 각각 N/2개씩 분류된 재료들 중에 2개씩 뽑아서 시너지 값을 얻기 위한 재귀함수

		if (cnt == 2) {

			if (flag) {
				sumA += synergy[sumIdx[0]][sumIdx[1]];
			} else {
				sumB += synergy[sumIdx[0]][sumIdx[1]];
			}

			return;
		}

		for (int i = 0; i < A.size(); i++) { // A랑 B랑 크기 같아서 상관없음

			if (select2[i])
				continue;

			select2[i] = true;
			
			if (flag)
				sumIdx[cnt] = A.get(i);
			else
				sumIdx[cnt] = B.get(i);
			
			comb2(cnt + 1, flag);
			select2[i] = false;

		}
	}
}
