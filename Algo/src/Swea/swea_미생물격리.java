package Swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class swea_미생물격리 {

	static int TC, N, M, K;	// 테스트케이스, 배열크기, 시간, 군집수
	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,-1,1};	// 상, 하, 좌, 우 ( 1,2,3,4)
	static List<Community>[][] map;
	static List<Community> commList;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			map = new ArrayList[N][N];
			commList = new LinkedList<Community>();
		
			
			for(int k=0;k<K;k++) {	// 군집 리스트 정보 저장
				Community comm = new Community(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				commList.add(comm);
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = new ArrayList<>();	// 각 배열에 저장할 어레이리스트 생성
				}
			}
			
			for(int m=0;m<M;m++) {	// m번 반복
				int size = commList.size();
				for(int i=0;i<size;i++) {
					simul(commList.get(0));
					commList.remove(0);
				}
				for(int i=0;i<commList.size();i++) {
					Community nowC = commList.get(i);
					Collections.sort(map[nowC.i][nowC.j]); // 큰순으로 정렬
					Community c = map[nowC.i][nowC.j].get(0);	// 미생물 수 가장 큰 군집..
					int ci = c.i;
					int cj = c.j;	// 제일 군집이 많은..
					int cd = c.direction;
					int cc = c.cnt;
					for(int j=1;j<map[nowC.i][nowC.j].size();j++) {
						cc += map[nowC.i][nowC.j].get(i).cnt;	// 갯수 더해줌
					}
					map[nowC.i][nowC.j].clear(); // 다 지우기
					map[nowC.i][nowC.j].add(new Community(ci, cj, cc, cd));
									
				}

				
			} // m번 반복 끝
			
			int answer = 0;
			
			Iterator<Community> itr = commList.iterator();	// 군집 리스트 정보저장
			while(itr.hasNext()) {
				answer += itr.next().cnt;
			}
			System.out.println(answer);
			
			
			
		} // end tc
	} // end main
	
	static void simul(Community comm) {
		int ni, nj, cnt, direction;
		
		// 방향 이동
		ni = comm.i + di[comm.direction];
		nj = comm.j + dj[comm.direction];
		cnt = comm.cnt;
		direction = comm.direction;
		
		if(comm.i ==0 || comm.j==0 || comm.i==N-1 || comm.j==N-1) {
			if(comm.direction==1) direction = 2;
			else if(comm.direction==2) direction = 1;
			else if(comm.direction==3) direction = 4;
			else direction = 3;
			cnt = comm.cnt/2;	// 방향 전환 & 미생물수 줄이기
		}
		
		Community result = new Community(ni, nj, cnt, direction);
		
		for(int i=0;i<map[comm.i][comm.j].size();i++) {
			Community tmp = map[comm.i][comm.j].get(i);
			if(tmp.cnt==comm.cnt && tmp.direction==comm.direction) {
				map[comm.i][comm.j].remove(i);
				i--;
			}
		}
		
		
		commList.add(result);
		map[ni][nj].add(result);
	}
	
	static class Community implements Comparable<Community>{
		int i,j;	// 군집 좌표
		int cnt, direction;	// 군집 미생물개수, 진행방향
		public Community(int i, int j, int cnt, int direction) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.direction = direction;
		}
		@Override
		public String toString() {
			return "[" + i + "," + j + "," + cnt + "," + direction + "]";
		}
		@Override
		public int compareTo(Community o) {
			return o.direction-this.direction;
		}
	}
}
