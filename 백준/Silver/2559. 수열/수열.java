import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    int sum = 0;
    for (int i = 0; i < M; i++) {
      sum += list.get(i);
    }
    int maxSum = sum;

    for (int i = M; i < N; i++) {
      sum = sum - list.get(i - M) + list.get(i);
      maxSum = Math.max(sum, maxSum);
    }
    bw.write(maxSum+"\n");

    bw.flush();
    bw.close();
    br.close();
  }
}