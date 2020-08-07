package Swea;

import java.util.Scanner;

// 1861. 정사각형 방
public class swea_1861 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		int[] di = {-1,1,0,0};	// 상 하 좌 우
		int[] dj = {0,0,-1,1};
		
		for(int tc=1;tc<=TC;tc++) {
			
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			int[] result = new int[2];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {	// 배열 전체 탐색
					
					int si = i;			// 시작위치
					int sj = j;
					
					int ni = si;		// 현재 위치
					int nj = sj;
					
					int count = 1;
					
					boolean isBreak = false;
					while(!isBreak) {
						
						for(int d=0;d<4;d++) {	// 방향 탐색
							
							int now = arr[ni][nj];
							
							ni += di[d];
							nj += dj[d];
							
							if(ni<0 || nj<0 || ni>N-1 || nj>N-1) {
							} // 배열 범위 넘으면 원래대로
							else {
								int next = arr[ni][nj];
								if(next==now+1) {	// 1 차이나면 카운트 올리기
									count++;
									break;
								}
							}
							ni -= di[d];	// 1차이 나지 않으면 원래 위치로 돌아가야 함
							nj -= dj[d];
							if(d==3) {
								isBreak = true; // dCount가 3이되면 더이상 이동할수 없음
								ni -= di[d];
								nj -= dj[d];
							}
						} // 방향탐색 end
					} // while end
					
					// 정답 배열에 저장
					if(result[1]<count) {
						result[0] = arr[si][sj];
						result[1] = count;
					}
					if(result[1]==count) {
						if(result[0]>arr[si][sj]) {
							result[0] = arr[si][sj];
						}
					}
					
					
				} // 배열j 전체 탐색 end
			} // 배열i 전체 탐색 end
			
			System.out.println("#" + tc + " " + result[0] + " " + result[1]);
			
			
		}	// tc end

	}	// main end

}
