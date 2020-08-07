package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_15657_n과m_8 {

	static BufferedWriter bw;
	static BufferedReader br;
	static StringTokenizer st;
	
	static int N,M;
	static int[] input;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		comb(0,0);
		bw.flush();
		bw.close();
	}
	
	static void comb(int cnt, int idx) throws IOException {
		if(cnt==M) {
			for(int b : ans) {
				bw.write(b + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			ans[cnt] = input[i];
			comb(cnt+1,i);			// 자기 자신을 뽑아도 되니까 idx를 자기 자신부터 하기
		}
	}
}
