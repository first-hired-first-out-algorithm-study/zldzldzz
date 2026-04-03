class Solution {
    public int solution(int[][] sizes) {
        int maxR = 0;
		int maxL = 0;
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] >= sizes[i][1]) {
				if (sizes[i][0] > maxR) {
					maxR = sizes[i][0];
				}
				if (sizes[i][1] > maxL) {
					maxL = sizes[i][1];
				}
			} else {
				if (sizes[i][1] > maxR) {
					maxR = sizes[i][1];
				}
				if (sizes[i][0] > maxL) {
					maxL = sizes[i][0];
				}
			}
		}
        return maxR*maxL;
    }
}