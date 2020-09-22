package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_2309_일곱난쟁이 {

	static int[] num;
	static int[] ans;
	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = new int[9];
		ans = new int[7];
		select = new boolean[9];
		
		for(int i=0;i<9;i++) {
			num[i] = sc.nextInt();
		}
		// input end
		
		find(0,0);
		
		Arrays.sort(ans);
		for(int i=0;i<7;i++) {
			System.out.println(ans[i]);
		}
	}

	static boolean isHundred = false;
	private static void find(int cnt, int idx) {
		
		//if(isHundred) return;
		
		if(cnt==7) {
			int tmpSum = 0;
			for(int i=0;i<7;i++) {
				tmpSum += ans[i];
			}
			
			if(tmpSum==100) isHundred = true;
			return;
		}
		
		for(int i=idx;i<9;i++) {
			if(isHundred) return;
			ans[cnt] = num[i];
			find(cnt+1, i+1);
		}
		
	}
	
}
