import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static public int sequence(Character c) {
		if (c.equals('(')) {
			return 0;
		} else if (c.equals('/') || c.equals('*')) {
			return 2;
		}
		if (c.equals('+') || c.equals('-')) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		String line = br.readLine();
		Deque<Character> stack = new LinkedList<>();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			// 알파벳 넣기
			if (Character.isLetterOrDigit(line.charAt(i))) {
				result.append(line.charAt(i));
			} else if (line.charAt(i) == '(') {
				stack.push('(');
			} else if (line.charAt(i) == ')') {
				while (!stack.isEmpty() && !stack.peek().equals('(')) {
					result.append(stack.pop());
				}
				if (!stack.isEmpty()) {
					// '('제거
					stack.pop();
				}
			} else {
				// 기호들
				while (!stack.isEmpty() && sequence(line.charAt(i)) <= sequence(stack.peek())) {
					result.append(stack.pop());
				}
				stack.push(line.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		bw.write(result.toString() + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
