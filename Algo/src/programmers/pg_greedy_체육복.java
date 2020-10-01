package programmers;

import java.util.Arrays;

public class pg_greedy_체육복 {

	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] clothes = new int[n+1];
        
        Arrays.fill(clothes,1);
        
        for(int i=0;i<reserve.length;i++) {
        	clothes[reserve[i]]++;
        }
        for(int i=0;i<lost.length;i++) {
        	clothes[lost[i]]--;
        }
        for(int i=0;i<lost.length;i++) {
        	if(lost[i]-1>=0 && clothes[lost[i]-1]==2) {
        		clothes[lost[i]-1]--;
        		continue;
        	}
        	if(lost[i]+1<n+1 && clothes[lost[i]+1]==2) {
        		clothes[lost[i]+1]--;
        		continue;
        	}
        	answer--;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 3;
		int[] lost = {1,2};
		int[] reserve = {2};
		System.out.println(solution(n, lost, reserve));
	}
}
