import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<String> words = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String newWord = br.readLine();
			// 중복 제거
			if (!words.contains(newWord)) {
				words.add(newWord);
			}
		}

		Collections.sort(words, (s1, s2) -> {
			if (s1.length() != s2.length())
				return s1.length() - s2.length();
			return s1.compareTo(s2);
		});

		for (String word : words) {
			bw.write(word + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
