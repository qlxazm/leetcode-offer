package algorithm;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class num48 {

    public void rotate(int[][] matrix) {
        int rowHigh = matrix.length - 1;
        int colHigh = matrix[0].length - 1;
        int rowLower = 0, colLower = 0;

        while (rowLower < rowHigh) {
            // 进行一次移动
            for (int i = colLower, j = 0; i < colHigh; i++, j++) {
                int num = matrix[rowLower + j][colHigh];
                matrix[rowLower + j][colHigh] = matrix[rowLower][i];
                int num1 = matrix[rowHigh][colHigh - j];
                matrix[rowHigh][colHigh - j] = num;
                int num2 = matrix[rowHigh - j][colLower];
                matrix[rowHigh - j][colLower] = num1;
                matrix[rowLower][i] = num2;
            }
            rowLower++;
            rowHigh--;
            colLower++;
            colHigh--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        num48 num48 = new num48();
        num48.rotate(matrix);
    }

}
