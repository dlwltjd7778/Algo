package BaekJoon;

import java.util.Scanner;

public class bj_2961_도영이의맛있는음식 {

	static int N;				// 재료 개수
	static Ingredients[] list;	// 재료 성분 담을 리스트
	static boolean[] select;	// 재료 선택했는지 확인하기
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new Ingredients[N];
		select = new boolean[N];
		
		for(int i=0;i<N;i++) { // S, B를 차례대로 받아서 재료 리스트에 추가
			list[i] = new Ingredients(sc.nextInt(), sc.nextInt()); 
		} // 입력 end
		
		
		
		
		
		
	}
	
	static void subset(int cnt, int idx) {
		
		
		
	}
	
	// 재료 class 
	static class Ingredients{
		int S,B;	// 신맛, 쓴맛

		public Ingredients(int s, int b) {
			super();
			S = s;
			B = b;
		}
	} // 재료 class end
} // class end
