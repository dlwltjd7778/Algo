package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1260_graph {

	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	static int N,M,V;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		} // input end
		
		for(int i=0;i<N+1;i++) {
			Collections.sort(list[i]); // 순서대로 방문하기 위해 정렬
		}
//		for(int i=0;i<N+1;i++) {
//			for(int j=0;j<list[i].size();j++) {
//				System.out.print(list[i].get(j) + " ");
//			}
//			System.out.println();
//		}
		
		dfs(V,0,list);
		bw.newLine();
		bfs(V, list);
				
		bw.flush();
		
	}
	
	static void dfs(int start, int count, ArrayList<Integer>[] list) throws IOException {
		
		
		visit[start] = true;
		bw.write(start + " ");
		
		if(count==M) return;
		
		for(int i=0;i<list[start].size();i++) {
			int tempEnd = list[start].get(i);
			if(!visit[tempEnd]) {
				visit[tempEnd] = true;
				dfs(tempEnd,count+1,list);
			}
			
		}
		
		
	}
	
	static void bfs(int start, ArrayList<Integer>[] list) throws IOException {
		visit = new boolean[N+1];		// 초기화
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visit[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				int temp = queue.poll();
				bw.write(temp + " ");

				for(int i=0;i<list[temp].size();i++) {
					int tempEnd = list[temp].get(i);
					if(!visit[tempEnd]) {
						queue.add(tempEnd);
						visit[tempEnd] = true;
					}
				}
			}
		}
	} // bfs end
	
	
	
}
