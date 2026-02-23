import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) ->
		{
			if (a[1] == b[1]) {
				return Long.compare(a[0], b[0]);
			}else{

				return Long.compare(a[1], b[1]);
			}
		});
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long s = Integer.parseInt(st.nextToken());
			long e = Integer.parseInt(st.nextToken());
			pq.offer(new long[] {s, e});
		}
		long now = 0;
		int result = 0;
		while (!pq.isEmpty()) {
			long[] p = pq.poll();
			if (now <= p[0]) {
				now = p[1];
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}