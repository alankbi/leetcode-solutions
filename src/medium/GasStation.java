package medium;

/**
 * Problem 134: Gas Station
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;

        for (int i = gas.length - 1; i >= 0; i--) {
            total += gas[i] - cost[i];
            if (total > max) {
                max = total;
                maxIndex = i;
            }
        }

        if (total < 0) {
            return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int result = new GasStation().canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
