package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1697_숨바꼭질 {

	static int[] dx = {-1,1,2};
	static Queue<Integer> queue;		// 몇초만에 K에 도달
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<Integer>();
		visit = new boolean[100001];
		
		int N = sc.nextInt();	// 내 위치
		int K = sc.nextInt();	// 찾아갈 위치
		int ans = 0;
		if(N==K) {
			System.out.println(ans);
			return;
		}
		
		// +-1, *2만 가능, 가장 빨리 찾아가는 횟수 찾기
		
		queue.add(N);		// Q에 현재 숫자 넣기
		visit[N] = true;		// 방문 처리 하기
		
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			ans++;
			
			for(int s=0;s<size;s++) {		
				
				int nowN = queue.poll();
				
				for(int x=0;x<3;x++) {
					int nN = nowN;
					if(x==2) {
						nN = nN * dx[x];		// 현재N을 +=1, *2 해본다
					} else {					
						nN = nN + dx[x];
					}
					if(nN<0 || nN>100000) continue;		// 숫자가 0보다 작아지면 멈춤
					
					if(!visit[nN]) {	// 현재 숫자를 방문하지 않았다면
						queue.add(nN);		// 큐에추가
						visit[nN] = true;		// 방문처리
						if(nN==K) {
							System.out.println(ans);		
							return;// N이 원하는 숫자인 K에 도달하면 답 출력하고 멈추기
						}
					}
				}
			} // queue size for end
		}	// while end
	}

}
