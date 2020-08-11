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
	static ArrayList<InfoM> list;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<InfoM>();
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," "); 
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new InfoM(start, end));
			list.add(new InfoM(end, start));
		} // input end
		
		Collections.sort(list);		// 순서대로 방문하기 위해 정렬
		
		
		
		
		
		
		
	}
	
	static void bfs(int start) throws IOException {
		visit = new boolean[N+1];		// 초기화
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visit[start] = true;
		queue.add(start);
		bw.write(start + " ");
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0;s<size;s++) {
				int temp = queue.poll();
				bw.write(temp + " ");
				
				if(!visit[temp])
				
				
				
			}
		}
		
		
		
		
	}
	
	
	// 간선 정보를 저장하는 클래스
	static class InfoM implements Comparable<InfoM>{ 
		int start,end;
		public InfoM(int start,int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(InfoM o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return start + " " + end;
		}
	}
}
