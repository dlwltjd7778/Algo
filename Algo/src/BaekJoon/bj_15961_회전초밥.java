package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_15961_회전초밥 {

	static int N,d,k,c;	// 접시수, 초밥가짓수, 연속접시수, 쿠폰번호
	static int[] sushi;	// 벨트에 올라가는 초밥 리스트
	static int[] eat;		// 고객이 먹는 초밥 번호를 인덱스로 가지는 배열
	static int max;					// 먹을수 있는 가지수 최댓값
	static int cnt;					// 먹을수 있는 가지수
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		eat = new int[d+1];	// 0번 초밥은 없음..
		max = 0;
		for(int i=0;i<N;i++) {	// 벨트에 올라가는 접시 수만큼 
			sushi[i] = (Integer.parseInt(br.readLine()));
		} // end input
		
		eat[c]++;	// 먹을 수 있는 서비스 초밥 번호 늘려준다.
		
		for(int i=0;i<k;i++) {
			eat[sushi[i]]++;
		}
		
		for(int i=0;i<d+1;i++) {
			if(eat[i]!=0) cnt++;	// 초기값으로 cnt에 먹을수있는 가짓수 넣어준다.
		}
		
		for(int i=0;i<N;i++) {	// 벨트에 있는 현재 첫번째 초밥을 맨뒤로 보내는거 N번 반복
			
			eat[sushi[i]]--;
			if(eat[sushi[i]]==0) cnt--;
			
			if(eat[sushi[(i+k)%N]]==0) cnt++;
			eat[sushi[(i+k)%N]]++;
			
			if(max<cnt) max = cnt;
			
		}
		
		System.out.println(max);
		
		
		
	}
}
