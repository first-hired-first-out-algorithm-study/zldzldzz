import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int v[];
	static PriorityQueue<int[]> e = new PriorityQueue<>((a, b) -> {
		return a[2] - b[2];
	});

	static int findParent(int x) {
		if (v[x] == x) {
			return x;
		} else {
			return v[x] = findParent(v[x]);
		}
	}

	static void union(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent != bParent) {
			v[bParent] = aParent;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		v = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			v[i] = i;
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			e.add(new int[] {x, y, value});
		}
		int result = 0;
		while (!e.isEmpty()) {
			int[] edge = e.poll();
			int x = findParent(edge[0]);
			int y = findParent(edge[1]);
			if (x != y) {
				union(x, y);
				result += edge[2];
			}
		}
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}
}