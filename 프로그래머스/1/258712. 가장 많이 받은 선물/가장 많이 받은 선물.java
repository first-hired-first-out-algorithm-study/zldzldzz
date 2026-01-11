import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
		int[][] map = new int[friends.length][friends.length];
		int[] giftsValue = new int[friends.length];
		for (String gift : gifts) {
			String[] st = gift.split(" ");
			String giver = st[0];
			String receiver = st[1];

			int giverIndex = Arrays.asList(friends).indexOf(giver);
			int receiverIndex = Arrays.asList(friends).indexOf(receiver);

			giftsValue[giverIndex]++;
			giftsValue[receiverIndex]--;
			map[giverIndex][receiverIndex] += 1;
		}
		int max = 0;
		int[] friendsValue = new int[friends.length];
		for (int i = 0; i < friends.length; i++) {

			for (int j = 0; j < friends.length; j++) {
				if (map[i][j] > map[j][i]) {
					friendsValue[i]++;
				} else if (map[i][j] == map[j][i]) {
					if (giftsValue[i] > giftsValue[j]) {
						friendsValue[i]++;
					}
				}
			}
			if (friendsValue[i] > max) {
				max = friendsValue[i];
			}
		}
		answer = max;
        return answer;
    }
}