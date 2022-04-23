package programmers;

import java.util.HashSet;
import java.util.Set;

public class pg_완탐_소수찾기 {

	public static void main(String[] args) {
		solution("17");
	}

	static Set<Integer> set;

	public static int solution(String numbers) {
		int answer = 0;
		set = new HashSet<>();

		select("", numbers);

		for (int a: set) {
			if(isPrimeNum(a)) {
				answer++;
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void select(String now, String number) {
		if (!"".equals(now)) {
			set.add(Integer.parseInt(now));
		}

		for (int i=0;i<number.length();i++) {
			select(now + number.charAt(i), number.substring(0,i) + number.substring(i+1));
		}
	}

	public static boolean isPrimeNum(int num) {

		if (num==0 || num==1) {
			return false;
		}

		int limit = (int)Math.sqrt(num);

		for (int i=2; i<=limit; i++) {
			if(num%i==0) {
				return false;
			}
		}

		return true;
	}
}
