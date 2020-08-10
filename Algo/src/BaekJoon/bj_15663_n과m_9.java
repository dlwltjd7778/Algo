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
	static HashSet<Integer[]> set;
	
	static int N,M;
	static int[] input;
	static boolean[] select;
	static Integer[] ans;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		set = new HashSet<Integer[]>();
		
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		select = new boolean[N];
		ans = new Integer[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		perm(0);
		
		Iterator iter = set.iterator();	// Iterator 사용
		while(iter.hasNext()) {//값이 있으면 true 없으면 false
		    System.out.println(iter.next());
		}
		
	}
	
	static void perm(int cnt) throws IOException {
	
		if(cnt==M) {
			String temp = "";
			for(int i=0;i<M;i++) {
				temp += ans[i] + " ";
			}
			set.add(ans);
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(select[i]) continue;
			
			select[i] = true;
			ans[cnt] = input[i];
			perm(cnt+1);
			select[i] = false;
		}
		
		
		
	}
}
