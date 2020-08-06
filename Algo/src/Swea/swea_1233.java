package Swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 원래 의도는.. 트리를 만들어서 자식 추가하고 뭐 그래봐라.. 겠지만..... 귀찮....
public class swea_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = 10;

		for (int tc = 1; tc <= TC; tc++) {
			int size = Integer.parseInt(br.readLine());
			int ans = 1;
			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split(" ");
				
				char ch = line[1].charAt(0); // 1 - 2 3 인 경우 '-'

				if(((ch=='-' || ch=='+' || ch=='*' || ch=='/') && line.length<4) // 연산자가 자식이 부족하거나
						|| ((ch>='0'&&ch<='9') && line.length>2)) { // 숫자가 자식을 가지는 경우
					ans=0;
				} // 여기서 break 하면 안됨. 나머지 입력도 for 끝까지 다 돌아서 받긴 받아야 함.
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
/*
 * #1 0
#2 0
#3 0
#4 1
#5 0
#6 1
#7 1
#8 0
#9 0
#10 0
*/