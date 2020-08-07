package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2493_ans {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		int[] tower = new int[size+1];	// 탑 번호 인덱스로 활용하기 위해 크기 +1 (0번 인덱스는 안씀)
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=size;i++) {									// idx 0 1 2 3 4 5
			tower[i] = Integer.parseInt(st.nextToken());			// 현재   0 6 9 5 7 4   로 들어감
		}													
		
		int[] stack = new int[size];			// 스택에 타워 높이가 아닌 타워 번호 넣을 것임
		int top = 0;
		
		StringBuilder sb = new StringBuilder();	// 출력 위한
		
		for(int i=1; i<=size; i++) {	// 왼쪽 1번 타워부터 순차적으로 살펴보면서
			
			while(top>0 && tower[stack[top-1]] <= tower[i]) {	// 스택에 현재 i보다 낮은 타워는 
				stack[top-1] = 0; //  스택에서 빼버림.. 현재 i타워의 레이저도 못받고 앞으로도 못받는 애들임
				top--;
			}
			
			sb.append((top>0?stack[top-1]:0) + " ");	// 스택이 비었으면 0, 아니면 남은 타워(나보다 높은 타워)가
			stack[top] = i;	// 현재 타워도 이후 타워들의 레이저 받을 가능성 있으니까 일단 스택에 push
			top++;
		}
		System.out.println(sb.toString());
		

	}

}
