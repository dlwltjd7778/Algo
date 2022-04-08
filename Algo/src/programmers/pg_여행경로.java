package programmers;

import java.util.*;

/*
    프로그래머스 dfs 여행경로
    https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class pg_여행경로 {

    public static void main(String[] args) {

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        solution(tickets);
    }

    static  ArrayList<String> allRoute; // 가능한 모든 경로
    static boolean[] visit;    // 방문 체크

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        allRoute = new ArrayList<>();
        visit = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets,0);
        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    public static void dfs (String start, String route, String[][] tickets, int cnt) {
        if (cnt==tickets.length) {
            allRoute.add(route);
            return;
        }

        for (int i=0;i<tickets.length;i++) {
            if (start.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], route+ " " + tickets[i][1], tickets, cnt+1);
                visit[i] = false;
            }
        }

    }
}
