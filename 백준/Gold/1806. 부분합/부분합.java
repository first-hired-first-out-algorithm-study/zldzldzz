
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
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
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    int l = 0;
    int r = 0;
    int sum = 0;
    int minLehgth = Integer.MAX_VALUE;

    while (true) {
      if (sum >= s) {
        minLehgth = Math.min(minLehgth, r - l);
        sum -= list.get(l++);
      } else if (r == n) {
        break;
      } else {
        sum += list.get(r++);
      }
    }
    if (minLehgth == Integer.MAX_VALUE) {
      bw.write("0");
    } else {
      bw.write(minLehgth + "");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}