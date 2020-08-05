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
            max = 0; // 최댓값 저장할 변수
 
            st = new StringTokenizer(br.readLine(), " ");
 
            while (st.hasMoreTokens()) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                num[i][j] = true;
            }
 
            System.out.println("#" + tc + " " + bfs(start));
 
        }
 
    }
 
    // 들어갈때 방문 처리
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> ansCandidate = new LinkedList<Integer>();    // 정답 후보
        boolean visited[] = new boolean[101];
        queue.add(start);
        visited[start] = true; 
 
        while (!queue.isEmpty()) {
             
            int size = queue.size();
             
            ansCandidate.clear();   // 다 비우기
             
            for (int s = 0; s < size; s++) { // 큐 사이즈 만큼 돌기 
                int cur = queue.poll();
                ansCandidate.add(cur);
 
                for (int i = 1; i < 101; ++i) {
                    if (num[cur][i] && !visited[i]) {
                        queue.add(i);
                        visited[i] = true; // 방법2 : 들어갈때 방문 처리
                    }
                }
            }   // size for end
             
        } // while문 end
         
        max = Collections.max(ansCandidate);	// collection의 최댓값을 찾아주는 메소드 존재함
        
//        while(!ansCandidate.isEmpty()) {
//            int tmp = ansCandidate.poll();
//            if(tmp>max) max = tmp;
//        }
         
        return max;
 
    } // bfs end
 
} // class end
