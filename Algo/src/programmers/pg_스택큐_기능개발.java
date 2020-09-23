package programmers;

import java.util.ArrayList;

public class pg_스택큐_기능개발 {

	public static int[] solution(int[] progresses, int[] speeds) {
       
        int chkCnt = 0;	// 출시 몇개했나 카운트
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(true) {
        	if(chkCnt==progresses.length) break;
        	
        	for(int i=0;i<progresses.length;i++) {
        		progresses[i] += speeds[i];		// 하루마다 상태 바뀐다.
        	}
        	
        	int tmpCnt = 0;
        	for(int i=chkCnt;i<progresses.length;i++) {
        		if(progresses[i]<100) break;	// 100보다 작으면 출시못한다
        		chkCnt++;
        		tmpCnt++;
        	}
        	if(tmpCnt>0) list.add(tmpCnt);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++) {
        	answer[i] = list.get(i);
        	//System.out.println(answer[i]);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(solution(progresses, speeds));
	}
}
