import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1: Two Sum
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                int[] indices = new int[]{i, map.get(target - nums[i])};
                if (indices[1] < indices[0]) {
                    int temp = indices[0];
                    indices[0] = indices[1];
                    indices[1] = temp;
                }
                return indices;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] indices = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(indices));
    }
}
