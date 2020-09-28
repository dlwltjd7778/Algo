package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pg_그래프_가장먼노드 {

	public static int solution(int n, int[][] edge) {
    
        boolean[] visit = new boolean[edge.length+1];	// 방문 노드인지 확인
        List<Integer>[] list = new ArrayList[edge.length+1];
        
        for(int i=0;i<edge.length;i++) {
        	if(list[edge[i][0]] == null) {
        		list[edge[i][0]] = new ArrayList<Integer>();
        	}
        	if(list[edge[i][1]] == null) {
        		list[edge[i][1]] = new ArrayList<Integer>();
        	}
        	list[edge[i][0]].add(edge[i][1]);
        	list[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(1);
        visit[1] = true;
        int size = 0;
        
        while(!queue.isEmpty()) {
        	
        	size = queue.size();
        	
        	for(int s=0;s<size;s++) {
        		
        		int now = queue.poll();
        		
        		if(list[now] != null) {
        			for(int i=0;i<list[now].size();i++) {
        				if(!visit[list[now].get(i)]) {
        					queue.add(list[now].get(i));
        					visit[list[now].get(i)] = true;
        				}
        			}
        		}
        		
        		
        	}
        	
        }
        
        
        
        return size;
    }
	
	
	public static void main(String[] args) {
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int n = 6;
		
		System.out.println(solution(n, edge));
	}
}
