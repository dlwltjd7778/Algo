package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
	프로그래머스 네트워크
	bfs
	https://programmers.co.kr/learn/courses/30/lessons/43162
 */

public class pg_bfs_네트워크 {

	static boolean[] select;
	public static int solution(int n, int[][] computers) {

		int answer = 0;										// 정답체크
		select = new boolean[n];							// 체크한 컴퓨터인지 확인

		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			
			if(select[i]) continue;							// 이미 체크한 컴퓨터라면 건너뛰기

			queue.add(i);									// 큐에 컴퓨터 번호 넣어주기

			while(!queue.isEmpty()) {
				
				int com = queue.poll();						// 체크할 컴퓨터 번호 꺼내고,
				select[com] = true;							// 체크한 컴퓨터 처리해주기
				
				for(int j=0;j<n;j++) {
					// 이미 선택한 컴퓨터거나, 연결되어있지 않거나, 자기 자신인경우 제외
					if(select[j] || computers[com][j]==0 || com==j) continue;

					// 연결된 경우 큐에 넣어서 더 연결된게 있는지 체크
					queue.add(j);
				}
			}
			// while문이 끝났다는 것은 하나의 네트워크를 체크한 것으로 정답 수 count
			answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));
	}
}

