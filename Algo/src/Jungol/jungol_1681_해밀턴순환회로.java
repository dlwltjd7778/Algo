package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class jungol_1681_해밀턴순환회로 {
 
    static int N;
    static int[][] matrix;  // 인접행렬
     
    static boolean[] selected;
    static int[] result;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        selected = new boolean[N];
        result = new int[N];
        min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input end
         
        dfs(0,0,0);
        System.out.println(min);
         
    }
 
    static int min;
    private static void dfs(int cnt, int idx, int total) {
    	
    	if(total>min) return;
 
        if(cnt==N-1) {
        	if(matrix[idx][0]!=0) {
        		total += matrix[idx][0];
        		if(min>total) min = total;
        	}
            return;
        }
         
        for(int i=1;i<N;i++) {
            
        	if(i==idx) continue;
            if(matrix[idx][i]==0 || selected[i]) continue;
             
            selected[i] = true;
            dfs(cnt+1,i,total + matrix[idx][i]);
            selected[i] = false;
             
        }
    }
}