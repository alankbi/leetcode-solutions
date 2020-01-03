package easy;

/**
 * Problem 303: Range Sum Query - Immutable
 */
public class RangeSumQueryImmutable {

    private int[] cumulativeSum;

    public RangeSumQueryImmutable(int[] nums) {
        cumulativeSum = new int[nums.length + 1];
        cumulativeSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum[i + 1] = nums[i] + cumulativeSum[i];
        }
    }

    public int sumRange(int i, int j) {
        return cumulativeSum[j + 1] - cumulativeSum[i];
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(r.sumRange(0, 2));
        System.out.println(r.sumRange(2, 5));
        System.out.println(r.sumRange(0, 5));
    }
}
