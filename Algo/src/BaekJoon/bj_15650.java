package BaekJoon;

import java.util.Scanner;

// n과 m(2) >> 순서 없음, 자기자신 안뽑기 > 조합
/*
입력 : 4 2
1 2 
1 3 
1 4 
2 3 
2 4 
3 4 

 */
public class bj_15650 {
	
	static int N;
	static int M;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		comb(1,0);
	}
	
	static void comb(int num, int count) {
		
		if(count==M) {
			for(int n : numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
			
			
		for(int i=num;i<=N;i++) {
			
			numbers[count] = i;
			comb(i+1,count+1);
		}
		
		
	}
	
	
}
