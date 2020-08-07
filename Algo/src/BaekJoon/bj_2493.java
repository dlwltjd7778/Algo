package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2493 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack top = new Stack(n);
		Stack temp = new Stack(n);

		int[] s = new int[n];
		int[] signal = new int[n]; // 탑 신호 저장 배열 생성

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			top.push(Integer.parseInt(st.nextToken()));
		}

		int i = 0;
		int b = top.pop();	// 맨 처음 원소 꺼내기
		while (i < n - 1) {
			//top.print();
			//System.out.println(i+1);
			if (b < top.peek()) { // 현재 비교 원소와 탑스택의 맨 위원소 비교

				signal[i] = top.size();
				i++;

				while (!temp.isEmpty()) {	// 템프에 있는거 다 탑에 넣기
					top.push(temp.pop());
				}
				b = top.pop();

			} else {
				temp.push(top.pop());
				if (top.isEmpty()) {	// 탑이 비어있다면 signal인덱스 증가
					i++;
					if(i<n-1) {
						
						while (!temp.isEmpty()) {	// 템프에 있는거 다 탑에 넣기
							top.push(temp.pop());
						}
						b = top.pop();
					}
				}
			}

		}
		
		

		for (int id = n - 1; id >= 0; id--) {
			sb.append(signal[id]);
			sb.append(" ");
		}
		
		System.out.println(sb.toString());

	}

}

class Stack {
	int[] stack;
	int top = 0;

	Stack(int n) {
		stack = new int[n];
	}

	void push(int data) {
		stack[top] = data;
		top++;
	}

	int pop() {
		int data = stack[top - 1];
		stack[top - 1] = 0;
		top--;
		return data;
	}

	int peek() {
		return stack[top - 1];
	}

	int size() {
		return top;
	}

	boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}
	
	void print() {
		for(int i=0;i<size();i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
