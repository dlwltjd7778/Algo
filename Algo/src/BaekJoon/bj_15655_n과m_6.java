package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_15655_n과m_6 {

	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	
	static int N,M;
	static int[] input;	// 입력배열
	static int[] ans;	// 정답배열
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
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
			for(int i=0;i<M;i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=idx;i<N;i++) {	
			ans[cnt] = input[i];
			comb(cnt+1,i+1);		// idx를 1씩 증가시키기 때문에 자기 자신은 다시 안뽑음
		}
	}
}
