package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1463_1로만들기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		System.out.println(func(X));
		
		
	}
	static int func(int num) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		
		queue.add(num);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				int tmp = queue.poll();
				if(tmp==1) return cnt;
				
				if(tmp%3==0) {
					queue.add(tmp/3);
				}
				if(tmp%2==0) {
					queue.add(tmp/2);
				}
				queue.add(tmp-1);
			}
			cnt++;
		}
		return cnt;
	}
}
