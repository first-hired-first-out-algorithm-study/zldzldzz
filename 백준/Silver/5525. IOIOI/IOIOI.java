import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] M;

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int s = Integer.parseInt(br.readLine());
    String line = br.readLine();
    int result = 0;
    int count = 0;

    for (int i = 1; i < s - 1; i++) {
      if (line.charAt(i - 1) == 'I' && line.charAt(i) == 'O' && line.charAt(i + 1) == 'I') {
        count++;
        if (count >= n) {
          result++;
        }
        i++;
      }else{
        count=0;
      }
    }
    bw.write(result + "\n");

    bw.flush();
    bw.close();
    br.close();
  }
}