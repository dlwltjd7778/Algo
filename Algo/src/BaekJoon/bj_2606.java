package BaekJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2606 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 컴퓨터개수
		int M = sc.nextInt();	// 연결된 컴터 쌍
		int count = -1;			// 바이러스 걸린 컴퓨터 개수
		
		boolean[][] isLined = new boolean[N+1][N+1];	// 연결여부 확인
		
		for(int m=0;m<M;m++) {		// 연결여부 입력 받기
			int i = sc.nextInt();
			int j = sc.nextInt();
			isLined[i][j] = true;
			isLined[j][i] = true;
		}
		
		// bfs
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			count++;
			
			for(int j=1;j<isLined.length;j++) {
				if(isLined[cur][j] && !visited[j]) {
					q.add(j);
					//System.out.println("컴퓨터 번호: " + j);
					visited[j] = true;
					
				}
			}
		} // bfs 끝
		
		System.out.println(count);

	}

}
