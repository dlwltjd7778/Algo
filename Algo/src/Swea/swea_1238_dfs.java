package Swea;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
 
public class swea_1238_dfs {
	
	static int[][] map;
	static int ans;		// 가장 늦게 연락받는 애( 여럿이라면 그중 번호가 큰 애)
	static boolean[] visit;
	static int N, start;	// 입력되는 연결정점의 갯수, 시작노드
	static int maxDist;
	static int[] dist;		// 정점까지의 거리가가장 짧은 경우가 기록되었을것

    public static void main(String[] args) throws IOException {
 
    	Scanner sc = new Scanner(System.in);
    	int TC = 10;
    	
    	for(int tc=1;tc<=TC;tc++) {
    		map = new int[101][101];
    		ans = 0;
    		visit = new boolean[101];
    		dist = new int[101];
    		
    		N = sc.nextInt();
    		start = sc.nextInt();
    		
    		for(int i=0;i<N/2;i++) {
    			int st = sc.nextInt();
    			int end = sc.nextInt();
    			map[st][end] = 1;			// 입력 받기
    		}
    		
    		// dfs 메소드 : 일단 다른애들 연락 가능하더라도 한놈부터 선택해서 연락 돌려보기
    		Arrays.fill(dist, Integer.MAX_VALUE);	// 1차 배열을 가장 큰값으로 채워넣기
    		dfs(start,0);
    		
    		maxDist = 0;
    		for(int i=1;i<=100;i++) {
    			if(dist[i]!=Integer.MAX_VALUE && maxDist<=dist[i]) {
    				maxDist = dist[i];
    				ans = i;
    			}
    		}
    		
    		System.out.println("#" + tc + " " + ans);
    		
    		
    	} // tc end
       
    } // main end

    
    // dfs 메소드 : 일단 다른애들 연락 가능하더라도 한놈부터 선택해서 연락 돌려보기
    static void dfs(int now, int cnt) {
    	
    	dist[now] = cnt;
    	
    	for(int i=1;i<=100;i++) {
    		if(map[now][i]==1 && dist[i] > cnt+1) {
    			dfs(i,cnt+1);
    		}
    	}
    } // dfs end
    
} // class end
