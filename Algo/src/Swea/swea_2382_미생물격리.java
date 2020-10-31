package Swea;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class swea_2382_미생물격리 {

	static int TC, N, M, K;	// 테스트케이스, 배열크기, 시간, 군집수
	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,-1,1};	// 상, 하, 좌, 우 ( 1,2,3,4)
	static List<Community> commList;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		for(int tc=1;tc<=TC;tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			commList = new LinkedList<Community>();
		
			
			for(int k=0;k<K;k++) {	// 군집 리스트 정보 저장
				int i = sc.nextInt();
				int j = sc.nextInt();
				Community comm = new Community(N*i+j,i,j, sc.nextInt(), sc.nextInt());
				commList.add(comm);
			}
		
			
			for(int m=0;m<M;m++) {	// m번 반복
				int size = commList.size();
				for(int i=0;i<size;i++) {
					simul(commList.get(i), i);
				}
				
				
				Collections.sort(commList);
				
				for(int i=0;i<commList.size()-1;i++) {
					if(commList.get(i).num==commList.get(i+1).num) {
						Community com = commList.get(i);
						com.cnt += commList.get(i+1).cnt;
						commList.set(i, com);
						commList.remove(i+1);
						i--;
					}
				}

			} // m번 반복 끝
			
			int answer = 0;
			
			Iterator<Community> itr = commList.iterator();	// 군집 리스트 정보저장
			while(itr.hasNext()) {
				answer += itr.next().cnt;
			}
			System.out.println("#" + tc + " " + answer);
			
			
			
		} // end tc
	} // end main
	
	static void simul(Community comm, int idx) {
		int num, ni, nj, cnt, direction;
		
		// 방향 이동
		
		ni = comm.i + di[comm.direction];
		nj = comm.j + dj[comm.direction];
		cnt = comm.cnt;
		direction = comm.direction;
		
		if(ni ==0 || nj==0 || ni==N-1 || nj==N-1) {
			if(direction==1) direction = 2;
			else if(direction==2) direction = 1;
			else if(direction==3) direction = 4;
			else direction = 3;
			cnt = comm.cnt/2;	// 방향 전환 & 미생물수 줄이기
		}
		num = N*ni+nj;
		Community result = new Community(num, ni, nj, cnt, direction);
		commList.set(idx, result);
	}
	
	static class Community implements Comparable<Community>{
		int num;	// 칸 번호
		int i,j;	// 군집 좌표
		int cnt, direction;	// 군집 미생물개수, 진행방향
		public Community(int num, int i, int j, int cnt, int direction) {
			this.num = num;
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.direction = direction;
		}
		@Override
		public String toString() {
			return "[" +num+","+ i + "," + j + "," + cnt + "," + direction + "]";
		}
		@Override
		public int compareTo(Community o) {
			if(this.num==o.num) {
				return o.cnt-this.cnt;
			}
			return this.num-o.num;
		}
	}
}
