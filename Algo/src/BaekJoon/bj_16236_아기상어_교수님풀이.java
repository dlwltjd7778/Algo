package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_16236_아기상어_교수님풀이 {
	static int[][] map;
	static int shark_i, shark_j, shark_w, shark_eat; // 상어위치, 상어현재몸무게, 먹은 먹이의 갯수
	static int ans; // 상어는 더이상 먹을 수 없어질 때까지 몇초나 살아남는지?!
	static int N;
	
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == 9) { // 상어의 초기위치다!
					shark_i = i;
					shark_j = j;
					shark_w = 2; // 초기 몸무게 2
					shark_eat = 0; // 먹이는 못먹은 상태.
				}
			}
		}// 입력 끝
		
		while(true) { // 먹이를 찾아 다니는 작업을 반복
			//먹을수 있는 먹이를 찾아보자. 현재 상어위치에서 bfs 탐색을 해보자.
			Queue<Point> queue = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];
			
			queue.add(new Point(shark_i, shark_j));
			visit[shark_i][shark_j]=true;
			
			int feedi = N, feedj=N; // 먹이를 찾으면 먹이의 좌표값이 저장될거고. 먹이가 여러개라면 그중 위(작은 i) 그중 왼쪽(작은 j) 좌표로 갱신.
			int dist=0; // 상어 출발해서 먹이 찾을때까지의 거리 저장
			boolean isEat = false;
			while(!queue.isEmpty()) {
				int size = queue.size();
				
				for(int s=0; s<size; s++) {
					Point now = queue.poll(); // 현재 상어가 이동가능한 좌표
					
					for(int d=0; d<4; d++) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						
						if(ni>=0 && ni<N && nj>=0 && nj<N && (shark_w>map[ni][nj] && map[ni][nj]>0)&&!visit[ni][nj]) { 
							// 먹이를 찾은경우(상어크기보다 작고 빈칸이 아닌경우!)
							visit[ni][nj] = true;
							if(feedi > ni) { // 새로운 먹이 좌표 ni, nj가 일단 ni 기준 더 위에 있다!
								feedi = ni;
								feedj = nj;
							}else if(feedi == ni && feedj > nj) { // 더 위는 아니고 같은 높이에 j가 더 왼쪽이야!
								feedj = nj;
							}
						}else if(ni>=0 && ni<N && nj>=0 && nj<N && (shark_w==map[ni][nj] || map[ni][nj]==0)&&!visit[ni][nj]) { // 먹이는 아니지만 이동은 가능한 좌표?
							// 먹이가 아닌데 이동가능하다? 상어랑 크기가 같거나 빈칸
							visit[ni][nj] = true;
							queue.add(new Point(ni, nj));
						}
					}
				}// 출발점에서 같은 거리의 좌표 탐색 완료
				dist++; 
				// 먹이가 있는경우
				if(feedi<N && feedj<N) {
					map[shark_i][shark_j] = 0; // 상어는 현재위치에서 떠날거임. 있던 칸은 빈칸!
					shark_i = feedi;
					shark_j = feedj;
					shark_eat++;
					if(shark_eat == shark_w) { // 오 현재 몸무게만큼 먹이 먹었네? 상어 성장!
						shark_eat = 0;
						shark_w++;
					}
					ans += dist; // 현재 먹이먹으러 이동한 거리만큼 상어는 살아있었음.
					isEat = true;
					break; // 상어 출발 탐색하다가 먹이 찾았으면 상어위치 변경되었으므로 새로운 탐색 들어가야함.
				}
			} // 상어 위치에서 탐색이 끝났음.
			// 먹이가 없는경우
			if(!isEat) {
				break;
			}
		} // 먹이 먹으면서 돌아다니는 while
		System.out.println(ans);
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}