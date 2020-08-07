package Swea;

import java.util.Scanner;

public class swea_1954 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int di[] = {-1,0,1,0}; // 위, 오른쪽, 아래, 왼쪽
		int dj[] = {0,1,0,-1};
		
		for(int tc=0;tc<TC;tc++) {
			int N = sc.nextInt();
			
			int[][] array = new int[N][N];
			
			int ni=0, nj=-1;
			
			int d = 1;
			
			int count = 0;
			
			while(count!=N*2+1) {
				count++;
				ni = ni + di[d];
				nj = nj + dj[d];
				System.out.println(ni+" "+nj);
				System.out.println("count : "+count);
				
				if(nj>=N) { // 현재 d=1
					d=2;
					nj--;count--;
					continue;
				}
				
				if(ni>=N) { // 현재 d=2
					d=3;
					ni--;count--;
					continue;
				}
				if(nj<0 ) { // 현재 d=3
					d=0;
					nj++;count--;
					continue;
				}
				if(ni<0) { // 현재 d=0
					d=1;
					ni++;count--;
					continue;
				}
				if(array[ni][nj]!=0) {
					if(d!=3) d++;
					else d=0;
				}
				
				System.out.println("if문 지나고> " + ni+" "+nj);
				array[ni][nj] = count;
				
				
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(array[i][j] + " ");
				}
				System.out.println();
			}
			
			
			
		}
		
		
	}
}
