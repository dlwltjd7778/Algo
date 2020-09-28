package programmers;

import java.util.PriorityQueue;

public class pg_heap_더맵게 {

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i=0;i<scoville.length;i++) {
			queue.add(scoville[i]);
		}
		
		while(queue.peek()<K) {
			
			if(queue.size() < 2) {
				return -1;
			}
			
			int a = queue.poll();
			int b = queue.poll();
			
			queue.add(a + 2*b);
			
			answer++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] scoville = {0, 0};
		int K = 0;
		
		System.out.println(solution(scoville, K));
	}
}
