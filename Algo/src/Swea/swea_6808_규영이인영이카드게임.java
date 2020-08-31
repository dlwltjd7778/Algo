package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6808_규영이인영이카드게임 {

	
	static int[] gyu;
	static int[] in;
	static boolean[] select;	// 선택햇는지..
	static int[] nowIn;	// 지금 인영이 카드배열
	
	static int gSum =0,iSum=0;
	static int gVic = 0, iVic = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		gyu = new int[9];
		in = new int[9];
		select = new boolean[9];
		nowIn = new int[9];
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<9;i++) {
				gyu[i] = Integer.parseInt(st.nextToken());	// 규영이 카드 저장
			}
			
			gVic = 0; iVic = 0;	 // TC 초기화
			saveInYoungCard();   // 인영이 카드 저장하기
			perm(0);
			
			System.out.println("#" + tc + " " + gVic + " " + iVic);
			
		} // end testcase
		
	}
	
	
	static void perm(int cnt) {
		
		if(cnt==9) {
			gSum =0; iSum=0;
			for(int i=0;i<9;i++) {
				
				if(gyu[i] - nowIn[i] > 0) {
					gSum += gyu[i] + nowIn[i];
				} 
				if(gyu[i] - nowIn[i] < 0) {
					iSum += gyu[i] + nowIn[i];
				} 
			}

			if(gSum > iSum) gVic++;
			if(gSum < iSum) iVic++;
			return;
		}
		
		for(int i=0;i<9;i++) {
			
			if(select[i]) continue;
			
			select[i] = true;
			nowIn[cnt] = in[i];
			perm(cnt+1);
			select[i] = false;
		}
	}
	
	static void saveInYoungCard() { // 인영이 카드저장

		int idx = 0;
		boolean isGo = true;
		for(int i=1;i<=18;i++) {
			isGo = true;
			for(int j=0;j<9;j++) {
				if(gyu[j]==i) {
					isGo = false;
					break;
				}
			}
			if(isGo) {
				in[idx]=i;
				idx++;
			}
		}
	}
}
