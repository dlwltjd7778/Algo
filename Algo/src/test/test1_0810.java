package test;

import java.util.Scanner;

public class test1_0810 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	// 입력받기 위해 스캐너 선언!
		
		String str = sc.nextLine();		// 주어지는 문장 저장하는 str 변수
		int num = sc.nextInt();			// 1이면 모음적용, 2이면 ssafy 적용
		
		boolean[] visit = new boolean[str.length()]; 	// 문자열을 확인 했는지 체크하는 visit 배열
		boolean findSuccess;	// 숨겨진 문자 찾았는지 확인하는 변수
		String ans = "";		// 정답 문자열 변수
		
		for(int i=0;i<str.length();i++) {	// 주어진 str값의 문자를 하나씩 탐색
			char al = str.charAt(i);		// 현재 위치의 알파벳
			findSuccess = false;
			if(visit[i]) continue;
			if(al=='p' && !visit[i]) {	// 만약 이번 문자가 p이고 방문하지 않았다면,
						
				int li = i - 1;		// 현재 문자열 위치의 왼쪽을 확인 (lefti)
				int ri = i + 1;		// 현재 문자열 위치의 오른쪽을 확인(righti)
				
				if (li >= 0 && ri <= str.length() - 1 && !visit[li] && !visit[ri]) {	// 인덱스가 범위안에 포함되고,	
					if(str.charAt(li)==str.charAt(ri)) {	// 왼쪽과 오른쪽이 같고,
						if(num==1 && chk1(str.charAt(li))) {		// 선택번호인 num이 1이고 그 문자가 모음이라면,
							visit[li] = true;						
							visit[i] = true;						// 탐색한 세개의 문자를 방문처리 한다.		
							visit[ri] = true;
							findSuccess = true;						// 암호 찾기에 성공했다고 상태 바꿔준다.
							
						} else if(num==2 && chk2(str.charAt(li))) { // 선택번호인 num이 2이고 그 문자가 safy이라면,
							visit[li] = true;						
							visit[i] = true;						// 탐색한 세개의 문자를 방문처리 한다.
							visit[ri] = true;
							findSuccess = true;						// 암호 찾기에 성공했다고 상태 바꿔준다.
						}
					}
				}
				if(!findSuccess) ans += al;	// if문 안에 들어왔지만 실패할 경우에는 그냥 현재 문자를 더해준다.
			} else {
				ans += al;	// 아무 경우도 아닐 경우에도 정답에 현재 문자를 더해준다.
			}
		}

		System.out.println(ans);	// 정답 출력
		
	} // main end
	
	// 현재 들어온 문자가 모음인지 체크하는 chk1 함수
	static boolean chk1 (char a) {
		if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u') {	// 모음에 해당된다면 
			return true;										// true 반환
		}
		return false;											// 아니면 false 반환
	} //chk1 end
	
	// 현재 들어온 문자가 safy인지 체크하는 chk2함수
	static boolean chk2 (char a) {
		if(a=='s' || a=='a' || a=='f' || a=='y') {	// safy에 해당된다면 
			return true;							// true 반환
		}
		return false;								// 아니면 false 반환
	} //chk2 end
	
}
