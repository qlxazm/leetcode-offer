package hot100;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class num96 {
    public int numTrees(int n) {
        int[] buffer = new int[n + 1];
        buffer[0] = 1;
        if (n >= 1) {buffer[1] = 1;}

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++){
                buffer[i] += buffer[j] * buffer[i - j - 1];
            }
        }
        return n == 0 ? 0 : buffer[n];
    }

    public static void main(String[] args) {
        num96 a = new num96();
        System.out.println(a.numTrees(3));
    }
}
