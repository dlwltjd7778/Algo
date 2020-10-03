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
        
        for(int i=1;i<=bridge_length;i++) {

        	if(nowW<=weight) {
        		truckQ.add(truckQ.peek());
        		nowW += truckQ.poll();
        	}
        	
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}
