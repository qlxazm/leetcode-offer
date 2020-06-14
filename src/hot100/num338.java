package hot100;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class num338 {
    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        int i;
        if (num > 1) {
            i = 2;
            while (i <= num) {
                results[i] = 1;
                int count = 2;
                while (i + count <= num && count < i){
                    results[i + count] = results[i] + results[count];
                    count += 2;
                }
                i = i + count;
            }
        }
        for (i = 1; i <= num; i += 2) {
            results[i] = results[i - 1] + 1;
        }
        return results;
    }

    public static void main(String[] arg) {
        num338 a = new num338();
        int[] nums = a.countBits(16);
        for(int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
