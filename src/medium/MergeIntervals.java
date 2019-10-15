package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem 56: Merge Intervals
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        int[] current = {intervals[0][0], intervals[0][1]};
        int k = 1;

        while (k < intervals.length) {
            if (intervals[k][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[k][1]);
            } else {
                merged.add(current);
                current = intervals[k];
            }
            k++;
        }
        merged.add(current);
        return merged.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] result = new MergeIntervals().merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
