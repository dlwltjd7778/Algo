package programmers;

/*
    프로그래머스 dfs 타겟넘버
    https://programmers.co.kr/learn/courses/30/lessons/43165

 */

public class pg_타겟넘버 {

    static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers, target);
        return answer;

    }

    public static void dfs(int value, int idx, int[] numbers, int target) {

        if (idx == numbers.length) {
            if(value == target) {
                answer++;
            }
            return;
        }

        dfs(value + numbers[idx], idx+1, numbers, target );
        dfs(value - numbers[idx], idx+1, numbers, target );


    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        solution(numbers, target);
    }
}

