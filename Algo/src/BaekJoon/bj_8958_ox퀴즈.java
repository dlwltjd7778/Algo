package BaekJoon;

import java.util.Scanner;

public class bj_8958_ox퀴즈 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=0;tc<TC;tc++) {
			String tmp = sc.next();
			
			int score=0;
			int total=0;
			for(int i=0;i<tmp.length();i++) {
				if(tmp.charAt(i)=='O') {
					score++;
					total += score;
				} else {
					score = 0;
				}
			}
			System.out.println(total);
		}
		
	}
}
