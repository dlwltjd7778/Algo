package BaekJoon;

import java.util.Scanner;

public class bj_2564_경비원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		int W = sc.nextInt();
		int H = sc.nextInt();
		int store = sc.nextInt();
		int[] storeArr = new int[store+1]; // 일직선이라고 생각했을 때 각상점들이 위치한 번호를 저장할 것이당
										   // 마지막은 동근이..
		
		for(int i=0;i<store+1;i++) {
			int dir = sc.nextInt();
			int position = sc.nextInt();
			if(dir==1) storeArr[i] = position;
			else if(dir==2) storeArr[i] = (H+W)+(W-position);
			else if(dir==3) storeArr[i] = (H+W)*2 - position;
			else storeArr[i] = W + position;
		} 
		
		int dong = storeArr[store];	// 동근이 일직선 좌표값
		
		for(int i=0;i<store;i++) {
			// 정방향 구하기
			int a = Math.abs(dong-storeArr[i]);
			// 반대방향 구하기
			int max = Math.max(dong,storeArr[i]);
			int min = Math.min(dong,storeArr[i]);
			// (H+W)*2 에서 둘중 큰 값을 빼준 후 작은 값의 위치를 더해주면 반대방향 거리 나온다.
			int b = Math.abs((H+W)*2-max+min);
			result += Math.min(a, b);
		}
		
		System.out.println(result);
		
	}
}
