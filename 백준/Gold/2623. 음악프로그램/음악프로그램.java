import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		int[] team = new int[N + 1];
		List<Integer>[] teamList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			teamList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			for (int j = 1; j < n; j++) {
				int e = Integer.parseInt(st.nextToken());
				team[e]++;
				teamList[s].add(e);
				s = e;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (team[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			for (int i : teamList[now]) {
				team[i]--;
				if (team[i] == 0) {
					q.add(i);
				}
			}
		}
		if (result.size() != N) {
			bw.write("0\n");
		} else {
			for (int i : result) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}
}