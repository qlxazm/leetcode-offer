package hot100;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class num48 {
    public void rotate(int[][] matrix) {
        int len = matrix[0].length;
        rotateMatrix(matrix, 0, 0, len - 1, len - 1);
    }

    public void rotateMatrix(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (!(x1 < x2 && y1 < y2)) {return;}
        int[] buffer = new int[x2 - x1 + 1];
        int i, temp;
        //按照上右下左的顺序旋转矩阵的外围
        for (i = x1; i <= x2; i++){
            buffer[i - x1] = matrix[i][y2];
        }

        //上到右
        temp = matrix[x1][y2];
        for (i = y1; i < y2; i++) {
            matrix[i][y2] = matrix[x1][i];
        }
        matrix[i][y2] = temp;

        //左到上
        for (i = x1; i <= x2; i++) {
             matrix[x1][y2 - i + y1] = matrix[i][y1];
        }
        //下到左
        for (i = y1; i <= y2; i++){
            matrix[i][y1] = matrix[x2][i];
        }
        //右到下面
        for (i = y1; i <= y2; i++) {
            matrix[x2][i] = buffer[y2 - i];
        }

        rotateMatrix(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1);
    }

    public static void main(String[] args) {
        num48 a = new num48();
        /*int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };*/
        int [][] nums = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        a.rotate(nums);
        for (int i = 0, len = nums.length; i < len; i++) {
            int [] temp = nums[i];
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j] + ",");
            }
            System.out.println("");
        }
    }
}
