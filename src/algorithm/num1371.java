package algorithm;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
public class num1371 {

    class State{
        boolean a;
        boolean e;
        boolean i;
        boolean o;
        boolean u;
    }

    /**
     * a e i o u
     * 每个原字音母奇偶组合形成32种状态
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int len = s.length(), ans = 0, code = 0;
        State state = new State();
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[code] = -1;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    code += (state.a = !state.a) ? 16 : -16;
                    break;
                case 'e':
                    code += (state.e = !state.e) ? 8 : -8;
                    break;
                case 'i':
                    code += (state.i = !state.i) ? 4 : -4;
                    break;
                case 'o':
                    code += (state.o = !state.o) ? 2 : -2;
                    break;
                case 'u':
                    code += (state.u = !state.u) ? 1 : -1;
                    break;
            }
            if (map[code] != -2) {
                ans = Math.max(ans, i - map[code]);
            } else {
                map[code] = i;
            }
        }
        return ans;
    }

}
