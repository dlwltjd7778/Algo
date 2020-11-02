package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.text.PlainDocument;

public class swea_수영장_dp {

	// DP
	
	/*
	 * - 1년 사용권 배제
	 	D[i] : i월까지 이용했을 때의 최소비용
	 	D[12] : 12월까지 3종류의 사용권을 사용하는 경우를 고려한 최소비용 
	 	- 1일 : 이전달 최소금액 + 이용일수*1일권금액
	 	- 1달 : 
	 	- 1월
	 */
	
	static int moneys[],days[],min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 이용권 가격들
			moneys = new int[4];
			for(int i=0;i<4;i++) {
				moneys[i] = Integer.parseInt(st.nextToken());
			}
			// 12개월 이용 계획
			days = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=12;i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			// end input
			
			
			System.out.println("#" + tc + " " + plan());
		} // end tc
	} // end main
	
	private static int plan() {
		int D[] = new int[13];
		
		for (int i = 1; i <= 12; i++) {
		
			// 1일권
			D[i] = D[i-1] + days[i]*moneys[0];
			
			// 1달권
			if(days[i] > 0) D[i] = Math.min(D[i], D[i-1]+moneys[1]);
			
			// 3달권
			if(i>=3) D[i] = Math.min(D[i], D[i-3]+moneys[2]);
		}
		return Math.min(D[12], moneys[3]);	// 12월까지의 최소비용과 1년권을 비교
	}
	
	
}
