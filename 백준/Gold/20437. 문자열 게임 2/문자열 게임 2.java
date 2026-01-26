import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    int t = Integer.parseInt(br.readLine());
    for (int c = 0; c < t; c++) {
      String w = br.readLine();
			List<Integer>[] lists = new ArrayList[26];
			for (int i = 0; i < lists.length; i++) {
				lists[i] = new ArrayList<Integer>();
			}
      // 목표 글자 개수
      int k = Integer.parseInt(br.readLine());

      for (int i = 0; i < w.length(); i++) {
        char ch = w.charAt(i);
				int chInt = ch - 'a';
				lists[chInt].add(i);
      }
			int minLen = Integer.MAX_VALUE;
			int maxLen = Integer.MIN_VALUE;
			boolean found = false;

			for (List<Integer> list : lists) {
				if(list.size()>=k){
					found = true;
					// list에는 특정 문자가 나타난 위치(인덱스)들이 들어있음
					// i부터 i + k - 1까지가 딱 k개를 포함하는 구간
					for (int i = 0; i <= list.size() - k; i++) {
						int start = list.get(i);
						int end = list.get(i + k - 1);
						int length = end - start + 1;

						minLen = Math.min(minLen, length);
						maxLen = Math.max(maxLen, length);
					}
				}
			}
			if(!found){
				bw.write("-1\n");
			}else {
				bw.write(minLen + " " + maxLen+"\n");
			}
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
