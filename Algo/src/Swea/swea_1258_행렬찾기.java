package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_1258_행렬찾기 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N;						// 배열 크기
	static int[][] container;			// 컨테이너 배열
	static boolean[][] visit;			// 방문확인 배열
	static ArrayList<SubMatrix> list;	// 정답배열 리스트
	
	static int[] di = {0,1};	// 오른쪽, 아래
	static int[] dj = {1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			N = Integer.parseInt(br.readLine());
			container = new int[N][N];
			visit = new boolean[N][N];
			list = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++) {
					container[i][j] = Integer.parseInt(st.nextToken());
				}
			}	//  입력 end
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(container[i][j]!=0 && !visit[i][j]) {	// 시작점 체크, container[i][j]가 0이 아닌 경우만 들어옴
																
						int H = 0;	// 행 정보
						int W = 0;	// 열 정보
						boolean chkW = true;
						
						for(int ni=i;ni<N;ni++) {
							for(int nj=j;nj<N;nj++) {
								if(container[ni][nj]!=0 && !visit[ni][nj]) {
									visit[ni][nj] = true;
									if(chkW) W++;
									if(nj==N-1) chkW = false;
								} else {
									chkW = false;
									break;
								}
							}
							if(container[ni][j]==0 || ni==N-1) break;
							H++;
						}
						
						list.add(new SubMatrix(H, W));
					}
				}
			}
			
			Collections.sort(list);
			
		    System.out.print("#" + tc + " " + list.size() + " ");
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			
			
			
			
			
			
		} // tc end
	} // main end
	
	
	
	// 부분행렬 크기를 나타내는 클래스
	static class SubMatrix implements Comparable<SubMatrix>{
		int H,W;

		public SubMatrix(int H, int W) {
			this.H = H;
			this.W = W;
		}

		@Override
		public int compareTo(SubMatrix o) {
			if(this.H*this.W== o.H*o.W)	// 행열 곱의 크기가 같을 경우에는 행이 작은 순으로 정렬!
				return this.H - o.H;
			return Integer.compare(this.H*this.W, o.H*o.W);
		}

		@Override
		public String toString() {
			return  H + " " + W ;
		}
		
	} // SubMatrix class end
}
