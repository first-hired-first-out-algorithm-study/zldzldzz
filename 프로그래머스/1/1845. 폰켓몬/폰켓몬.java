import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length / 2;
		for (int i = 0; i < n * 2; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int typeCount = map.size();
		if (typeCount >= n) {
			return n;
		} else {
			return typeCount;
		}
    }
}