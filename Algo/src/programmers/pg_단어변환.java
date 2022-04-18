package programmers;

/*
 * 프로그래머스 단어변환 dfs
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class pg_단어변환 {

    static boolean[] check;
    static int answer;
    public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        check = new boolean[words.length];
        dfs(0, begin, target, words);
        if (answer==Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    public static void dfs(int cnt, String now, String target, String[] words) {
        // 단어가 현재 비교하는 단어와 같으면 answer
        if (now.equals(target)) {
           if(answer > cnt) {
               answer = cnt;
           }
        }

        for (int i=0; i< words.length; i++) {

            if (!check[i] && convert(now, words[i])) {
                check[i] = true;
                dfs(cnt + 1, words[i], target, words);
                check[i] = false;
            }
        }

    }

    public static boolean convert(String s1, String s2) {
        int cnt = 0;
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        if (cnt == 1) return true;
        else return false;
    }

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

}
