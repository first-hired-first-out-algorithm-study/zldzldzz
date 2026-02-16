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
		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];
		int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
		}
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;
		int res = -1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == N - 1 && cur[1] == M - 1) {
				res = cur[3];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dir[i][0];
				int ny = cur[1] + dir[i][1];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 0 && !visited[nx][ny][cur[2]]) {
						visited[nx][ny][cur[2]] = true;
						q.offer(new int[] {nx, ny, cur[2], cur[3] + 1});
					} else if (map[nx][ny] == 1 && !visited[nx][ny][1]) {
						if (cur[2] == 0) {
							visited[nx][ny][1] = true;
							q.offer(new int[] {nx, ny, 1, cur[3] + 1});
						}
					}
				}

			}

		}
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
