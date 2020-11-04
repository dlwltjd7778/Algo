package Swea;

import java.util.Scanner;

public class swea_5643_키순서 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int i = 0; i < M; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				arr[a][b] = 1;
			} // end input

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						for (int k = 0; k < N; k++) {
							if (arr[j][k] == 1) {
								arr[i][k] = 1;
							}
						}
					}
				}
			}
			int res = 0;
			for (int n = 0; n < N; n++) {
				int cnt = 0;
				for (int idx = 0; idx < N; idx++) {
					if (arr[n][idx] == 1)
						cnt++;
					if (arr[idx][n] == 1)
						cnt++;
				}
				if (cnt == N - 1)
					res++;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
