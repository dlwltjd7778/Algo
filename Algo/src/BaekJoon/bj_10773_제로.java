package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class bj_10773_제로 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<n;i++) {
			
			int tmp = sc.nextInt();
			if(tmp!=0) {
				stack.add(tmp);
			} else {
				stack.pop();
			}
		}
		int answer = 0;
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}
