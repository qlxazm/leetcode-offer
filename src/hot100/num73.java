package hot100;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @author qian
 * @date 2020/1/19 13:59
 */
public class num73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = 0;
        if (m > 0) { n = matrix[0].length; }

        // 遍历之前检查第一行和第一列是否含有0，否则后续的操作会让这些信息丢失
        boolean firstRowHasZero = false, firstColumnHasZero = false;
        for (int i = 0; i < m && !firstColumnHasZero; i++) {
            firstColumnHasZero = matrix[i][0] == 0;
        }
        for (int j = 0; j < n && !firstRowHasZero; j++) {
            firstRowHasZero = matrix[0][j] == 0;
        }

        // 如果发现某个元素是0，就将对应行的第一个元素、对应列的第一个元素设置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { matrix[i][0] = matrix[0][j] = 0; }
            }
        }

        // 检查行, 第一行特殊处理
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {matrix[i][j] = 0;}
            }
        }

        // 检查列
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {matrix[j][i] = 0;}
            }
        }

        // 特殊处理第一行和第一列
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {matrix[0][j] = 0;}
        }
        if (firstColumnHasZero) {
            for (int j = 0; j < m; j++) {matrix[j][0] = 0;}
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                /*{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}*/
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
                /*{1, 1, 1},
                {0, 1, 2}*/
        };

        num73 a = new num73();
        a.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int  j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
