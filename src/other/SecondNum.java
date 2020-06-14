package other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快手面试题，第二个数
 */
public class SecondNum {

    public String secondNums(String s) {
        List<Integer> nums = Arrays.stream(s.split(" ")).map(Integer::new).collect(Collectors.toList());
        Integer[] buffer = new Integer[2];

        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = nums.size(); i < len; i++) {
            Integer num = nums.get(i);
            if (buffer[0] == null) {
                buffer[0] = num;
            } else if (num > buffer[0]) {
                buffer[0] = num;
            } else if (buffer[1] == null) {
                buffer[1] = num;
            } else if (num > buffer[1]) {
                buffer[1] = num;
            }
            if (buffer[1] != null && !buffer[1].equals(buffer[0]) && buffer[1].equals(num)) {
                builder.append(i);
                builder.append(" ");
            }
        }

        String ans = builder.toString();
        return ans.substring(0, ans.length() - 1);
    }

    public static void main(String[] args) {
        String s = "2 2 1 3 2 4 5 9 6";
        SecondNum secondNum = new SecondNum();
        System.out.println(secondNum.secondNums(s));
    }
}
