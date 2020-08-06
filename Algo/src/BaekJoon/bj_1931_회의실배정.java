package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1931_ȸ�ǽǹ��� {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());	// ȸ�� ����
		Time[] timeList = new Time[N];				// ȸ�� ���� ���� �迭 ����
		
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());	// ���۽ð� ����
			int end = Integer.parseInt(st.nextToken());		// ���ð� ����
			timeList[n] = new Time(start, end);				// ���� ����Ʈ�� ����
		}
		
		Arrays.sort(timeList);	// �ð�ǥ�� ���ð��� ���� ������ ����
		
		int nowEnd = timeList[0].end;
		int count = 1;					// ������ ȸ�� ����
		for(int n=1;n<N;n++) {			
			if(nowEnd <= timeList[n].start) {	// ���� ȸ�ǰ� ������ �ð���
				nowEnd = timeList[n].end;		// ���� ���۽ð����� �۰ų� ���ٸ� nowEnd����
				count++;
			}
		}
		System.out.print(count);
		
		
	} // main end
	
	// ȸ�ǽ� �ð� ���� �����ϴ� Time class
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
