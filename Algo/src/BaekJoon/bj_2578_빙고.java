package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2578_빙고 {

	static int[][] bingo;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[5][5];
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<5;j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		int answer = 0;
		boolean isGo = true;
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if(isGo) {
					check(tmp);
					answer++;
					if(i==0 && j<3) continue;
					if(bingo()>=3) {
						isGo = false;
					}
				}
				
			}
		} 
		
		System.out.println(answer);
		
	}
	
	static int bingo() {
		int cnt = 0;	// 빙고 개수 세는 변수
		
		for(int i=0;i<5;i++) {			// 가로 확인
			for(int j=0;j<5;j++) {
				if(bingo[i][j]!=0) break;
				if(j==4) cnt++;
			}
		}
		
		for(int j=0;j<5;j++) {			// 세로확인
			for(int i=0;i<5;i++) {
				if(bingo[i][j]!=0) break;
				if(i==4) cnt++;
			}
		}
		
		for(int i=0;i<5;i++) {			// 오른쪽 아래 대각선
			if(bingo[i][i]!=0) break;
			if(i==4) cnt++;
		}
		
		for(int i=0;i<5;i++) {
			if(bingo[i][4-i]!=0) break; // 왼쪽 아래 대각선
			if(i==4) cnt++;
		}
		
		return cnt;
	}
	
	static void check(int num) {	// 빙고판에 체크
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(bingo[i][j]==num) bingo[i][j]=0;
			}
		}
	}
}
