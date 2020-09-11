package hard;

import java.util.Stack;

/**
 * Problem 42: Trapping Rain Water
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        Stack<Height> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                int latestPoppedHeight = 0;

                // While height is greater than previous, tally up water count
                while (!stack.isEmpty() && height[i] >= stack.peek().height) {
                    Height prev = stack.pop();

                    int horizontalDist = i - prev.index - 1;
                    int heightDiff = prev.height - latestPoppedHeight;

                    count += heightDiff * horizontalDist;
                    latestPoppedHeight = prev.height;
                }

                // Get any remaining water between latest index that's higher and current
                if (!stack.isEmpty()) {
                    Height prev = stack.peek();

                    int horizontalDist = i - prev.index - 1;
                    int heightDiff = height[i] - latestPoppedHeight;
                    count += heightDiff * horizontalDist;
                }

                stack.push(new Height(height[i], i));
            }
        }

        return count;
    }

    private static class Height {
        private int height;
        private int index;

        public Height(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int result = new TrappingRainWater().trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(result);
    }
}
