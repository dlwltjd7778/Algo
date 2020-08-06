package BaekJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2606 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// ��ǻ�Ͱ���
		int M = sc.nextInt();	// ����� ���� ��
		int count = -1;			// ���̷��� �ɸ� ��ǻ�� ����
		
		boolean[][] isLined = new boolean[N+1][N+1];	// ���Ῡ�� Ȯ��
		
		for(int m=0;m<M;m++) {		// ���Ῡ�� �Է� �ޱ�
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
					//System.out.println("��ǻ�� ��ȣ: " + j);
					visited[j] = true;
					
				}
			}
		} // bfs ��
		
		System.out.println(count);

	}

}
