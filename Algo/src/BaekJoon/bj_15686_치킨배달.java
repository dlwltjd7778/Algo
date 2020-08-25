package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class bj_15686_치킨배달 {

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };
	static int N, M;
	static ArrayList<Point> house;
	static ArrayList<Point> chicken;
	static Point[] select;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		select = new Point[M]; // 치킨집 뽑기
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1) {
					house.add(new Point(i, j, 0));
				} else if (tmp == 2) {
					chicken.add(new Point(i, j, 0));
				}
			}
		} // 입력 end

		comb(0, 0);
		System.out.println(min);

	}


	static void comb(int cnt, int idx) {

		if (cnt == M) {
			int sum = 0;
			
			for (int h = 0; h < house.size(); h++) { // 집 위치를 돌면서
				Point houseP = house.get(h); 		// 현재 집 위치
				int minimum = Integer.MAX_VALUE;	// 최소값 초기화
				
				for (int s = 0; s < select.length; s++) { // 뽑은 치킨집과의 최소거리 계산
					Point p = select[s];
					// 거리 계산하기
					int tmp = Math.abs(p.i - houseP.i) + Math.abs(p.j - houseP.j);
					if(minimum>tmp) minimum = tmp;
				}
				sum += minimum;	// 치킨집과의 최소거리를 구했다면 sum에 더해줌
			}
			
			if(sum<min) min = sum;	// 이전 치킨거리가 현재 치킨거리보다 크다면 갱신
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			select[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1);
		}

	}

	static class Point {
		int i, j, count;

		Point(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
}
