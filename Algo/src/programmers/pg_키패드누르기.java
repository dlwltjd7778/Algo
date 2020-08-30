package programmers;

import java.io.BufferedWriter;
import java.io.IOException;

public class pg_키패드누르기 {

	static Point left, right;
	static BufferedWriter bw;
	static StringBuilder sb;

	public String solution(int[] numbers, String hand) {
		String answer = "";
		left = new Point(3, 0); // 왼손, 오른손 첫 위치 저장
		right = new Point(3, 2);
		sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
			case 1:
				left.i = 0;left.j = 0;
				sb.append('L');
				break;
			case 4:
				left.i = 1;left.j = 0;
				sb.append('L');
				break;
			case 7:
				left.i = 2;left.j = 0;
				sb.append('L');
				break;
				// 왼손 끝
			case 3:
				right.i = 0;right.j = 2;
				sb.append('R');
				break;
			case 6:
				right.i = 1;right.j = 2;
				sb.append('R');
				break;
			case 9:
				right.i = 2;right.j = 2;
				sb.append('R');
				break;
				// 오른손 끝
			case 2:
				distanceChk(0, 1, hand);
				break;
			case 5:
				distanceChk(1, 1, hand);
				break;
			case 8:
				distanceChk(2, 1, hand);
				break;
			case 0:
				distanceChk(3, 1, hand);
				break;
			}

		}

		answer = sb.toString();
		return answer;
	}
	
	static void distanceChk(int i, int j,String hand) {
		int ld = Math.abs(left.i-i) + Math.abs(left.j-j);
		int rd = Math.abs(right.i-i) + Math.abs(right.j-j);

		if(ld>rd) {
			right.i = i; right.j = j;
			sb.append('R');
		} else if(ld<rd) {
			left.i = i; left.j = j;
			sb.append('L');
		} else {
			if(hand.equals("right")) {
				right.i = i; right.j = j;
				sb.append('R');
			} else {
				left.i = i; left.j = j;
				sb.append('L');
			}
		}
	
	}
//
//	public static void main(String[] args) throws IOException {
//		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//		//int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//		//int[] numbers = {4, 5, 9, 5};
//		
//		System.out.println(solution(numbers, "left"));
//		
//	}

	static class Point {
		int i, j;
		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}
