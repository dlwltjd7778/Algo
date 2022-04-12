package programmers;

import java.util.Arrays;
import java.util.Collections;

/*
    프로그래머스 정렬 h-index
    https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class pg_hIndex {

    public static void main(String[] args) {
        int[] citations = {0,1,1};

        System.out.println(solution(citations));
    }


    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for ( int i=citations.length-1; i>=0; i--) {
            int order = citations.length-i;
            if (citations[i] >= order) {
                answer = order;
            } else {
                break;
            }

        }

//        Arrays.sort(citations);
//
//        for (int i=0; i<citations.length; i++) {
//            int h = citations.length-i;
//
//            if(citations[i] >= h) {
//                return h;
//            }
//        }

        return answer;
    }
}
