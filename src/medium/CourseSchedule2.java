package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Problem 210: Course Schedule II
 */
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[] {};
        }

        int[] numDependencies = new int[numCourses];
        int[] order = new int[numCourses];
        int orderIndex = 0;
        List<List<Integer>> dependents = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            dependents.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            numDependencies[prereq[0]]++;
            dependents.get(prereq[1]).add(prereq[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numDependencies.length; i++) {
            if (numDependencies[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.remove();
            order[orderIndex++] = course;
            for (int dependent : dependents.get(course)) {
                numDependencies[dependent]--;
                if (numDependencies[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }

        if (orderIndex != numCourses) {
            return new int[] {};
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//        int[][] prerequisites = {{1, 0}};

        int[] result = new CourseSchedule2().findOrder(4, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}
