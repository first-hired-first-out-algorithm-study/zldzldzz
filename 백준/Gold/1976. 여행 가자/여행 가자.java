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
	static int[] N;

	static int findParent(int x) {
		if (N[x] == x) {
			return x;
		}
		return N[x] = findParent(N[x]);
	}

	static void union(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent != bParent) {
			N[bParent] = aParent;
		}
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		N = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			N[i] = i;
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = st.countTokens();
			for (int j = 1; j <= k; j++) {
				int type = Integer.parseInt(st.nextToken());
				if (type == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		boolean result = false;
		for (int i = 0; i < m - 1; i++) {
			int next = Integer.parseInt(st.nextToken());
			if (findParent(start) != findParent(next)) {
				result = true;
				break;
			}
		}
		if (result) {
			bw.write("NO\n");
		} else {
			bw.write("YES\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}