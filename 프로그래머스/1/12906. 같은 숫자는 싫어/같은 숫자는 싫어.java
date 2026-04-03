import java.util.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
       List<Integer> list = new ArrayList<Integer>();
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			if (q.isEmpty() || q.getLast() != arr[i]) {
				q.add(arr[i]);
			}
		}
		while (!q.isEmpty()) {
			list.add(q.poll());
		}
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}