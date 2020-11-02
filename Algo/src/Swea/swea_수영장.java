package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.text.PlainDocument;

public class swea_수영장 {

	// 각 이용권을 조합적으로 완탐
	
	/*
	 	매월 의 선택지 * 12 .......... + 1년권 선택지
	 	- 1일 사용권 						
	 	- 1달 사용권
	 	- 3달 사용권
	 	>> 3^12 의 시간복잡도를 갖는다.
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
			days = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<12;i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			// end input
			
			plan();
			System.out.println("#" + tc + " " + min);
		} // end tc
	} // end main
	
	private static void plan() {
		min = moneys[3];	// 1년 사용권 금액을 기본 최소값으로!
		calc(0,0);
	}
	
	// 매달의 이용 가능한 경우를 고려하여 계산
	private static void calc(int m, int sum) {
		
		if(m>=12) {
			if(min>sum) min = sum;
			return;
		}
		
		// 1일권 사용경우: 사용일수 * 1일권 금액
		calc(m+1, sum+days[m]*moneys[0]);
		
		// 1달권 사용경우 : 사용일수가 1일 이상일 때 1달권 금액
		calc(m+1, sum + (days[m]>0?moneys[1]:0));
		
		// 3달권 사용경우
		if(days[m]>0) {	// 해당 월의 사용 일수가 0보다 크면..
			// 사용하면 3달의 이용일수가 3달 사용권으로 처리되므고 다음달이 아닌 3달뒤로 넘어감.
			calc(m+3, sum + moneys[2]);
		} else {
			calc(m+1,sum);	// 이용 일수가 없는 경우
		}

	}
}
