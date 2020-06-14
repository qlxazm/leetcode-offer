package hot100;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author qian
 * @date 2020/1/9 21:47
 */
public class num74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        int m = 0, n = 0;
        if (matrix != null) { m = matrix.length; }
        if (m > 0) { n = matrix[0].length;}

        int lower = 0, hight = m * n - 1, middle, temp;

        while (lower <= hight) {
            middle = (lower + hight) / 2;
            temp = matrix[middle / n][middle % n];
            if (temp == target) {
                result = true;
                break;
            }else if (temp < target) {
                lower = middle + 1;
            }else {
                hight = middle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
