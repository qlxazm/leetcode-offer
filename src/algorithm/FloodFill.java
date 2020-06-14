package algorithm;

/**
 * https://leetcode-cn.com/problems/color-fill-lcci/
 */
public class FloodFill {

    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    public void dfs1(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length ||
                visited[row][col] || image[row][col] == newColor) {
            return;
        }

        visited[row][col] = true;
        image[row][col] = newColor;
        dfs1(image, row - 1, col, oldColor, newColor);
        dfs1(image, row + 1, col, oldColor, newColor);
        dfs1(image, row, col - 1, oldColor, newColor);
        dfs1(image, row, col + 1, oldColor, newColor);

    }

    public void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 && col >= image[0].length) {
            return;
        }
        if (image[row][col] == -1 || image[row][col] != oldColor) {
            return;
        }
        image[row][col] = -1;
        dfs(image, row - 1, col, oldColor, newColor);
        dfs(image, row + 1, col, oldColor, newColor);
        dfs(image, row, col - 1, oldColor, newColor);
        dfs(image, row, col + 1, oldColor, newColor);
        image[row][col] = newColor;
    }
}
