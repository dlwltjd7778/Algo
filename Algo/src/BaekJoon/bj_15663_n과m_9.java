package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class bj_15663_n과m_9 {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	
	static int N,M;
	static int[] input;
	static boolean[] select;
	static int[] ans;
	static int pastNum=-1;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		select = new boolean[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		//perm(0,-1);
		perm2(0);
		bw.flush();
		
	} // main end
	
	static void perm(int cnt, int past) throws IOException {
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				bw.write(ans[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(select[i]) continue;
			pastNum = input[i];
			if(pastNum == past) continue;
			
			ans[cnt] = input[i];
			select[i] = true;
			perm(cnt+1, pastNum);
			select[i] = false;
			
		}
		
		
	}
	static void perm2(int cnt) throws IOException {
			
			if(cnt==M) {
				for(int i=0;i<M;i++) {
					bw.write(ans[i] + " ");
				}
				bw.newLine();
				return;
			}
			
			for(int i=0;i<N;i++) {
				
				if(select[i]) continue;
				if(pastNum == input[i]) continue;
				pastNum = input[i];
				ans[cnt] = input[i];
				select[i] = true;
				perm2(cnt+1);
				select[i] = false;
				
			}
			
			
		}
	
}
