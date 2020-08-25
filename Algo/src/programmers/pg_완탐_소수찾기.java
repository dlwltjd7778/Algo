package programmers;

public class pg_완탐_소수찾기 {

	public static void main(String[] args) {
		
	}
	
	class Solution {
		int num[];
		boolean[] select;
	    public int solution(String numbers) {
	        int answer = 0;
	        
	        num = new int[numbers.length()];
	        select = new boolean[numbers.length()];
	        
	        for(int i=0;i<numbers.length();i++) {
	        	num[i] = numbers.charAt(i)-'0';
	        }
	        
	        
	        
	        
	        
	        
	        return answer;
	    }
	    
	    public void powerSet() {
	    	
	    }
	}
}
