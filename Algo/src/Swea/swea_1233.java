package Swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� �ǵ���.. Ʈ���� ���� �ڽ� �߰��ϰ� �� �׷�����.. ������..... ����....
public class swea_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = 10;

		for (int tc = 1; tc <= TC; tc++) {
			int size = Integer.parseInt(br.readLine());
			int ans = 1;
			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split(" ");
				
				char ch = line[1].charAt(0); // 1 - 2 3 �� ��� '-'

				if(((ch=='-' || ch=='+' || ch=='*' || ch=='/') && line.length<4) // �����ڰ� �ڽ��� �����ϰų�
						|| ((ch>='0'&&ch<='9') && line.length>2)) { // ���ڰ� �ڽ��� ������ ���
					ans=0;
				} // ���⼭ break �ϸ� �ȵ�. ������ �Էµ� for ������ �� ���Ƽ� �ޱ� �޾ƾ� ��.
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