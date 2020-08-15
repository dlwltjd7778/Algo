package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_11399_atm {

	static int N;			// 사람의 수
	static int[] p;			// 걸리는 시간 배열

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		p = new int[N];
		
		for(int i=0;i<N;i++) {
			p[i] = sc.nextInt();
		} // input end
		
		Arrays.sort(p);
		
		
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int c=0;c<=i;c++) {
				sum += p[c];
			}
		}
		System.out.println(sum);
		
	} // main end
	

}