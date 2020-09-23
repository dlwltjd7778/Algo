package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pg_스택큐_프린터 {

	public static int solution(int[] priorities, int location) {
	
		Queue<Printer> queue = new LinkedList<Printer>();
		
		int max = 0;	// 최대 우선순위 값
		for(int i=0;i<priorities.length;i++) {
			max = Integer.max(max, priorities[i]);
			queue.add(new Printer(priorities[i], i));
		} 
		int count = 0;	// 정답 카운트
		while(true) {
			
			Printer p = queue.poll();	// 큐에서 맨앞꺼 뺀다
			
			if(p.pri==max) {	// 현재 우선순위 최댓값이 큐에서 꺼낸 우선순위라면
				count++;		// 어쨌든 꺼낼 차례니까 카운트 세줌
				
				if(p.idx==location) break;	// 위치까지 같다면 정답 찾았다!
				
			} else { // 우선순위보다 낮다면
				queue.add(p);	// 뒤에 다시 추가해준다
			}

			// 우선순위 확인
			max = 0;
			for(Printer printer: queue) {
				max = Integer.max(max, printer.pri);
			}
			
		}
		
		return count;
	}
	
	static class Printer{
		int pri,idx;
		Printer(int pri, int idx){
			this.pri = pri;
			this.idx = idx;
		}
	}

	 public static void main(String[] args) {
		
		 int[] pri = {2, 1, 3, 2};
		 System.out.println(solution(pri, 2));
		 
		 
	}
	 
	 
}
