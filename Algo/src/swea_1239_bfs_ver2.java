

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class swea_1239_bfs_ver2 {
	
	static int[][] map;
	static int ans;		// 가장 늦게 연락받는 애( 여럿이라면 그중 번호가 큰 애)
	static boolean[] visit;
	static boolean[] exist;	// 학생 번호가 반드시 연속적이지 않으므로 존재하는 애들 표시해놓기
	static int N, start;	// 입력되는 연결정점의 갯수, 시작노드
	static int maxDist;

    public static void main(String[] args) throws IOException {
 
    	Scanner sc = new Scanner(System.in);
    	int TC = 10;
    	
    	for(int tc=1;tc<=TC;tc++) {
    		map = new int[101][101];
    		ans = 0;
    		visit = new boolean[101];
    		exist = new boolean[101];
    		maxDist = 0;
    		
    		N = sc.nextInt();
    		start = sc.nextInt();
    		
    		for(int i=0;i<N/2;i++) {
    			int st = sc.nextInt();
    			int end = sc.nextInt();
    			map[st][end] = 1;			// 입력 받기
    			exist[st] = true;
    			exist[end] = true;
    		}
    		
    		
    		// BFS ver1 : 탐색하면서 방문하는 각 정점마다 거리를 같이 기록해놓기
    		Queue<Student> queue = new LinkedList<swea_1239_bfs_ver2.Student>();
    		queue.add(new Student(start,0));
    		
    		ArrayList<Student> candidate = new ArrayList<>();
    		visit[start] = true;				// q에 집어넣는 순간 방문처리 하기

    		while(!queue.isEmpty()) {
    			
    			Student now = queue.poll();
    			
    			for(int i=1;i<=100;i++) {
    				if(map[now.num][i]==1 && !visit[i]) {
    					queue.add(new Student(i, now.dist+1));
    					visit[i] = true;
    				}
    			}	
    			
    			if(now.dist > maxDist) {	// 거리가 멀다! 지금까지 모은 애들은 지우기
    				candidate.clear();
    				//System.out.println(now.num+">");
    				maxDist = now.dist;
    				candidate.add(now);
    			} else if(now.dist == maxDist) {	// 거리가 같음! 일단 모으기
    				candidate.add(now);
    			//	System.out.println(now.num);
    			}
    		}
    		
    		for(int i=0;i<candidate.size();i++) {		// 거리가 먼 애들만 모인 리스트에서 학생번호 큰거찾기
    			if(candidate.get(i).num > ans)
    				ans = candidate.get(i).num;
    		}
    		
    		System.out.println("#" + tc + " " + ans);
    		
    		
    	} // tc end
       
    } // main end
 
    static class Student{
    	int num; 	// 학생번호
    	int dist;	// 출발점에서 걔까지 걸리는 거리
    	
    	Student(int n,int d){
    		num = n;
    		dist = d;
    	}
    } // 객체로 학생번호와 거리 묶어줌
    
    
} // class end
