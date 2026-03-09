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
	static int N, M;
	static int[] board;
	static boolean[] visited;

	static void solve(int length, int depth) throws IOException {
		if (length == M) {
			for (int i = 0; i < M; i++) {
				bw.write(board[i] + " ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				board[depth] = i + 1;
				solve(length + 1, depth + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N];
		visited = new boolean[N];
		solve(0, 0);
		bw.flush();
		bw.close();
		br.close();

	}
}