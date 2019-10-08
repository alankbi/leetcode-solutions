package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem 403: Frog Jump
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        // Stores set of jump lengths that were able to reach the given stone (key)
        Map<Integer, Set<Integer>> reachedStones = new HashMap<>();
        reachedStones.put(1, new HashSet<>());
        reachedStones.get(1).add(1);

        for (int i = 1; i < stones.length - 1; i++) {
            if (reachedStones.containsKey(stones[i])) {
                // Add further jumps of length k - 1, k, and k + 1
                Set<Integer> jumpLengths = reachedStones.get(stones[i]);
                for (int length : jumpLengths) {
                    addJump(stones[i], length - 1, reachedStones);
                    addJump(stones[i], length, reachedStones);
                    addJump(stones[i], length + 1, reachedStones);
                }
            }
        }

        // Last stone was able to be reached
        return reachedStones.containsKey(stones[stones.length - 1]);
    }

    private void addJump(int curr, int length, Map<Integer, Set<Integer>> reachedStones) {
        if (length == 0) {
            return;
        }

        int key = curr + length;
        if (!reachedStones.containsKey(key)) {
            reachedStones.put(key, new HashSet<>());
        }
        reachedStones.get(key).add(length);
    }

    public static void main(String[] args) {
//        boolean result = new FrogJump().canCross(new int[] {0, 1, 3, 5, 6, 8, 12, 17});
        boolean result = new FrogJump().canCross(new int[] {0,1,2,3,4,8,9,11});
        System.out.println(result);
    }
}
