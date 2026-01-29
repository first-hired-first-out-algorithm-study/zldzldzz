import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String line = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}

				sb.append('<');
				while (line.charAt(i + 1) != '>') {
					sb.append(line.charAt(i + 1));
					i++;
				}
				i++;
				sb.append('>');
				continue;
			} else if (c == ' ') {
				if (!stack.isEmpty()) {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				sb.append(' ');
			} else {
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
