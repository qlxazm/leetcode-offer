package coder;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/integer-replacement/
 */
public class num397 {

    public int integerReplacement(int n) {
        if(n == 1) {return 0;}
        if (n == 2) {return 1;}
        int count = 0;

        while (n > 3) {
            // 奇数
            if ((n & 1) == 1){
                n >>= 1;
                count += 2;
                if ((n & 1) == 1){
                    n += 1;
                }
            }else{
                n >>= 1;
                count++;
            }
        }
        return count + (n == 3 ? 2 : 1);
    }


    public static void main(String[] args) {
        num397 a = new num397();

        System.out.println(a.integerReplacement(6));
    }
}
