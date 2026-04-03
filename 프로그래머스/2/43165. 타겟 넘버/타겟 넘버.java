import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {-numbers[0], 1});
		stack.push(new int[] {numbers[0], 1});
		int count = 0;
		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			int sum = cur[0];
			int index = cur[1];
			if (index == numbers.length && sum == target) {
				count++;
			}
			if (index < numbers.length) {
				stack.push(new int[] {cur[0] + numbers[cur[1]], cur[1] + 1});
				stack.push(new int[] {cur[0] - numbers[cur[1]], cur[1] + 1});
			}
		}
        return count;
    }
}