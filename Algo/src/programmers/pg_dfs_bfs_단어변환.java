package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pg_dfs_bfs_단어변환 {

	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean chk = false;
        
        Queue<String> queue = new LinkedList<>();
        List<String> visitList = new ArrayList<String>();
        
        queue.add(begin);
        visitList.add(begin);
        
        while(!queue.isEmpty()) {
        	
        	int size = queue.size();
        	
        	for(int s=0;s<size;s++) {
        		
        		String tmp = queue.poll();
        		if(tmp.equals(target)) {
        			chk = true;
        			return answer;
        		}
        		
        		for(int i=0;i<words.length;i++) {
        			
        			int sameCnt = 0;
        			String nowStr = words[i];
        			for(int j=0;j<tmp.length();j++) {
        				if(tmp.charAt(j) == nowStr.charAt(j))
        					sameCnt++;
        			}
        			
        			if(sameCnt == tmp.length()-1 && !visitList.contains(nowStr)) {
        				queue.add(nowStr);
        				visitList.add(nowStr);
        				
        			}
        		}
        		
        	}
        	answer++;
        }
        
        if(!chk) answer = 0;
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
		
		System.out.println(solution(begin, target, words));
		
	}
}
