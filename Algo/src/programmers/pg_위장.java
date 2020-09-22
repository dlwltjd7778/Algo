package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class pg_위장 {

	public static int solution(String[][] clothes) {

		HashMap<String, Integer> list = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			String type = clothes[i][1];
			if (list.containsKey(type)) {
				int tmp = list.get(type);
				list.replace(type, tmp + 1);
			} else {
				list.put(type, 1);
			}
		}

		Set set = list.keySet();
		Iterator iterator = set.iterator();
		int tmp = 1;
		
		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			tmp *= (list.get(key)+1);
		}

		return tmp-1;
	}



	public static void main(String[] args) {

		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.println(solution(clothes));
	}

}
