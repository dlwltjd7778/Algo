package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17471_게리맨더링 {

	// 로직..
	// 1. 구역들을 부분집합으로 뽑는다 > 아예안뽑기, 다뽑기는 제외
	// 2. 각 뽑힌 집합들이 서로 연결되어 있는지, 다 연결되어있다면 인구수를 더해주기 및 3번 진행, 연결안되면 다음 부분집합으로 넘어간다..
	// 3. 두 선거구의 차를 구해서 현재 값보다 최소면 갱신한다..
	
	static int N;	// 지역 수
	static int[] areaPopulation;	// 지역번호 : idx, 값 : 인구 수
	static int[][] info;			// 연결 정보를 담는 2차원 배열 : 행 : 지역번호, 열 : 각 연결 정보
	
	static boolean[] select;		// 뽑았는지 안뽑았는지 확인하는 배열
	static int min;					// 정답  min
	static int[] parents;	// 유니온파인드 연산 위한 부모 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		
		areaPopulation = new int[N+1];	// 0번 지역은 없으므로..
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			areaPopulation[i] = Integer.parseInt(st.nextToken());
		} // 인구 수 받아옴
		
		info = new int[N+1][];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			info[i] = new int[Integer.parseInt(st.nextToken())];
			for(int j=0;j<info[i].length;j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input end
		
		select = new boolean[N+1];
		parents = new int[N+1];
		min = Integer.MAX_VALUE;
		
		powerSet(1);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
	}
	
	//static int count = 0;
	static void powerSet(int cnt) { // 지역들의 부분집합 뽑기..
		
		if(cnt==N+1) {	// cnt는 1부터 시작해서 N+1..?

// 			// 시간에 별 차이 없음.. 빼버려도 될듯 > 어짜피 밑에서 걸러줌..
//			count++;
//			if(count==1 || count == Math.pow(2, N) ) {	//  전부 다 뽑는 경우와 하나도 안뽑는 경우는 제외한다..
//				return;
//			}
			
			chkConnect(select);
			
			return;
		}
		
		select[cnt] = true;
		powerSet(cnt+1);
		select[cnt] = false;
		powerSet(cnt+1);
	}
	
	static void chkConnect(boolean[] select) {	// 각 구역들이 연결되어있는지 확인..
		
		make();
		
		for(int i=1;i<=N;i++) {
			if(select[i]) {	
				for(int j=0;j<info[i].length;j++) {
					if(select[info[i][j]]) {	// 연결하려는 지역이 우리 지역이면	( true인 지역 )
						union(i,info[i][j]);	// 내 지역이랑 나랑 연결된 지역이랑 union
					}
				}
				
			} else {
				for(int j=0;j<info[i].length;j++) {
					if(!select[info[i][j]]) {	// 연결하려는 지역이 우리 지역이면 ( false인 지역 )
						union(i,info[i][j]);	// 내 지역이랑 나랑 연결된 지역이랑 union
					}
				}
			}
		}
		
		int parentsCnt = 0; // 자기 자신이 부모인 경우가 몇개인지
		for(int i=1;i<=N;i++) {
			if(parents[i] == i) parentsCnt++;	// 자기 자신이 부모인 경우가 몇개인지..? > 총 선거구가 몇개 나오는지..
		}
		
		int sumA = 0, sumB = 0;
		if(parentsCnt==2) {						// 두개인 경우만 가능하다
			for(int i=1;i<=N;i++) {
				if(select[i]) {
					sumA += areaPopulation[i];
				} else {
					sumB += areaPopulation[i];
				}
			}
			min = Math.min(min, Math.abs(sumA-sumB));	// 최솟값 저장
		}
		
		
		
	}
	
	////////////////////// union - find 위한 메소드들 ////////////////
	static void make() {
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i] = i;			// 일단 모든 정점들을 자신의 부모로..
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
//////////////////////////////////////////////////////////////////

	

}
