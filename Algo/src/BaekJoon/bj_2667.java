package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2667 {

	static int N;					// ������ ũ��
	static int map[][];				// ���� ����
	static boolean visit[][];		// �湮 Ȯ��
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,1,-1};
	static ArrayList<Integer> count;
	static int danji;
	
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
		danji = 0; // ���� ����
		count = new ArrayList<Integer>(); 
			// ���� ���� ���� ����Ʈ, �ε���  = ���� ��ȣ-1
			// ������ � ������ ���� arraylist�� ����..
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j] == 1) { // ���� �ִ� ��ġ�̰�
					if (!visit[i][j]) { // �湮���� �ʾҴٸ�
						danji++; // ���ο� ������ �������ϱ� ���� �÷���

						queue.add(new Point(i, j)); // ť�� �ϳ� �߰�
						visit[i][j] = true; // �ڱ��ڽ� �湮ó��
						count.add(1); // ���ο� ������ �� ���� �߰�

						while (!queue.isEmpty()) {

							int size = queue.size();
							for (int s = 0; s < size; s++) {

								Point nowP = queue.poll();

								int nowi = nowP.i;
								int nowj = nowP.j;
								for (int d = 0; d < 4; d++) {
									int ni = nowi + di[d];
									int nj = nowj + dj[d];

									if (ni < 0 || nj < 0 || ni > N - 1 || nj > N - 1)
										continue;

									if (map[ni][nj] == 1 && !visit[ni][nj]) {

										count.set(danji - 1, count.get(danji - 1) + 1);
										queue.add(new Point(ni, nj));
										visit[ni][nj] = true;
									}
								}

							}

						}

					}
				}
			} // �迭 ��ȸ j ��
		} // �迭 ��ȸ i ��

		Collections.sort(count);
		System.out.println(danji);
		for (int i = 0; i < count.size(); i++) {
			System.out.println(count.get(i));
		}

	}
	
	static class Point{
		int i,j;
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
