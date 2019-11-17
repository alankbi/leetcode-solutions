package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Problem 207: Course Schedule
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> prereqs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            prereqs.add(new HashSet<>());
        }

        for (int[] arr : prerequisites) {
            prereqs.get(arr[0]).add(arr[1]);
        }

        Queue<Integer> ends = new ArrayDeque<>();
        for (int i = 0; i < prereqs.size(); i++) {
             if (prereqs.get(i).isEmpty()) {
                 ends.add(i);
             }
        }

        while (!ends.isEmpty()) {
            int courseNum = ends.remove();
            for (int i = 0; i < prereqs.size(); i++) {
                Set s = prereqs.get(i);
                if (s.contains(courseNum)) {
                    s.remove(courseNum);
                    if (s.isEmpty()) {
                        ends.add(i);
                    }
                }
            }
        }

        for (Set s : prereqs) {
            if (!s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {
            {1, 0},
            {2, 1},
//            {0, 1},
        };

        boolean result = new CourseSchedule().canFinish(3, prerequisites);
        System.out.println(result);
    }
}
