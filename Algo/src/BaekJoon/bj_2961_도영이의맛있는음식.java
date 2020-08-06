package BaekJoon;

import java.util.Scanner;

public class bj_2961_�������Ǹ��ִ����� {

	static int N;								// ��� ����
	static Ingredients[] list;					// ��� ���� ���� ����Ʈ
	static boolean[] select;					// ��� �����ߴ��� Ȯ���ϱ�
	static int min = Integer.MAX_VALUE;			// s���� b���� ������ �ּҰ�
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new Ingredients[N];
		select = new boolean[N];
		
		for(int i=0;i<N;i++) { // S, B�� ���ʴ�� �޾Ƽ� ��� ����Ʈ�� �߰�
			list[i] = new Ingredients(sc.nextInt(), sc.nextInt()); 
		} // �Է� end
		
		
		
		subset(0);
		System.out.println(min);
		
	}
	
	static void subset(int idx) {
		
		if(idx==list.length) {
			// ������ ó��
			boolean isReturn = true;
			for(int i=0;i<select.length;i++) {
				if(select[i]) {
					isReturn = false;
				}
			}
			if(isReturn) return;
			
			int sMul = 1; // S�� Multiply
			int bAdd = 0; // B�� Add
			for(int i=0;i<select.length;i++) {
				if(select[i]) {
					sMul *= list[i].S;	// �Ÿ� �����ֱ�
					bAdd += list[i].B;	// ���� �����ֱ�
				}
			}
			if(Math.abs(sMul-bAdd)<min) 	// �Ÿ��� ������ ���̰� �ּڰ����� ������
				min = Math.abs(sMul-bAdd);	// ����
			return;
		}
		
		select[idx] = true;
		subset(idx+1); // �ڱ� ���� �ε��� ȣ��
		select[idx] = false; // ���� ���ϴ� ���
		subset(idx+1);
	}
	
	// ��� class 
	static class Ingredients{
		int S,B;	// �Ÿ�, ����

		public Ingredients(int S, int B) {
			super();
			this.S = S;
			this.B = B;
		}

		@Override
		public String toString() {
			return "Ingredients [S=" + S + ", B=" + B + "]";
		}
		
	} // ��� class end
} // class end
