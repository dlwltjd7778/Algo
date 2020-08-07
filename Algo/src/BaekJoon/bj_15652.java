package BaekJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// n과 m(4) >> 순서 없음, 자기자신 뽑기 : 중복조합
/*
입력 : 4 2
1 1 
1 2 
1 3 
1 4 
2 2 
2 3 
2 4 
3 3 
3 4 
4 4 
 */
public class bj_15652 {
	
	static int N;
	static int M;
	static int[] numbers;
	static boolean[] isSelected;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		comb(0,1);
		bw.flush();
		bw.close();
	}
	
	static void comb(int count, int num) throws IOException {
		
		if(count==M) {
			for(int n : numbers) {
				bw.write(n+" ");
			}
			bw.write("\n");
			return;
		}
			
			
		for(int i=num;i<=N;i++) {
			
			numbers[count] = i;
			comb(count+1, i);
		}
		
		
	}
	
	
}
