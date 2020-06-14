package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 */
public class num202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            if (n == 1) {return true;}
            char[] charArray = String.valueOf(n).toCharArray();
            n = 0;
            for (char c : charArray) {
                n += (c - '0');
            }
        }

        return false;
    }

}
