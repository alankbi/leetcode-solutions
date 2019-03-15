package medium;

/**
 * Problem 11: Container With Most Water
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = findArea(height, left, right);

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }

            area = Math.max(area, findArea(height, left, right));
        }
        return area;
    }

    private int findArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }

    public static void main(String[] args) {
        int result = new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result);
    }
}
