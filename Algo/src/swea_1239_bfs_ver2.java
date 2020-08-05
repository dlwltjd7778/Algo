

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class swea_1239_bfs_ver2 {
	
	static int[][] map;
	static int ans;		// ���� �ʰ� �����޴� ��( �����̶�� ���� ��ȣ�� ū ��)
	static boolean[] visit;
	static boolean[] exist;	// �л� ��ȣ�� �ݵ�� ���������� �����Ƿ� �����ϴ� �ֵ� ǥ���س���
	static int N, start;	// �ԷµǴ� ���������� ����, ���۳��
	static int maxDist;

    public static void main(String[] args) throws IOException {
 
    	Scanner sc = new Scanner(System.in);
    	int TC = 10;
    	
    	for(int tc=1;tc<=TC;tc++) {
    		map = new int[101][101];
    		ans = 0;
    		visit = new boolean[101];
    		exist = new boolean[101];
    		maxDist = 0;
    		
    		N = sc.nextInt();
    		start = sc.nextInt();
    		
    		for(int i=0;i<N/2;i++) {
    			int st = sc.nextInt();
    			int end = sc.nextInt();
    			map[st][end] = 1;			// �Է� �ޱ�
    			exist[st] = true;
    			exist[end] = true;
    		}
    		
    		
    		// BFS ver1 : Ž���ϸ鼭 �湮�ϴ� �� �������� �Ÿ��� ���� ����س���
    		Queue<Student> queue = new LinkedList<swea_1239_bfs_ver2.Student>();
    		queue.add(new Student(start,0));
    		
    		ArrayList<Student> candidate = new ArrayList<>();
    		visit[start] = true;				// q�� ����ִ� ���� �湮ó�� �ϱ�

    		while(!queue.isEmpty()) {
    			
    			Student now = queue.poll();
    			
    			for(int i=1;i<=100;i++) {
    				if(map[now.num][i]==1 && !visit[i]) {
    					queue.add(new Student(i, now.dist+1));
    					visit[i] = true;
    				}
    			}	
    			
    			if(now.dist > maxDist) {	// �Ÿ��� �ִ�! ���ݱ��� ���� �ֵ��� �����
    				candidate.clear();
    				//System.out.println(now.num+">");
    				maxDist = now.dist;
    				candidate.add(now);
    			} else if(now.dist == maxDist) {	// �Ÿ��� ����! �ϴ� ������
    				candidate.add(now);
    			//	System.out.println(now.num);
    			}
    		}
    		
    		for(int i=0;i<candidate.size();i++) {		// �Ÿ��� �� �ֵ鸸 ���� ����Ʈ���� �л���ȣ ū��ã��
    			if(candidate.get(i).num > ans)
    				ans = candidate.get(i).num;
    		}
    		
    		System.out.println("#" + tc + " " + ans);
    		
    		
    	} // tc end
       
    } // main end
 
    static class Student{
    	int num; 	// �л���ȣ
    	int dist;	// ��������� �±��� �ɸ��� �Ÿ�
    	
    	Student(int n,int d){
    		num = n;
    		dist = d;
    	}
    } // ��ü�� �л���ȣ�� �Ÿ� ������
    
    
} // class end
