import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

  static final int INF = Integer.MAX_VALUE / 2;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int problemNum = 1;
    while (true) {

      int n = Integer.parseInt(br.readLine());

      if (n == 0) {
        break;
      }

      int[][] map = new int[n][n];
      int[][] result = new int[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < 4; k++) {
            result[i][j] = INF;
          }
        }
      }

      StringTokenizer st = null;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      result[0][0] = map[0][0];
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        return a[2] - b[2];
      });
      pq.offer(new int[]{0, 0, map[0][0]});
      while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        for (int k = 0; k < 4; k++) {
          int x = cur[0] + dir[k][0];
          int y = cur[1] + dir[k][1];
          if (x >= 0 && y >= 0 && x < n && y < n) {
            if (result[x][y] > result[cur[0]][cur[1]] + map[x][y]) {
              result[x][y] = result[cur[0]][cur[1]] + map[x][y];
              pq.offer(new int[]{x, y, result[x][y]});
            }
          }
        }
      }
      bw.write("Problem "+problemNum+": "+result[n-1][n-1] + "\n");
      problemNum++;
    }

    bw.flush();
    bw.close();
    br.close();
  }
}