package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2667 {

	static int N;				// ������ ũ��
	static int map[][];			// ���� ����
	static boolean visit[][];		// �湮 Ȯ��
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		// �迭 �Է� �ޱ�
		for(int i=0;i<N;i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		// ��ü �迭 ��ȸ
		int danji = 0;					// ���� ����
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
			if(map[i][j]==1) {			// ���� �ִ� ��ġ�̰� �湮���� �ʾҴٸ�
				if(!visit[i][j]) {
					danji++;
					int count = 1;						// ���� ���� �ʱ�ȭ
					queue.add(new Point(i, j, count));	// ť�� �ϳ� �߰�
					
					while(!queue.isEmpty()){
						
						int nowi = i;
						int nowj = j;
						
						for(int d=0;d<4;d++) {
							int ni = nowi + di[d];
							int nj = nowj + dj[d];
							
							if(ni<0 || nj<0 || ni>N-1 || nj>N-1) continue;
							
							if(map[ni][nj]==1 && !visit[ni][nj]) {
								queue.add(new Point(ni, nj, count+1));
								visit[ni][nj] = true;
							}
						}
						
					}
					
					
					
				}
			}
			} // �迭 ��ȸ ��
			
			System.out.println(danji );
		}
		
		
		
		
	}
	
	static class Point{
		int i,j;
		int count;	// ������
		public Point(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
	}
}
