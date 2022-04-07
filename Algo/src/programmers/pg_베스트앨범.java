package programmers;

import java.util.*;

/**
 * 해시 - 베스트앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */

public class pg_베스트앨범 {


    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres,plays);
    }



    public static int[] solution(String[] genres, int[] plays) {


        Map<String,Integer> gpMap = new HashMap<>();
        for(int i=0;i<genres.length;i++) {
            if (!gpMap.containsKey(genres[i])) {
                gpMap.put(genres[i], plays[i]);
            } else {
                gpMap.replace(genres[i], gpMap.get(genres[i]) + plays[i]);
            }
        }

        Comparator<String> c = (s1, s2)-> s2.compareTo(s1);

        List<Map.Entry<String,Integer>> genreList = new ArrayList<>(gpMap.entrySet());
        Collections.sort(genreList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        ArrayList<Music> result = new ArrayList<>();
        for(Map.Entry<String,Integer> gen : genreList) {
            ArrayList<Music> list = new ArrayList<>();
            String genre = gen.getKey();
            for(int i=0;i<genres.length;i++) {
                if(genre.equals(genres[i])) {
                    list.add(new Music(i, genres[i], plays[i]));
                }
            }
            Collections.sort(list, ((o1, o2) -> o2.playCnt - o1.playCnt));
            result.add(list.get(0));
            if (list.size() != 1) {
                result.add(list.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for (int i=0;i<answer.length;i++) {
            answer[i] = result.get(i).idx;
        }



        // 속한 노래가 많이 재생된 장르 먼저 수록

        // 장르 내에서 많이 재생된 노래 수록

        // 장르 내에서 재생 횟수가 같은경우 고유 번호가 낮은 노래 먼저 수록

        // 가장 많이 재생된 노래 장르별 두개씩 , 장르에 한곡만 있다면 한곡 만 선택

        return answer;
    }

    static class Music {
        int idx;
        String genre;
        int playCnt;

        public Music (int idx, String genre, int playCnt) {
            this.genre = genre;
            this.idx = idx;
            this.playCnt = playCnt;
        }
    }
}
