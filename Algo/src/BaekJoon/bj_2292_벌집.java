package BaekJoon;

import java.util.*;
public class bj_2292_벌집 {
	public static int execute(int N) {
		
		
		// 구현하세요.
		// 1번방으로부터 거리가 1인 방은 7번 방 까지이고, 거리가 2인 방은 19번 까지이고, 거리가 3인 방은 37번까지..이다
		// 1 7 19 37 ... 순으로 거리가 같은 방의 마지막 번호가 증가하고,
		// 이들의 차이는 6의 배수만큼 커진다.
		
		int count = 1;	// 1에서 N까지 도달할 최소거리
		int num = 1;	// 6에 곱해줄 숫자
		
		for(int i=1;i<=N;i++) {
			num += 6*i;		// 6의 배수 만큼 방의 마지막 번호가 증가한다.
			if(num>=N) {	// 찾는 방번호(N)이 현재 마지막 방 벙호보다 작아지면, 이번 반복에서 방을 지나갈 수 있게 된 것
				count += i; // 현재 반복 횟수가 거리와 같으므로 더해준다.
				break;
			}
		}
		if(N==1) return 1;	// N이 1이라면 답은 1이다(예외)
		
		return count; // 정답 return
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
		System.out.println(execute(N)); // 3
	}

}
