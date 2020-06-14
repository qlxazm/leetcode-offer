package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @author qian
 * @date 2020/1/21 16:45
 */
public class num118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {return ans;}

        // 处理一些特殊情况
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        if (numRows > 1) {ans.add(secondRow);}

        for (int i = 2; i < numRows; i++) {
            List<Integer> lastRow = ans.get(i - 1);

            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < i; j++) {
                newRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            newRow.add(1);
            ans.add(newRow);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
