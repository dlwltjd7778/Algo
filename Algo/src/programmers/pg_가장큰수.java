package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 정렬 - 가장큰수
 * https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 */

public class pg_가장큰수 {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        solution(numbers);
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] numString = new String[numbers.length];
        for (int i=0;i<numbers.length;i++) {
            numString[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numString, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(numString[0].equals("0")) return "0";

        for (String num :numString) {
            answer += num;
        }

        return answer;
    }



}
