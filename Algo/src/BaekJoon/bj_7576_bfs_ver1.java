package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_7576_bfs_ver1 {

	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static int[][] tomato;
	static boolean[][] visit;
	static int day;
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		day = 0;

		int maxDay =-1;
		
		tomato = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) {
					q.add(new Point(i, j));				// �̹� ���� �丶�並 ť�� ����
				}
				
			}
		}
		
		// ������ �丶�䰡 ���� ��� 0 �� ����ϰ� return
		boolean allGrown = true;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					allGrown = false;
				}
			}
		}
		if(allGrown) {					
			maxDay = 0;
			System.out.println(maxDay); 
			return;
		}
		
		// bfs ����
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			
			for(int s=0;s<size;s++) {
				
				Point now = q.poll();
				int nowi=now.i, nowj=now.j;
				
				for(int d=0;d<4;d++) {
					int ni = nowi + di[d];
					int nj = nowj + dj[d];
					
					if (ni < 0 || nj < 0 || ni > N-1 || nj > M-1) continue; // �迭 ���� üũ
					
					if (tomato[nowi][nowj] == 1 
							&& tomato[ni][nj] == 0 
							&& !visit[ni][nj]) {
						tomato[ni][nj] = 1;
						visit[ni][nj] = true; // �湮 ǥ��
						q.add(new Point(ni, nj));
					}
				}	// ��,��,��,�� Ž�� ��
				
			} // size ��ȸ ��
			maxDay++;
			
		} // bfs end
		
		
		// ������ �丶�䰡 �ִ��� Ȯ��, ������ -1 return
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomato[i][j]==0) {
					maxDay = -1;
					System.out.println(maxDay);
					return;
				}
			}
		}
		
		// ���� ��찡 ���� �ƴҶ�
		System.out.println(maxDay);
		
		
	} // main end
	
	static class Point{
		int i,j;	// i,j ��ǥ�� �� ������ ��!
		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
}
