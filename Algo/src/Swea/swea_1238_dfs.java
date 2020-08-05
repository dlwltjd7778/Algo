package Swea;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
 
public class swea_1238_dfs {
	
	static int[][] map;
	static int ans;		// ���� �ʰ� �����޴� ��( �����̶�� ���� ��ȣ�� ū ��)
	static boolean[] visit;
	static int N, start;	// �ԷµǴ� ���������� ����, ���۳��
	static int maxDist;
	static int[] dist;		// ���������� �Ÿ������� ª�� ��찡 ��ϵǾ�����

    public static void main(String[] args) throws IOException {
 
    	Scanner sc = new Scanner(System.in);
    	int TC = 10;
    	
    	for(int tc=1;tc<=TC;tc++) {
    		map = new int[101][101];
    		ans = 0;
    		visit = new boolean[101];
    		dist = new int[101];
    		
    		N = sc.nextInt();
    		start = sc.nextInt();
    		
    		for(int i=0;i<N/2;i++) {
    			int st = sc.nextInt();
    			int end = sc.nextInt();
    			map[st][end] = 1;			// �Է� �ޱ�
    		}
    		
    		// dfs �޼ҵ� : �ϴ� �ٸ��ֵ� ���� �����ϴ��� �ѳ���� �����ؼ� ���� ��������
    		Arrays.fill(dist, Integer.MAX_VALUE);	// 1�� �迭�� ���� ū������ ä���ֱ�
    		dfs(start,0);
    		
    		maxDist = 0;
    		for(int i=1;i<=100;i++) {
    			if(dist[i]!=Integer.MAX_VALUE && maxDist<=dist[i]) {
    				maxDist = dist[i];
    				ans = i;
    			}
    		}
    		
    		System.out.println("#" + tc + " " + ans);
    		
    		
    	} // tc end
       
    } // main end

    
    // dfs �޼ҵ� : �ϴ� �ٸ��ֵ� ���� �����ϴ��� �ѳ���� �����ؼ� ���� ��������
    static void dfs(int now, int cnt) {
    	
    	dist[now] = cnt;
    	
    	for(int i=1;i<=100;i++) {
    		if(map[now][i]==1 && dist[i] > cnt+1) {
    			dfs(i,cnt+1);
    		}
    	}
    } // dfs end
    
} // class end
