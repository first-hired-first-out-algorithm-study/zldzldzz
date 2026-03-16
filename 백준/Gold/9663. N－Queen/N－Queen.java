import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] board;
	static boolean[] visited;
	static int result = 0;

	static void solve(int length) throws IOException {
		if (length == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			board[length] = i;
			if (isValid(length)) {
				solve(length + 1);
			}
		}
	}

	static boolean isValid(int length) {
		for (int i = 0; i < length; i++) {
			if (board[i] == board[length]) {
				return false;
			}
			if (Math.abs(i - length) == Math.abs(board[i] - board[length])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N];
		visited = new boolean[N];
		solve(0);

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}