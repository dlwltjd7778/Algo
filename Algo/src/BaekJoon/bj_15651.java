package BaekJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// n과 m(3) : 순서 있음, 자기자신 뽑음 >> 중복순열
/*
입력 : 4 2
1 1 
1 2 
1 3 
1 4 
2 1 
2 2 
2 3 
2 4 
3 1 
3 2 
3 3 
3 4 
4 1 
4 2 
4 3 
4 4 

 */
public class bj_15651 {
	
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
		
		perm(0);
		bw.flush();
		bw.close();
	}
	
	static void perm(int count) throws IOException {
		
		if(count==M) {
			for(int n : numbers) {
				bw.write(n+" ");
			}
			bw.write("\n");
			return;
		}
			
			
		for(int i=1;i<=N;i++) {
			
			isSelected[i] = true;
			numbers[count] = i;
			perm(count+1);
			isSelected[i] = false;
		}
		
		
	}
	
	
}
