package kakao;

import java.util.ArrayList;
import java.util.List;

/*
    programmers 2021 카카오 채용연계형 인턴십 - 숫자 문자열과 영단어
    replace를 이용하면 쉽게 풀 수 있는 문제
    list 말고 배열이 더 나을듯
    https://programmers.co.kr/learn/courses/30/lessons/81301
 */

public class pg_숫자문자열과영단어 {

    public static int solution(String s) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");

        for (int i=0;i<list.size();i++) {
            s = s.replace(list.get(i), Integer.toString(i));
        }



        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        solution("1zerotwozero3");
    }

}
