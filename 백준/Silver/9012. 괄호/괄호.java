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
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			for (int j = 0; j < line.length(); j++) {
				Character ch = line.charAt(j);
				if (ch == '(') {
					stack.push(ch);
				} else if (ch == ')') {
					if (stack.isEmpty()) {
						flag = true;
						break;
					}
					stack.pop();
				}
			}
			if (flag || !stack.isEmpty()) {
				bw.write("NO\n");
			} else {
				bw.write("YES\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
