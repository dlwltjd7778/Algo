package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class swea_1238 {
 
    static boolean[] num[];
    static int N;
    static int start;
    static int maxIdx;
    static int max;
    static int count;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
 
        for (int tc = 1; tc <= TC; tc++) {
 
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
 
            num = new boolean[101][101];
            max = 0; // �ִ� ������ ����
 
            st = new StringTokenizer(br.readLine(), " ");
 
            while (st.hasMoreTokens()) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                num[i][j] = true;
            }
 
            System.out.println("#" + tc + " " + bfs(start));
 
        }
 
    }
 
    // ���� �湮 ó��
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> ansCandidate = new LinkedList<Integer>();    // ���� �ĺ�
        boolean visited[] = new boolean[101];
        queue.add(start);
        visited[start] = true; 
 
        while (!queue.isEmpty()) {
             
            int size = queue.size();
             
            ansCandidate.clear();   // �� ����
             
            for (int s = 0; s < size; s++) { // ť ������ ��ŭ ���� 
                int cur = queue.poll();
                ansCandidate.add(cur);
 
                for (int i = 1; i < 101; ++i) {
                    if (num[cur][i] && !visited[i]) {
                        queue.add(i);
                        visited[i] = true; // ���2 : ���� �湮 ó��
                    }
                }
            }   // size for end
             
        } // while�� end
         
        max = Collections.max(ansCandidate);	// collection�� �ִ��� ã���ִ� �޼ҵ� ������
        
//        while(!ansCandidate.isEmpty()) {
//            int tmp = ansCandidate.poll();
//            if(tmp>max) max = tmp;
//        }
         
        return max;
 
    } // bfs end
 
} // class end
