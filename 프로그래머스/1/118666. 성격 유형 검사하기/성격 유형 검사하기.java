import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
		Character[] map = new Character[8];
		StringTokenizer st = new StringTokenizer("R T C F J M A N");
		int[] score = new int[8];
		for (int i = 0; i < 8; i++) {
			map[i] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < survey.length; i++) {
			String s = survey[i];
			int a = Arrays.asList(map).indexOf(s.charAt(0));
			int b = Arrays.asList(map).indexOf(s.charAt(1));
			if (choices[i] > 4) {
				score[b] += choices[i] - 4;
			} else if (choices[i] < 4) {
				score[a] += 4 - choices[i];
			}
		}
		for (int i = 0; i < 8; i = i + 2) {
			System.out.println(i + " " + (i + 1));
			if (score[i] >= score[i + 1]) {
				answer = answer + String.valueOf(map[i]);
			} else {
				answer = answer + String.valueOf(map[i + 1]);
			}
		}
        return answer;
    }
}