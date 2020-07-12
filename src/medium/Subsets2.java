package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 90: Subsets II
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>(map.keySet());
        List<List<Integer>> result = new ArrayList<>();

        subsetsWithDup(uniqueNums, 0, map, new ArrayList<>(), result);

        return result;
    }

    private void subsetsWithDup(List<Integer> uniqueNums, int index, Map<Integer, Integer> map,
                                List<Integer> current, List<List<Integer>> result) {

        if (index >= uniqueNums.size()) {
            result.add(new ArrayList<>(current));
        } else {
            subsetsWithDup(uniqueNums, index + 1, map, current, result);

            int count = map.get(uniqueNums.get(index));
            for (int i = 0; i < count; i++) {
                current.add(uniqueNums.get(index));
                subsetsWithDup(uniqueNums, index + 1, map, current, result);
            }

            for (int i = 0; i < count; i++) {
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Subsets2().subsetsWithDup(new int[] {1, 2, 2});
        System.out.println(result);
    }
}
