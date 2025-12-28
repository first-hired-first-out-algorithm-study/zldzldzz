import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer>[] list;
	static int[] visited; // 전역 방문 체크 배열
	static int visitToken = 0; // 매 탐색마다 증가시켜 초기화 대신 사용
	static int n;
	static int[] q; // 수동 큐로 사용할 배열

	static int countChild(int node) {
		visitToken++; // 이번 탐색의 고유 ID (이전 방문 기록 무시 효과)
		int head = 0, tail = 0;

		q[tail++] = node;
		visited[node] = visitToken;
		int count = 0;

		while (head < tail) {
			int now = q[head++];

			for (int next : list[now]) {
				if (visited[next] != visitToken) { // 이번 회차에 방문 안 했다면
					visited[next] = visitToken;
					q[tail++] = next;
					count++;
				}
			}
		}
		return count;
	}

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 부모 -> 자식
    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[y].add(x);
    }

		int[] result = new int[n + 1];
		visited = new int[n + 1]; // 모든 요소 0으로 시작
		q = new int[n + 1]; // 큐로 사용할 배열 미리 생성
		int max = 0;

		for (int i = 1; i <= n; i++) {
			result[i] = countChild(i);
			if (result[i] > max) max = result[i];
    }
    for (int i = 1; i <= n; i++) {
      if (result[i] == max) {
        bw.write(i + " ");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
