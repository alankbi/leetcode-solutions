package hard;

/**
 * Problem 4: Median of Two Sorted Arrays
 */
public class MedianTwoSortedArrays {

    // A giant attempt at O(log(N + M)) that doesn't even work
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0;
        int right1 = nums1.length - 1;
        int left2 = 0;
        int right2 = nums2.length - 1;

        // Loop condition should never fail; should always return a value before then
        while (left1 <= right1 || left2 <= right2) {
            // If nums1 or nums2 is empty
            if (left1 > right1) {
                return median(nums2, left2, right2);
            }
            if (left2 > right2) {
                return median(nums1, left1, right1);
            }

            // If either array is less than length or equal to 2, gg to this solution
            if ((right1 - left1 + 1) <= 2 || (right2 - left2 + 1) <= 2) {
                return medianInNTime(nums1, left1, right1, nums2, left2, right2);
            }

            // And literally any other edge case
            if ((right1 - left1 + 1) % 2 == 0 && (right2 - left2 + 1) % 2 == 0) {
                return medianInNTime(nums1, left1, right1, nums2, left2, right2);
            }

            // If all of one array is less than the other
            if (nums1[right1] < nums2[left2]) {
                // If same length, return median of two values
                if (right1 - left1 == right2 - left2) {
                    return (nums1[right1] + nums2[left2]) / 2.0;
                }

                // If nums1 is smaller than nums2, find median in nums2
                if (right1 - left1 < right2 - left2) {
                    return median(nums2, left2, right2 - (right1 - left1 + 1));
                }
                return median(nums1, left1 + (right2 - left2 + 1), right1);
            }
            if (nums2[right2] < nums1[left1]) {
                if (right1 - left1 == right2 - left2) {
                    return (nums2[right2] + nums1[left1]) / 2.0;
                }
                if (right1 - left1 < right2 - left2) {
                    return median(nums2, left2 + (right1 - left1 + 1), right2);
                }
                return median(nums1, left1, right1 - (right2 - left2 + 1));
            }

            double median1 = median(nums1, left1, right1);
            double median2 = median(nums2, left2, right2);

            // Equal number of elements to the left and right
            if (median1 == median2) {
                return median1;
            }

            // Remove the maximum number of elements to the left of the smaller median
            // and to the right of the larger median (removing the same amount from both sides)
            if (median1 > median2) {
                // If nums1 is smaller than nums2
                if (right1 - left1 < right2 - left2) {
                    // Discard values greater than or equal to median
                    int newRight1 = (left1 + right1) / 2;
                    // Get rid of left and right parts of median
                    left2 += right1 - newRight1;
                    right1 = newRight1;
                } else {
                    int newLeft2 = (left2 + right2) / 2;
                    right1 -= (newLeft2 - left2);
                    left2 = newLeft2;
                }
            } else { // median2 > median1
                if (right1 - left1 < right2 - left2) {
                    int newLeft1 = (left1 + right1) / 2;
                    right2 -= (newLeft1 - left1);
                    left1 = newLeft1;
                } else {
                    int newRight2 = (left2 + right2) / 2;
                    left1 += right2 - newRight2;
                    right2 = newRight2;
                }
            }
        }
        return -1; // Mistake occurred
    }

    private double median(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if ((left + right + 1) % 2 == 0) {
            return (arr[mid] + arr[mid + 1]) / 2.0;
        }
        return arr[mid];
    }

    // O(N + M)
    private double medianInNTime(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2) {
        int[] merged = new int[right1 - left1 + right2 - left2 + 2];
        int index = 0;
        while (left1 <= right1 && left2 <= right2) {
            if (nums1[left1] < nums2[left2]) {
                merged[index++] = nums1[left1++];
            } else {
                merged[index++] = nums2[left2++];
            }
        }
        while (left1 <= right1) {
            merged[index++] = nums1[left1++];
        }
        while (left2 <= right2) {
            merged[index++] = nums2[left2++];
        }
        return median(merged, 0, merged.length - 1);
    }

    public static void main(String[] args) {
        double result = new MedianTwoSortedArrays().findMedianSortedArrays(new int[] {1, 3}, new int[] {2});
        System.out.println(result);
    }
}
