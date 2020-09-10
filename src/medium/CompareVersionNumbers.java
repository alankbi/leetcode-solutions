package medium;

/**
 * Problem 165: Compare Version Numbers
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < 4; i++) {
            int valV1 = get(v1, i);
            int valV2 = get(v2, i);

            if (valV1 > valV2) {
                return 1;
            }
            if (valV2 > valV1) {
                return -1;
            }
        }

        return 0;
    }

    private int get(String[] version, int index) {
        if (index >= version.length) {
            return 0;
        }
        return Integer.parseInt(version[index]);
    }

    public static void main(String[] args) {
        int result = new CompareVersionNumbers().compareVersion("0.1", "1.1");
        System.out.println(result);
    }
}
