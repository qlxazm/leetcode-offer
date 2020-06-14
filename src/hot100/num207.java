package hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class num207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        char[][] grid = new char[numCourses][numCourses];
        Stack<Integer> stack = new Stack<>();
        // 计算入度
        for (int i = 0, len = prerequisites.length; i < len; i++) {
            inDegrees[prerequisites[i][1]]++;
            grid[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        // 入度为0的进入堆栈
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) { stack.push(i);}
        }

        int count = 0;
        boolean[] isVisited = new boolean[numCourses];
        while (!stack.isEmpty()) {
            int index = stack.pop();
            isVisited[index] = true;
            count++;
            for (int i = 0; i < numCourses; i++) {
                // 跳过已访问的
                if (isVisited[i]) {continue;}
                if (grid[index][i] == 1){
                    inDegrees[i]--;
                    if (inDegrees[i] == 0){stack.push(i);}
                }

            }
        }

        return prerequisites.length == 0 || count == numCourses;
    }

    public static void main(String[] args) {
        num207 a = new num207();
        int[][] prerequisites = {{1,0}};
        System.out.print(a.canFinish(3, prerequisites));
    }
}
