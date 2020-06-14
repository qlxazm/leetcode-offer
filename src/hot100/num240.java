package hot100;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class num240 {

    private int target;
    private int[][] matrix;

    public boolean searchMatrix(int x1, int y1, int x2, int y2) {
        // target比最小的还小，比最大的还大，就肯定找不到直接返回
        if (x1 > x2 || y1 > y2 || target < matrix[x1][y1] || target > matrix[x2][y2]) {
            return false;
        }

        // 寻找合适的切割点
        int middle = (y1 + y2) / 2, row = x1;
        while (row <= x2 && matrix[row][middle] <= target) {
            if (matrix[row][middle] == target) {
                return true;
            }
            row++;
        }
        // 根据找到的切割点把二位矩阵切割成四块。删除左上、右下部分，递归计算左下、右上部分
        return searchMatrix(row, y1, x2, middle - 1) || searchMatrix(x1, middle + 1, row - 1, y2);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        this.matrix = matrix;
        this.target = target;
        return searchMatrix(0, 0, matrix.length - 1, matrix[0].length - 1);
    }


   /* public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = 0;
        if (m > 0) {n = matrix[0].length;}
        // 将指针指向二维矩阵的左下脚
        int row = m - 1, col = 0, ele;
        while (row >= 0 && col < n) {
            ele = matrix[row][col];
            if (ele == target) {
                return true;
            }else {
                if (ele > target) {
                    // 如果当前元素比target还大，就要删除一行（因为数据是行递增有序的）
                    row--;
                }else {
                    // 如果当前元素比target还小，就要删除一列（因为数据是列递增有序的）
                    col++;
                }
            }
        }
        return false;
    }*/

   /*
   方法一：也是最容易想到的方法
   每行都二分查找，这样只用到了一个条件，就是行的有序性
   public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {return false;}
        int n = matrix[0].length;
        if (n == 0) {return false;}
        for (int i = 0; i < m; i++) {
            if (target == matrix[i][0]) {return true;}
            if (target > matrix[i][0] && binarySearch(matrix[i], target)){return true;}
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int lower = 0, higher = nums.length - 1;
        while (lower <= higher) {
            int middle = (lower + higher) >> 1;
            if (target < nums[middle]) {
                higher = middle - 1;
            }else if (target > nums[middle]){
                lower = middle + 1;
            }else {
                return true;
            }
        }
        return false;
    }*/

    /**
     * 二分法，切分
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length - 1, n;
        if(m >= 0) {
            n = matrix[0].length - 1;
            if (n >= 0) {
                int i = m, j = 0;
                while (i >= 0 && j <= n) {
                    if (matrix[i][j] == target) {
                        return true;
                    }else {
                        if (matrix[i][j] < target) {
                            j++;
                        } else {
                            i--;
                        }
                    }
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        num240 a = new num240();
        /*int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };*/

       /* int[][] matrix = {
                {1,   2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };*/

       /*int[][] matrix = {
               {-1, 3}
       };*/
        int[][] matrix = {{1, 3, 5}};
        System.out.print(a.searchMatrix1(matrix, 5));
    }
}














