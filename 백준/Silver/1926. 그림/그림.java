import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int countN = 0;
		int countMax = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Stack<int[]> stack = new Stack<int[]>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					stack.push(new int[] {i, j});
					visited[i][j] = true;
					countN++;
					int count = 1;
					while (!stack.isEmpty()) {
						int[] now = stack.pop();
						for (int k = 0; k < 4; k++) {
							int x = now[0] + dir[k][0];
							int y = now[1] + dir[k][1];
							if (x >= 0 && y >= 0 && x < N && y < M && !visited[x][y]) {
								if (map[x][y] == 1) {
									stack.push(new int[] {x, y});
									count++;
									visited[x][y] = true;
								}
							}
						}
					}
					countMax = Math.max(countMax, count);
				}
			}
		}
		System.out.println(countN);
		System.out.println(countMax);
		bw.flush();
		bw.close();
		br.close();
	}
}
