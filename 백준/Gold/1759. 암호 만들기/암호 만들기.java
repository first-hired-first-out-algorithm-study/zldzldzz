import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int l = 0;
  static int c = 0;
  static int[] result;
  static boolean[] visited;
  static List<Integer> list;

  static void back(int depth, int s) throws IOException {
    if (l == depth) {
      if(isValid()){
        for (int i = 0; i < l; i++) {
          bw.write(((char) result[i] + 'a'));
        }
        bw.newLine();
      }
      return;
    }
    for (int i = s; i < c; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[depth] = list.get(i);
        back(depth + 1, i + 1);
        visited[i] = false;
      }
    }
  }

  static boolean isValid() {
    int vowelCount = 0;
    int consonantCount = 0;

    for (int val : result) {
      char c = (char) (val + 'a');

      if (isVowel(c)) {
        vowelCount++;
      } else {
        consonantCount++;
      }
    }
    return vowelCount >= 1 && consonantCount >= 2;
  }

  static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    visited = new boolean[c];
    result = new int[l];
    list = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      list.add(st.nextToken().charAt(0) - 'a');
    }
    Collections.sort(list);
    back(0, 0);

    bw.flush();
    bw.close();
    br.close();
  }
}