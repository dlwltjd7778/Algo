package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_17135_캐슬디펜스 {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	
	static ArrayList<Integer[]> AttackDisList = new ArrayList<Integer[]>();	// 공격 가능 거리 범위 리스트
	static ArrayList<Integer[]> AttackPointList = new ArrayList<Integer[]>();	// 궁수 가능 위치 리스트
	static int[] dj = {-1,1};	// 왼쪽, 오른쪽 ( di는 항상 -1 )
	
	static int N,M,D;	// 행,열,공격가능거리
	
	static Integer[] combNum;		// 궁수 선택된 위치 담을 배열
	static int[] permInput;		// 공격 가능 범위 숫자 1부터 D까지
	static Integer[] m;
	static int[] permNum;		// 공격 가능한 i,j 에 곱해질 숫자 선택한 배열
	
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];	// 맨아래 행에 성 추가
		combNum = new Integer[3];	// 궁수자리  뽑는 배열
		m = new Integer[2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 end
		
		comb(0,0);			// 궁수 위치 뽑기
		
		
		for(Integer[] ap : AttackPointList) {	// 궁수 뽑은 후 각 경우마다 케이스 돌기
			
			map[N+1][ap[0]] = -1;
			map[N+1][ap[1]] = -1;	
			map[N+1][ap[2]] = -1;		// 궁수 위치 표시
			
			for(int d=1;d<=D;d++) {		// D가 1일때부터 가까운 공격위치 찾기 위해서
				AttackDisList.clear();	// 초기화
				selectDistance(d);		// 공격 거리 조합 뽑기	> D=1인 경우 예외임 앞으로만 쏠수있음
				
				for(Integer[] ad : AttackDisList) {
					
					int mi = ad[0];	// i에 곱해질 가중치
					int mj = ad[1];	// j에 곱해질 가중치
					
					
						
						
				}
				
				
			} // 공격거리 증감문 end
		} // AttackPointList end
	}

	// 궁수 인덱스 위치 뽑는 조합(M개중 3개)
	static void comb(int cnt, int idx) {
		
		if(cnt==3) {
			AttackPointList.add(combNum);	// 뽑아서 리스트에 넣어준다.
			return;
		}
		for(int i=idx;i<M;i++) {
			combNum[cnt] = i;
			comb(cnt+1,i+1);
		}
	} // comb end
	
	// 공격 거리 i와j의 비율을 뽑는 함수
	static void selectDistance(int d) {
		for(int i=1;i<=d;i++) {
			m[0] = i;
			m[1] = d-i;
			AttackDisList.add(m);
		}
		
	}

}
