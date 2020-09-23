package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4613_러시아국기 {

	static int TC, N, M;
	static char[][] flag;
	static int[][] color;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			flag = new char[N][M];
			
			for(int i=0;i<N;i++) {
				flag[i] = br.readLine().toCharArray();
			} // end input
			
			color = new int[N][3];	// 0열 : W, 1열 : B, 2열 : R
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					char tmp = flag[i][j];
					if(tmp=='W') color[i][0]++;
					else if(tmp=='B') color[i][1]++;
					else color[i][2]++;
				}
			} // 색 개수 정보 담은 2차원 배열
			
			min = Integer.MAX_VALUE;
			for(int cnt=1;cnt<=N-2;cnt++) {
				paint(cnt);
			}
			System.out.println("#" + tc + " " + min);
			
		} // end tc
		
	} // end main
	
	static void paint(int R) {
		
		for(int c=1;c<=(N-1-R);c++) {
			int painting = 0;	// 색칠할 개수
			
			for(int i=0;i<c;i++) {
				painting += color[i][1] + color[i][2];
			}
			
			for(int i=c;i<c+R;i++) {
				painting += color[i][0] + color[i][2];
			}
			
			for(int i=c+R;i<N;i++) {
				painting += color[i][0] + color[i][1];
			}
		
			min = Integer.min(min, painting);
		}
		
	}
}
