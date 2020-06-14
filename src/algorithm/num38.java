package algorithm;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class num38 {

    public String countAndSay(int n) {
        String last = "1";
        if (n <= 1) {return last;}
        while (n > 1) {
            StringBuilder builder = new StringBuilder();
            int count = 0;
            char c = '0';
            for (int i = 0, len = last.length(); i < len; i++) {
                if (last.charAt(i) != c) {
                    if (count > 0) {
                        builder.append(count);
                        builder.append(last.charAt(i - 1));
                    }
                    c = last.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }
            if (count > 0) {
                builder.append(count);
                builder.append(last.charAt(last.length() - 1));
            }
            last = builder.toString();

            n--;
        }

        return last;
    }

    public static void main(String[] args) {
        num38 num38 = new num38();
        System.out.println(num38.countAndSay(4));
    }
}
