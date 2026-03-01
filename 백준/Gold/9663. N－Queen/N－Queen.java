import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N = 0;
	static int[] board = null;
	static int result = 0;

	static boolean isValid(int length) {
		for (int i = 0; i < length; i++) {
			if (board[i] == board[length]) {
				return false;
			}
			if (Math.abs(i - length) == Math.abs(board[length] - board[i])) {
				return false;
			}
		}
		return true;
	}

	static void back(int length) {
		if (length == N) {
			result++;
			return;
		}
		for (int k = 0; k < N; k++) {
			board[length] = k;
			if (isValid(length)) {
				back(length + 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N];
		back(0);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}