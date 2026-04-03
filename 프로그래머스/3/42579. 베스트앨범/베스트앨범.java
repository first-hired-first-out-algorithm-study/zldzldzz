import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresMap = new HashMap<String, Integer>();
		Map<String, List<Integer[]>> songsByGenre = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
			songsByGenre.putIfAbsent(genres[i], new ArrayList<>());
			songsByGenre.get(genres[i]).add(new Integer[] {i, plays[i]});
		}

		List<String> keySet = new ArrayList<>(genresMap.keySet());

		keySet.sort((a, b) -> {
			return genresMap.get(b).compareTo(genresMap.get(a));
		});

		List<Integer> resultList = new ArrayList<>();


		for (String genre : keySet) {
			List<Integer[]> list = songsByGenre.get(genre);

			list.sort((a, b) -> {
				return b[1].compareTo(a[1]);
			});
			resultList.add(list.get(0)[0]);
            if (list.size() > 1) {  
        resultList.add(list.get(1)[0]);
    }
		}
        int[] answer = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			answer[i] = resultList.get(i);
		}
        return answer;
    }
}