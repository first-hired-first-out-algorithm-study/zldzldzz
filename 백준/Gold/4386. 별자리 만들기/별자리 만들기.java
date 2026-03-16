import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static List<double[]> list = new ArrayList<double[]>();
	static int[] N;
	static PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[2], b[2]));

	static double calV(int aIndex, int bIndex) {
		double[] a = list.get(aIndex);
		double[] b = list.get(bIndex);
		double x = Math.abs(a[0] - b[0]);
		double y = Math.abs(a[1] - b[1]);
		double c = x * x + y * y;
		return Math.sqrt(c);
	}

	static int findParent(int x) {
		if (x == N[x]) {
			return x;
		} else {
			return N[x] = findParent(N[x]);
		}
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
		N = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list.add(new double[] {x, y});
			N[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					pq.add(new double[] {i, j, calV(i, j)});
				}
			}
		}
		double result = 0;
		while (!pq.isEmpty()) {
			double[] now = pq.poll();
			int x = (int)now[0];
			int y = (int)now[1];
			if (findParent(x) != findParent(y)) {
				result += now[2];
				union(x, y);
			}
		}
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}
}