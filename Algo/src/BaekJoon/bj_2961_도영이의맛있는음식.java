package BaekJoon;

import java.util.Scanner;

public class bj_2961_�������Ǹ��ִ����� {

	static int N;				// ��� ����
	static Ingredients[] list;	// ��� ���� ���� ����Ʈ
	static boolean[] select;	// ��� �����ߴ��� Ȯ���ϱ�
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new Ingredients[N];
		select = new boolean[N];
		
		for(int i=0;i<N;i++) { // S, B�� ���ʴ�� �޾Ƽ� ��� ����Ʈ�� �߰�
			list[i] = new Ingredients(sc.nextInt(), sc.nextInt()); 
		} // �Է� end
		
		
		
		
		
		
	}
	
	static void subset(int cnt, int idx) {
		
		
		
	}
	
	// ��� class 
	static class Ingredients{
		int S,B;	// �Ÿ�, ����

		public Ingredients(int s, int b) {
			super();
			S = s;
			B = b;
		}
	} // ��� class end
} // class end
