package BaekJoon;

import java.util.Scanner;

// n과 m(1) >> 순서 있고 자기 자신 안뽑기 : 순열
/*
입력 : 4 2
1 2 
1 3 
1 4 
2 1 
2 3 
2 4 
3 1 
3 2 
3 4 
4 1 
4 2 
4 3 
 */

public class bj_15649 {
	
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
		
		perm(0);
	}
	
	static void perm(int cnt) {
		
		if(cnt==M) {
			for(int n : numbers) {
				System.out.print(n+ " ");
			}
			System.out.println();
			return;
		}
			
			
		for(int i=1;i<N+1;i++) {
			
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
		
		
	}
	
	
}
