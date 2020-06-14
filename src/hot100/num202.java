package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * @author qian
 * @date 2020/2/6 7:54
 */
public class num202 {

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        int num = 0, temp = n;
        while (!set.contains(temp)) {
            if (temp == 1) {return true;}
            temp = 0;
            set.add(n);
            while (n > 0) {
                num = n % 10;
                temp += num * num;
                n /= 10;
            }
            n = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        num202 a = new num202();
        System.out.println(a.isHappy(17));
    }
}
