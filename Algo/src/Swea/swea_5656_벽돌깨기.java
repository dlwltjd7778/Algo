package Swea;

import java.util.Scanner;

public class swea_5656_벽돌깨기 {

	static int N,W,H,count,tmpCnt,min;
	static int map[][], tmpMap[][];
	static int[] select;
	static boolean[] visit;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			count = 0;	// 현재 벽돌개수
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]>0) count++;
				}
			} // end input
			
			select = new int[N];
			visit = new boolean[W];
			min = count;
			
			perm(0);
			
			System.out.println("#" + tc+ " " + min);
		} // end tc
	} // end main
	
	
	// 일단 공을 던질 위치인 열의 조합을 뽑는다.
	private static void perm(int cnt) {
		if(cnt==N) {
			tmpMap = new int[H][W];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					tmpMap[i][j] = map[i][j];
				}
			} // 등록
			for(int c=0;c<N;c++) {
				int i = findH(select[c]); // 처음 시작하는 벽돌(숫자)의 행값이 뭔지 return해준다
				play(i,select[c]);	// 벽돌을 부시자
				sort();	// 아래로 정렬
			}
			int tmpCnt = count();
			min = Math.min(min,tmpCnt);
			return;
		}
		for(int i=0;i<W;i++) {
			
			visit[i] = true;
			select[cnt] = i;
			perm(cnt+1);
			visit[i] = false;
		}	
	}
	private static int count() {
		int result=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(tmpMap[i][j]>0)
					result++;
			}
		}
		return result;
	}
	
	// 깨진 벽돌 아래로 정렬하기
	private static void sort() {
		for(int j=0;j<W;j++) {
			int[] tmpArr = new int[H];
			int idx = H-1;
			for(int i=H-1;i>=0;i--) {
				if(tmpMap[i][j]!=0) {
					tmpArr[idx]=tmpMap[i][j];
					idx--;
				}
			}
			for(int i=0;i<H;i++) {
				tmpMap[i][j] = tmpArr[i];
			}
		}
	}
	// 배열 범위 확인
	static boolean chkArr(int i,int j){
		if(i>=0 && j>=0 && i<H && j<W) {
			return true;
		}
		return false;
	}
	
	// 벽돌 깨기!
	private static void play(int nowi, int nowj) {
		int cnt = tmpMap[nowi][nowj];
		tmpMap[nowi][nowj] = 0;
		for(int i=nowi+1;i<nowi+cnt;i++) {
			if(chkArr(i,nowj)) {
				if(tmpMap[i][nowj]==1) {
					tmpMap[i][nowj] = 0;
					tmpCnt--;
				} else if(tmpMap[i][nowj]==0) continue;
				else {
					play(i,nowj);
				}
			} else {
				break;
			}
		}
		for(int i=nowi-1;i>nowi-cnt;i--) {
			if(chkArr(i,nowj)) {
				if(tmpMap[i][nowj]==1) {
					tmpMap[i][nowj] = 0;
					tmpCnt--;
				} else if(tmpMap[i][nowj]==0) continue;
				else {
					play(i,nowj);
				}
			} else {
				break;
			}
		}
		for(int j=nowj+1;j<nowj+cnt;j++) {
			if(chkArr(nowi,j)) {
				if(tmpMap[nowi][j]==1) {
					tmpMap[nowi][j] = 0;
					tmpCnt--;
				} else if(tmpMap[nowi][j]==0) continue;
				else {
					play(nowi,j);
				}
			} else {
				break;
			}
		}
		for(int j=nowj-1;j>nowj-cnt;j--) {
			if(chkArr(nowi,j)) {
				if(tmpMap[nowi][j]==1) {
					tmpMap[nowi][j] = 0;
					tmpCnt--;
				} else if(tmpMap[nowi][j]==0) continue;
				else {
					play(nowi,j);
				}
			} else {
				break;
			}
		}
		
	}

	// 처음 시작하는 벽돌(숫자)의 행값이 뭔지 return해준다
	private static int findH(int j) {
		for(int i=0;i<H;i++) {
			if(tmpMap[i][j]!=0)
				return i;
		}
		return 0;
	}
	
} // end class
