import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int[] N;

  static int findParent(int x) {
    if (x == N[x]) {
      return x;
    } else {
      return N[x] = findParent(N[x]);
    }
  }

  static void union(int a, int b) {
    int ap = findParent(a);
    int bp = findParent(b);
    if(ap!=bp){
      N[bp] = ap;
    }
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int nodeSize = Integer.parseInt(st.nextToken());
    int lineLength = Integer.parseInt(st.nextToken());

    N = new int[nodeSize+1];

    for (int i = 1; i <= nodeSize; i++) {
      N[i] = i;
    }

    for (int i = 0; i < lineLength; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (type == 0) {
        union(x, y);
      } else if (type == 1) {
        if (findParent(x) == findParent(y)) {
          bw.write("YES\n");
        } else {
          bw.write("NO\n");
        }
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}