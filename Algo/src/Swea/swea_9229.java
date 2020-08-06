package Swea;
import java.util.Scanner;

public class swea_9229 {

	static int N;			// ���ں��� ����
	static int M;			// �ִ� ���� ����
	static int R = 2;
	static int[] snack;		// ����
	static int[] choice;	// ���ڼ���
	static int max;			// ���� ���� �ִ밪
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			snack = new int[N];
			choice = new int[R];
			max = -1;
			
			for(int i=0;i<N;i++) {
				snack[i] = sc.nextInt();
			}
			
			
			
			int result = combination(0,0);
			System.out.println("#" + tc + " " + result);
			
			
		} // tc end
		
	} // main end
	
	static int combination(int idx, int cnt) {
		
		if(cnt==R) {
			int sum = choice[0] + choice[1];
			if(sum<=M && sum>max) max = sum;
			return max; // ������ ���ں��� �� return
		}
		
		for(int i=idx;i<N;i++) {
			
			choice[cnt] = snack[i];
			combination(i+1,cnt+1);
			
		}
		return max;
		
	}
	
	
	
	
	
}
