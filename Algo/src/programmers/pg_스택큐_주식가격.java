package programmers;

public class pg_스택큐_주식가격 {

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
	
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		solution(prices);
	}
}
