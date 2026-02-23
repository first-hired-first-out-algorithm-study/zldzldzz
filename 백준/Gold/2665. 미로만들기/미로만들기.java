import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[2] - b[2];
		});
		pq.add(new int[] {0, 0, 0});
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int d = cur[2];

			if (x == N - 1 && y == N - 1) {
				bw.write(d + "\n");
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						if (map[nx][ny] == 1) {
							pq.add(new int[] {nx, ny, d});
						} else {
							pq.add(new int[] {nx, ny, d + 1});
						}
					}
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
}
