package BaekJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class bj_10974_모든순열 {

	static int[] ans;
	static boolean[] select;
	static int N;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		ans = new int[N];
		select = new boolean[N];
		
		perm(0);
		
		bw.flush();
		
	}
	
	static void perm(int cnt) throws IOException {
		
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				bw.write(ans[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(select[i]) continue;
			
			select[i] = true;
			ans[cnt] = i+1;
			perm(cnt+1);
			select[i] = false;
		}
		
	}
}
