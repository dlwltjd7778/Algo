package Swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 가지치기는 나중에 하기.. 베이스 코드가 잘 작성된 이후에서..


public class swea_1767_프로세서연결하기_교수님풀이{
	

	static int TC,N;
	static int[][] map;
	static int max, min, totalCnt;	// 코어 최대갯수, 연결하는 전선길이, 처리할 코어 수
	static ArrayList<int[]> list;	// 처리해야할 가장자리가 아닌 코어들을 저장할 리스트
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if((i==0 || j==0 || i==N-1 || j==N-1) && map[i][j]==1) continue;	// 가장자리에 있는 코어는 리스트에 추가 x
					
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++;	// 관리해야할 코어 개수 증가하기
					}
				}
			} // end input
			
			go(0,0,0);
			System.out.println("#" + tc + " " + min);
			
		}
	}
	
	static void go(int index, int cCnt, int lCnt) {	// 처리할 코어의 인덱스, cCnt : 직전까지 포함된 코어수, lCnt : 연결된 전선의 길이
		
		// 현재까지 연결된 코어수 + 앞으로 처리해야할 남은 코어수 : 기대할 수 있는 최대 코어 수
		// 최대 코어수가 임시해보다 작다면 진행이 의미 없음
		if(cCnt + totalCnt-index < max) return;  // 가지치기
		
		if(index == totalCnt) {		// 기저조건
			if(max<cCnt) {
				max = cCnt;
				min = lCnt;
			} else if(max==cCnt) { 	// 최대 코어갯수가 같다면 최소길이의 전선으로..
				if(min>lCnt) {
					min = lCnt;
				}
			}
			
			return;
		}
		
		int[] nowCore = list.get(index);
		int i = nowCore[0];
		int j = nowCore[1];
		
		// 해당 코어 선택
		//	> 4방향의 직선으로 전선 놓아보는 시도
		
		for (int d = 0; d < 4; d++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			if(isAvaliable(i, j, d)) {
				// 가능하다면 전선 놓기! : 멕시노스 판에 2로  셋팅하기
				int len = setStatus(i, j, d, 2);
				// 다음 코어로 넘어가기
				go(index+1, cCnt+1, lCnt + len);
				// 놓았던 전선 지우기(되돌리기) : 멕시노스 판에 0으로 셋팅
				setStatus(i, j, d, 0);
			}
				
		}
		
		// 해당 코어 비선택
		// > 아무런 전선도 놓지 않고 다음 코어로 넘어가기
		go(index+1, cCnt, lCnt);
	}
	
	static int setStatus(int i, int j, int d, int s) {	// 행,열,방향,상태값(2면 전선으로, 0으면 원래대로 되돌리기)

		int ni = i, nj = j;
		int cnt = 0;	// 전선길이 세기
		while (true) { // 가장자리까지 가보기
			ni += di[d];
			nj += dj[d];
			if(ni<0 || nj<0 || ni>N-1 || nj>N-1) break;	// 가장자리까지 다 전선을 놓을수 있는 상황이라서 반복문 빠져나옴
			map[ni][nj] = s;
			++cnt;
		}
		return cnt;
	}
	
	// 현 코어의 위치에서 해당 방향으로 전선 놓는게 가능한지 체크
	static boolean isAvaliable(int i, int j, int d) {
		
		int ni=i, nj=j;
		
		while(true) {		// 가장자리까지 가보기
			ni += di[d];
			nj += dj[d];
			
			if(ni<0 || nj<0 || ni>N-1 || nj>N-1) break;	// 가장자리까지 다 전선을 놓을수 있는 상황이라서 반복문 빠져나옴
			
			if(map[ni][nj]>=1) return false;	// 1이면 코어, 2면 전선
			
		}
		return true;
	}
	
	
}