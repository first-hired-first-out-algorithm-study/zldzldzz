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
	static int M = 0;
	static int[] result = null;
	static boolean[] visited = null;

	static void back(int length) throws IOException {
		if (length == M) {
			for (int i = 0; i < result.length; i++) {
				bw.write(result[i] + " ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[length] = i + 1;
				back(length + 1);
				visited[i] = false;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		visited = new boolean[N];
		back(0);
		bw.flush();
		bw.close();
		br.close();

	}
}