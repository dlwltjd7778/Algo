package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//퍼펙트 셔플

public class swea_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			int N = Integer.parseInt(br.readLine());	// 카드 갯수
			
			Stack<String> stack1 = new Stack<String>();
			Stack<String> stack2 = new Stack<String>();
			Stack<String> result = new Stack<String>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			
			if(N%2==0) {
				for(int i=0;i<N/2;i++) {
					stack1.add(st.nextToken());
				}
				for(int i=N/2;i<N;i++) {
					stack2.add(st.nextToken());
				}
				
				while(!stack1.isEmpty()) {
					result.add(stack2.pop());
					result.add(stack1.pop());
				}
				
			} else {
				for(int i=0;i<N/2+1;i++) {
					stack1.add(st.nextToken());
				}
				for(int i=N/2+1;i<N;i++) {
					stack2.add(st.nextToken());
				}
				
				while(!stack1.isEmpty()) {
					result.add(stack1.pop());
					if(!stack2.isEmpty()) {						
						result.add(stack2.pop());
					}
				}
			}
			
			// 정답 출력
			System.out.print("#" + tc + " ");
			while(!result.isEmpty()) {
				System.out.print(result.pop() +" ");
			}
			System.out.println();
			
		} // for end
		

	}

}
