package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @author qian
 * @date 2020/1/18 22:33
 */
public class num54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int m = matrix.length, n = 0, total;
        if (m > 0) {n = matrix[0].length;}

        total = m * n;
        int x1 = 0, x2 = m - 1, y1 = 0, y2 = n - 1, i;
        while (total > 0) {
             i = y1;
             while (i <= y2) {list.add(matrix[x1][i++]);}
             total -= (y2 - y1 + 1);

             i = x1 + 1;
             while (total > 0 && i <= x2) {list.add(matrix[i++][y2]);}
             total -= (x2 - x1);

             i = y2 - 1;
             while (total > 0 && i >= y1) {list.add(matrix[x2][i--]);}
             total -= (y2 - y1);

             i = x2 - 1;
             while (total > 0 && i > x1) {list.add(matrix[i--][y1]);}
             total -= (x2 - x1 - 1);

            x1++;
            x2--;
            y1++;
            y2--;
        }

        return list;
    }

    public static void main(String[] args) {
        num54 a = new num54();
        int[][] matrix = {
                /*{ 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }*/
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };

        List<Integer> result = a.spiralOrder(matrix);
        for (int num : result) {
            System.out.print(num + ", ");
        }
    }
}
