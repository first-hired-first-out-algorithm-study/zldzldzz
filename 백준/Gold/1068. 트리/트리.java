import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer>[] tree;
	static int target;

	static int countLeaf(int node) {
		int childrenCount = 0;
		int totalLeaf = 0;

		for (int child : tree[node]) {
			if (child == target) continue;
			childrenCount++;
			totalLeaf += countLeaf(child);
		}
		if (childrenCount == 0) return 1;
		return totalLeaf;
	}

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int [] data = new int[n];

		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		tree = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}
		int root = -1;
		for (int i = 0; i < n; i++) {
			if (data[i] == -1) {
				root = i;
			} else {
				tree[data[i]].add(i);
			}
		}


		target = Integer.parseInt(br.readLine());
		if (target == root) {
			bw.write("0");
		} else {
			bw.write(String.valueOf(countLeaf(root)));
		}
    bw.flush();
    bw.close();
    br.close();
  }
}
