package medium;

/**
 * Problem 1513: Number of Substrings With Only 1s
 */
public class NumSubstringsOnlyOnes {

    public int numSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        long totalCount = 0;
        long tempCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                tempCount++;
                totalCount += tempCount;
            } else {
                tempCount = 0;
            }
        }

        return (int) (totalCount % 1000000007);
    }

    public static void main(String[] args) {
        int result = new NumSubstringsOnlyOnes().numSub("0110111");
        System.out.println(result);
    }
}
