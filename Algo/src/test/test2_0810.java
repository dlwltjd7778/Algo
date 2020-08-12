package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// dfs 풀면 시간초과 날 확률이 매~~~우 큰 문제!!!
// bfs 로 푸는 것이 좋을듯..


public class test2_0810 {

	static int[] di = { -1,1,0,0};	// 좌, 우, 상, 하 로 이동할 수 있는 델타
	static int[] dj = { 0,0,-1,1};
	
	static BufferedReader br;		// 입력 관련.
	static StringTokenizer st;
	static int N,M;				// 열, 행
	static int[][] map; 		// 미로
	static boolean[][] visit;	// 방문 처리할 배열
	static ArrayList<Point> al;	// 정답 후보 추가할 arrayList
	static int count = 0;	// 1 개수 세기
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];	// 미로 배열 선언
		al = new ArrayList<Point>();
		
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			char[] tempChar = new char[N];
			tempChar = temp.toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = tempChar[j]-'0';
			}
		} // 입력 end
		
		
		/*
		>> 생각한 로직 
		 현재 내 위치에서 상,하,좌,우를 탐색하여 dfs로 n,m의 위치까지 간다.
		 지나간 곳은 boolean visit 배열을 생성하여 true 처리한다.
		 가면서 1을 만나면 그 개수를 세고, arraylist에 추가한다.
		 모든 경우의 수를 다 세고, 가장 1의 개수가 적었던 길을 출력한다.	
		 
		 오류 해결 못한 채로 제출할 것 같습니다..ㅠㅠ
		 
		 */
		
		dfs(0,0);
		Collections.sort(al);
		System.out.println(al.get(0)); // 정답 출력
		
		
	} // main end

	static Point p = null;
	static void dfs(int i, int j) {
		if(i==M-1 && j==N-1) {	// 현재 내 위치가 N,M에 도달하면
			al.add(p);			// list에 1 개수를 저장하고
			count = 0;			// 카운트 초기화 해준다..?	
								// 이게 아니라 point class 만들어서 안에 좌표 정보와 카운트 정보 만들어야 할 것 같습니다.ㅡ.ㅠㅠ
			return;				// 리턴
		}
	
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(ni>=0 && nj >=0 && ni<M && nj<N && !visit[ni][nj]) {
				if(map[ni][nj]==1) {
					p = new Point(ni, nj, count+1);
					dfs(ni,nj);
				}
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int i,j;
		int count;
		public Point(int i, int j, int count) {
			this.i = i;
			this.j = j;
			this.count = count;
		}
		@Override
		public int compareTo(Point o) {
			return this.count - o.count;
		}
		
	}
}
