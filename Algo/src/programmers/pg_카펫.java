package programmers;

/*
    programmers 완전탐색
    https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class pg_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i=1; i<=yellow/2+1; i++) {

            if (yellow%i==0) {
                int h = i;              // 세로
                int w = yellow/i;       // 가로

                int area = h*2 + w*2 + 4;

                // 가로 세로 정해지면, 갈색 사이즈 크기랑 맞는지 확인
                if (area == brown) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    break;
                }
            }
        }

        return answer;
    }
}
