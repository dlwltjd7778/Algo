package programmers;

import java.util.Arrays;
import java.util.Stack;

public class pg_스택큐_주식가격 {

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> idxStack = new Stack<Integer>();
        
        for(int i=0;i<prices.length;i++) {
        	while(!idxStack.isEmpty() && prices[idxStack.peek()] > prices[i]) {
        		
        		answer[idxStack.peek()] = i - idxStack.peek();
        		idxStack.pop();
        	}

        	idxStack.add(i);
        }
        
        while(!idxStack.isEmpty()) {
        	answer[idxStack.peek()] = prices.length - idxStack.peek() -1 ;
        	idxStack.pop();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	/* >> 스택 안쓴 버전
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++) {
        	answer[i] = prices.length-i-1;
        }
        
        for(int i=0;i<prices.length;i++) {
        	for(int j=i+1;j<prices.length;j++) {
        		if(prices[i]>prices[j]) {
        			answer[i] = j-i;
        			break;
        		}
        	}
        	
        }
        
        //System.out.println(Arrays.toString(answer));
        
        return answer;
    }
	*/
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		solution(prices);
	}
}
