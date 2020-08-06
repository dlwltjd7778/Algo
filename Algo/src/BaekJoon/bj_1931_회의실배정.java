package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1931_회의실배정 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	// 회의 개수
		Time[] timeList = new Time[N];				// 회의 정보 담은 배열 생성
		
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());	// 시작시간 저장
			int end = Integer.parseInt(st.nextToken());		// 끝시간 저장
			timeList[n] = new Time(start, end);				// 각각 리스트에 저장
		}
		
		Arrays.sort(timeList);	// 시간표를 끝시간이 빠른 순으로 저장
		
		int nowEnd = timeList[0].end;
		int count = 1;					// 가능한 회의 개수
		for(int n=1;n<N;n++) {			
			if(nowEnd <= timeList[n].start) {	// 이전 회의가 끝나는 시간이
				nowEnd = timeList[n].end;		// 현재 시작시간보다 작거나 같다면 nowEnd갱신
				count++;
			}
		}
		System.out.print(count);
		
		
	} // main end
	
	// 회의실 시간 정보 저장하는 Time class
	static class Time implements Comparable<Time>{
		int start, end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			
			if(this.end==o.end) {
				return Integer.compare(this.start, o.start);
			}
			return Integer.compare(this.end, o.end);
		}
		
	} // Time class end


} // class end
