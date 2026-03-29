import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<String, Integer>();

		for (String[] s : clothes) {
			map.put(s[1], map.getOrDefault(s[1], 0) + 1);
		}

		int answer = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (answer == 0) {
				answer = value + 1;
			} else {
				answer = answer * (value + 1);
			}
		}
        return answer-1;
    }
}