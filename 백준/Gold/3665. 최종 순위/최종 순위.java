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
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCases; i++) {
			int teamCount = Integer.parseInt(br.readLine());
			int[] lastYear = new int[teamCount + 1];
			int[] indegree = new int[teamCount + 1];
			// teams[a][b] -> a > b 존재
			boolean[][] teams = new boolean[teamCount + 1][teamCount + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= teamCount; j++) {
				lastYear[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j <= teamCount; j++) {
				for (int k = j + 1; k <= teamCount; k++) {
					int front = lastYear[j];
					int back = lastYear[k];
					teams[front][back] = true;
					indegree[back]++;
				}
			}
			int reverseCase = Integer.parseInt(br.readLine());
			for (int k = 0; k < reverseCase; k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (teams[a][b]) {
					teams[a][b] = false;
					indegree[b]--;
					teams[b][a] = true;
					indegree[a]++;
				} else {
					teams[b][a] = false;
					indegree[a]--;
					teams[a][b] = true;
					indegree[b]++;
				}
			}

			Queue<Integer> q = new LinkedList<>();
			for (int k = 1; k <= teamCount; k++) {
				if (indegree[k] == 0)
					q.add(k);
			}
			StringBuilder sb = new StringBuilder();
			boolean isPossible = true;
			boolean isAmbiguous = false;
			for (int k = 1; k <= teamCount; k++) {
				if (q.isEmpty()) {
					isPossible = false;
					break;
				}
				if (q.size() > 1) {
					isAmbiguous = true;
					break;
				}
				int now = q.poll();
				sb.append(now).append(" ");
				for (int next = 1; next <= teamCount; next++) {
					if (teams[now][next]) {
						indegree[next]--;
						if (indegree[next] == 0)
							q.add(next);
					}
				}
			}
			if (!isPossible)
				bw.write("IMPOSSIBLE\n");
			else if (isAmbiguous)
				bw.write("?\n");
			else
				bw.write(sb.toString().trim() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}