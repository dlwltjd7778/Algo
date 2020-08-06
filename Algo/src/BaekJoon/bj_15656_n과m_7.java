package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_15656_n과m_7 {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	
	static int N,M;
	static int[] input;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		ans = new int [M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		perm(0);
		bw.flush();
	}
	
	static void perm(int cnt) throws IOException{
		if(cnt==M) {
			for(int i=0;i<M;i++) {
					bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			ans[cnt] = input[i];		// 나를 다시 뽑아도 상관 없음 > select 배열 필요 x
			perm(cnt+1);
		}
	}
}
