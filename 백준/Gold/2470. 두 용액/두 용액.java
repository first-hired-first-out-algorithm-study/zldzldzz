import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(list);
    int s = 0;
    int e = n - 1;
    int first = 0;
    int second = 0;
    long minZero = Long.MAX_VALUE;

    while (s < e) {
      long sum = list.get(s) + list.get(e);
      if (minZero > Math.abs(sum)) {
        first = list.get(s);
        second = list.get(e);
        minZero = Math.abs(sum);
        if (minZero == 0) {
          break;
        }
      } else if (sum < 0) {
        s++;
      } else if (sum > 0) {
        e--;
      }
    }
    bw.write(first + " " + second + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}