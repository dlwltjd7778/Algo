package Swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_디저트카페 {

	static int N, map[][], nowD, desert[], desertCnt, maxDisert;	// nowD : 현재 진행방향
	static List<Integer[]> list;
	static int[] di = {1,1,-1,-1};
	static int[] dj = {1,-1,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			} // end input
			
			// 직사각형 가로, 세로길이 뽑기
			list = new ArrayList<Integer[]>();
			answer = new Integer[2];
			select = new boolean[N];
			perm(0);
			
			maxDisert = -1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {	// 시작 위치 정하기
					// 사각형 탐색하기
					simul(i,j);
				}
			}
			System.out.println("#"+tc+" "+maxDisert);
		} // end tc
		
	} // end main
	
	private static void simul(int i, int j) {
		
		for(int s=0;s<list.size();s++) {	// 갈수 있는 만큼 가보기..?
			
			nowD = 0;
			desert = new int[101];
			desertCnt = 1; // 나부터 시작
			Integer[] dir = list.get(s);
			desert[map[i][j]] = 1;	// 디저트 체크
			
			int nowi = i;
			int nowj = j;
			
			exit:for(int c=0;c<2;c++) {	// 두번 반복
				// 행 이동
				for(int h=0;h<dir[0];h++) {
					nowi += di[nowD];
					nowj += dj[nowD];
					
					if(chkIndex(nowi,nowj) && desert[map[nowi][nowj]]==0) {
						desertCnt++;
						desert[map[nowi][nowj]]=1;
					} else {
						break exit;
					}
					
				}
				changeDir();
				
				// 열 이동?
				for(int h=0;h<dir[1];h++) {
					nowi += di[nowD];
					nowj += dj[nowD];
					
					if(nowi==i && nowj==j) break;
					
					if(chkIndex(nowi,nowj) && desert[map[nowi][nowj]]==0) {
						desertCnt++;
						desert[map[nowi][nowj]]=1;
					} else {
						break exit;
					}
				}
				changeDir();
				if(c==1) maxDisert = Math.max(maxDisert, desertCnt);
			}
		}
	}
	
	// 배열범위확인
	private static boolean chkIndex(int i, int j) {
		if(i>=0 && j>=0 && i<N && j<N) return true;
		return false;
	}

	// 방향 바꾸기 : 시계방향
	private static void changeDir() {
		if(nowD==3) nowD = 0;
		else nowD++;
	}
	
	static boolean[] select;
	static Integer[] answer;
	private static void perm(int cnt) {
		
		if(cnt==2) {
			if(answer[0]+answer[1]<=N-1) {	// 가능한 경우들 넣기
				Integer[] candidate = answer.clone();
				list.add(candidate);
			}
			return;
		}
		
		for(int i=1;i<=N-1;i++) {
			select[i] = true;
			answer[cnt] = i;
			perm(cnt+1);
			select[i] = false;
		}
	}
} // end class
