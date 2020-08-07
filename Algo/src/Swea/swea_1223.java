package Swea;

import java.util.Scanner;
import java.util.Stack;

public class swea_1223 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=1;tc++) {
			
			int N = sc.nextInt();
			
			char[] cal = sc.next().toCharArray();
			
			Stack<Character> temp = new Stack<Character>();	// 후위표기식 스택
			Stack<Character> op = new Stack<Character>();	// 연산자 스택
			
			/////////////////////////////////////////////////////////////////////
			
			// 후위표기식 만들기
			for(int i=0;i<cal.length;i++) {
				if(cal[i]!='+' && cal[i]!='*') {
					temp.add(cal[i]);			// cal[i] 가 숫자면 추가
 				} else {
 					if(op.isEmpty()) {	// 스택이 비어있다면
 						op.add(cal[i]); // 연산자 대입
 					} else {
 						
 						if(op.peek()=='+'&&cal[i]=='*'){
 							op.add(cal[i]);
 						}else {
 							temp.add(op.pop());
 							op.add(cal[i]);
 						}

 					}
 				}
			}
			// 연산자 스택에 남은거 다 빼주기
			while(!op.isEmpty()) {
				temp.add(op.pop());
			} 
			
			while(!temp.isEmpty()) {
				System.out.println(temp.pop());
			}

			////////////////////////////////////////////////////////////////////////////////
//			
//			// 후위표기식 계산하기
//			Stack<Character> backCal = new Stack<Character>();
//			Stack<Integer> ans = new Stack<Integer>();
//			
//			// 바꾼 후위표기식 계산을 위해 반대로 넣어주기
//			while(!temp.isEmpty()) {
//				backCal.add(temp.pop());
//			}
//			
//			while(!backCal.isEmpty()) {
//				
//				char t = backCal.pop();
//				
//				if(t=='*' || t=='+') {
//					
//					int a = (int)ans.pop();
//					int b = (int)ans.pop();
//					
//					if(t=='*') {
//						ans.add(a*b);
//					}else {
//						ans.add(a+b);
//					}
//					
//				} 
//				
//				ans.add((int)t);
//				
//				
//			}
//			
//			System.out.println(ans.peek());
//			
//			
			
			
			
			
			
			
			
			
			
			
			
		} // tc end
	}
	

}
