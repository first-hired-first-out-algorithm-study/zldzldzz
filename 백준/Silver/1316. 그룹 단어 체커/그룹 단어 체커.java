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
    int caseCount = Integer.parseInt(br.readLine());
    int result = 0;

    for (int i = 0; i < caseCount; i++) {
      boolean isSuss = true;
      boolean[] apl = new boolean[26];
      String line = br.readLine();
      char lastWord = ' ';
      for (int j = 0; j < line.length(); j++) {
        char nowWord = line.charAt(j);
        if(nowWord != lastWord) {
          if(!apl[nowWord - 'a']) {
            apl[nowWord - 'a'] = true;
            lastWord = nowWord;
          }else {
            isSuss = false;
          }
        }
      }
      if(isSuss) {
        result++;
      }
    }
    bw.write(result + "\n");

    bw.flush();
    bw.close();
    br.close();
  }
}