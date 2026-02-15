import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];

		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] {N, 0});
		visited[N] = true;

		int result = 0;

		while (!q.isEmpty()) {
			Integer[] node = q.poll();

			if (node[0] == M) {
				result = node[1];
				break;
			}
			
			if (node[0] * 2 >= 0 && node[0] * 2 < 100001 && !visited[node[0] * 2]) {
				visited[node[0] * 2] = true;
				q.add(new Integer[] {node[0] * 2, node[1]});
			}

			if (node[0] - 1 >= 0 && node[0] - 1 < 100001 && !visited[node[0] - 1]) {
				visited[node[0] - 1] = true;
				q.add(new Integer[] {node[0] - 1, node[1] + 1});
			}
			if (node[0] + 1 >= 0 && node[0] + 1 < 100001 && !visited[node[0] + 1]) {
				visited[node[0] + 1] = true;
				q.add(new Integer[] {node[0] + 1, node[1] + 1});
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
