package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_1992_쿼드트리 {

	static BufferedReader br;
	static BufferedWriter bw;

	static int N;
	static char[][] video; // 영상
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		video = new char[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			video[i] = str.toCharArray();
		} // input end

		if (compress(0, 0, N, N)) {
			bw.write(video[0][0]);
		} else {
			divide(0, 0, N, N);
		}
		bw.flush();
	}

	static void divide(int si, int sj, int ei, int ej) throws IOException {
		bw.write("(");
		int mi = (si + ei) / 2; // 현재 주어진 것의 중간 잡기
		int mj = (sj + ej) / 2;

		if(compress(si, sj, mi, mj))
			bw.write(video[si][sj]);
		else
			divide(si, sj, mi, mj); // 1번 영역
		
		if(compress(si, mj, mi, ej))
			bw.write(video[si][mj]);
		else
			divide(si, mj, mi, ej); // 2번 영역
		
		if(compress(mi, sj, ei, mj))
			bw.write(video[mi][sj]);
		else 
			divide(mi, sj, ei, mj); // 3번 영역
		
		if(compress(mi, mj, ei, ej))
			bw.write(video[mi][mj]);
		else
			divide(mi, mj, ei, ej); // 4번 영역

		bw.write(")");

	}

	static boolean compress(int si, int sj, int ei, int ej) throws IOException { // 영상 압축하는 메소드

		char c = video[si][sj]; // 첫 시작 문자 > 0인지 1인지 확인
		for (int i = si; i < ei; i++) {
			for (int j = sj; j < ej; j++) {
				if (c != video[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
