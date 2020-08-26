package BaekJoon;

import java.util.Scanner;

public class bj_1074_Z {

	static int N, r, c;
	static boolean flag = false;
	static int count = -1; // 정답 카운트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		int n = 1;

		for (int i = 0; i < N; i++) {
			n *= 2;
		}

		divide(0, 0, n, n);
		System.out.println(count);

	}

	static void divide(int si, int sj, int ei, int ej) {
		
		if(!flag) {
			
			int mi = (si + ei) / 2; // 현재 주어진 것의 중간 잡기
			int mj = (sj + ej) / 2;
			
			
			if (chk(si, sj, mi, mj)) {
				if(flag) return;
				count++;
				if(si==r && sj==c) flag = true;
			} else {
				divide(si, sj, mi, mj); // 1번 영역
			}
			
			if (chk(si, mj, mi, ej)) {
				if(flag) return;
				count++;
				if(si==r && mj==c) flag = true;
			} else {
				divide(si, mj, mi, ej); // 2번 영역
			}
			
			if (chk(mi, sj, ei, mj)) {
				if(flag) return;
				count++;
				if(mi==r && sj==c) flag = true;
			} else {
				divide(mi, sj, ei, mj); // 3번 영역
			}
			
			if (chk(mi, mj, ei, ej)) {
				if(flag) return;
				count++;
				if(mi==r && mj==c) flag = true;
			} else {
				divide(mi, mj, ei, ej); // 4번 영역
			}
		}

	}

	static boolean chk(int si, int sj, int ei, int ej) {

		if (Math.abs(si - ei) == 1 && Math.abs(sj - ej) == 1)
			return true;

		return false;
	}
}
