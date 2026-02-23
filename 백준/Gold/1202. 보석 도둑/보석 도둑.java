import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] jw = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      jw[i][0] = Integer.parseInt(st.nextToken());
      jw[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] bags = new int[K];
    for (int i = 0; i < K; i++) {
      int size = Integer.parseInt(br.readLine());
      bags[i] = size;
    }

    Arrays.sort(bags);
    Arrays.sort(jw, (a, b) -> {
      if (a[0] == b[0]) {
        return b[1] - a[1];
      }
      return a[0] - b[0];
    });

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    long result = 0;
    int wjIndex = 0;
    for (int i = 0; i < K; i++) {
      while (wjIndex < N && jw[wjIndex][0] <= bags[i]) {
        pq.add(jw[wjIndex][1]);
        wjIndex++;
      }
      if(!pq.isEmpty()){
        result += pq.poll();
      }
    }

    bw.write(result + "\n");

    bw.flush();
    bw.close();
    br.close();
  }
}