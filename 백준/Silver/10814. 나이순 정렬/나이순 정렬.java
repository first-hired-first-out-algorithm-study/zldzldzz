import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<Object[]> members = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members.add(new Object[] {Integer.parseInt(st.nextToken()), st.nextToken()});
		}
		Collections.sort(members, (a, b) -> {
			if (a[0] != b[0]) {
				return (Integer)a[0] - (Integer)b[0];
			}
			return 0;
		});
		for (Object[] member : members) {
			bw.write(member[0] + " " + member[1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
