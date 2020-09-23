package BaekJoon;

import java.util.Scanner;

public class bj_2563_색종이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 색종이 수
		int[][] paper = new int[100][100];
		
		for(int n=0;n<N;n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x;j<x+10;j++) {			// 열
				for(int i=100-y-10;i<100-y;i++) {	// 행
					paper[i][j] = 1;
				}
			}
		}
		int answer = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]==1) answer++;
				System.out.print(paper[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(answer);
	}
}
