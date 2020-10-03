package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pg_스택큐_다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> truckQ = new LinkedList<Integer>();
        Queue<Integer> bridgeQ = new LinkedList<Integer>();
        
        for(int i=0;i<truck_weights.length;i++) {
        	truckQ.add(truck_weights[i]);
        }
        
        int nowW = 0;	// 현재 다리위의 트럭 무게
        bridgeQ.add(truckQ.peek());
        nowW += truckQ.poll();
        
        while(true) {
        	answer++;
        	
        	if(truckQ.isEmpty()) {
        		answer += bridge_length;
        		break;
        	}
        	
    		if(!truckQ.isEmpty() && truckQ.peek()+nowW <= weight) {	// 만약 트럭Q의 피크값과 현재 트럭무게 더한값이 다리가 견디는 무게라면
    			bridgeQ.add(truckQ.peek());
    			nowW += truckQ.poll();
    		} else {
    			bridgeQ.add(0);
    		}
    		
    		if(bridgeQ.size()==bridge_length) {
    			nowW -= bridgeQ.poll();
    		} 
        }
        
        return answer;
    }
	public static void main(String[] args) {

		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}
