package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pg_bfs_네트워크 {

	static boolean[] select;
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		select = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			
			if(select[i]) continue;

			queue.add(i);
			while(!queue.isEmpty()) {
				
				int com = queue.poll();
				select[com] = true;
				
				for(int j=0;j<n;j++) {
					if(select[j] || computers[com][j]==0 || com==j) {
						// 이미 선택한 컴퓨터거나, 연결되어있지 않거나, 자기 자신인경우 제외
						continue;
					}
					queue.add(j);
				}
			}
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

