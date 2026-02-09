import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			if (max < map[i]) {
				max = map[i];
			}
		}
		int low = 0;
		int res = 0;
		while (low <= max) {
			int mid = (low + max + 1) / 2;
			Long get = 0L;
			for (int i : map) {
				if (i > mid) {
					get += (i - mid);
				}
			}
			if (get >= M) {
				res = mid;
				low = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
