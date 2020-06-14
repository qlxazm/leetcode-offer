package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class num210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] buffer = new int[numCourses];
        // 转换成邻接矩阵
        for (int i = 0, len = prerequisites.length; i < len; i++) {
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
            buffer[prerequisites[i][0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        // 寻找入度为0的点
        for (int i = 0; i < numCourses; i++) {
            if (buffer[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visited++;
            ans.add(node);

            for (int i = 0; i < numCourses; i++) {
                if (matrix[node][i] == 1) {
                    buffer[i]--;
                    if (buffer[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        if (visited < numCourses) {
            return new int[]{};
        }

        int[] courses = new int[ans.size()];
        visited = 0;
        for (Integer course : ans) {
            courses[visited++] = course;
        }

        return courses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        num210 num210 = new num210();
        for (int num : num210.findOrder(2, prerequisites)) {
            System.out.println(num);
        }
    }

}
