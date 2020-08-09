package Swea;
import java.util.Scanner;

public class swea_9229 {

	static int N;			// 과자봉지 개수
	static int M;			// 최대 무게 제한
	static int R = 2;
	static int[] snack;		// 과자
	static int[] choice;	// 과자선택
	static int max;			// 현재 과자 최대값
	
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
			return max; // 선택한 과자봉지 합 return
		}
		
		for(int i=idx;i<N;i++) {
			
			choice[cnt] = snack[i];
			combination(i+1,cnt+1);
			
		}
		return max;
		
	}
	
	
	
	
	
}
