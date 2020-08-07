package BaekJoon;

import java.util.Scanner;

public class bj_2961_도영이의맛있는음식 {

	static int N;								// 재료 개수
	static Ingredients[] list;					// 재료 성분 담을 리스트
	static boolean[] select;					// 재료 선택했는지 확인하기
	static int min = Integer.MAX_VALUE;			// s곱과 b합의 차이의 최소값
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new Ingredients[N];
		select = new boolean[N];
		
		for(int i=0;i<N;i++) { // S, B를 차례대로 받아서 재료 리스트에 추가
			list[i] = new Ingredients(sc.nextInt(), sc.nextInt()); 
		} // 입력 end
		
		
		
		subset(0);
		System.out.println(min);
		
	}
	
	static void subset(int idx) {
		
		if(idx==list.length) {
			// 공집합 처리
			boolean isReturn = true;
			for(int i=0;i<select.length;i++) {
				if(select[i]) {
					isReturn = false;
				}
			}
			if(isReturn) return;
			
			int sMul = 1; // S의 Multiply
			int bAdd = 0; // B의 Add
			for(int i=0;i<select.length;i++) {
				if(select[i]) {
					sMul *= list[i].S;	// 신맛 곱해주기
					bAdd += list[i].B;	// 쓴맛 더해주기
				}
			}
			if(Math.abs(sMul-bAdd)<min) 	// 신맛과 쓴맛의 차이가 최솟값보다 작으면
				min = Math.abs(sMul-bAdd);	// 갱신
			return;
		}
		
		select[idx] = true;
		subset(idx+1); // 자기 다음 인덱스 호출
		select[idx] = false; // 선택 안하는 경우
		subset(idx+1);
	}
	
	// 재료 class 
	static class Ingredients{
		int S,B;	// 신맛, 쓴맛

		public Ingredients(int S, int B) {
			super();
			this.S = S;
			this.B = B;
		}

		@Override
		public String toString() {
			return "Ingredients [S=" + S + ", B=" + B + "]";
		}
		
	} // 재료 class end
} // class end
