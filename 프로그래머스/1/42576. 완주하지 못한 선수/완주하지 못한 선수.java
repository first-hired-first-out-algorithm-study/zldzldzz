import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>();
		for (String s : participant) {
			result.put(s, result.getOrDefault(s, 0) + 1);
		}
        for (String s : completion) {
			result.put(s, result.get(s) - 1);
		}
        for (String s : result.keySet()) {
			if (result.get(s) != 0) {
				return s;
			}
		}
       return "";
        
    }
}