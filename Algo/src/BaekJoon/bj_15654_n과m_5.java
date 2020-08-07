package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// n과m 5

public class bj_15654_n과m_5 {

	static int N,M;
	static int[] input;		// 들어오는 숫자배열
	static boolean[] select; 	// 선택 여부
	static int[] ans;		// 뽑은 배열
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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
		perm(0);
		
		bw.flush();
		
	}
	
	static void perm(int cnt) throws IOException {
		
		
		if(cnt==M) {
			for(int i=0;i<M;i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(select[i]) continue;	// 자기 자신을 선택 했는지 안했는지 판별 가능
			
			ans[cnt] = input[i];
			select[i] = true;
			perm(cnt+1);
			select[i] = false;
		}
	}
	
}
