package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem 406: Queue Reconstruction by Height
 */
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            }
            return p1[1] - p2[1];
        });

        List<int[]> queue = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            queue.add(person[1], person);
        }

        return queue.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] result = new QueueReconstructionByHeight().reconstructQueue(people);
        System.out.println(Arrays.deepToString(result));
    }
}
