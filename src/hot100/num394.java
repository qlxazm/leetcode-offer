package hot100;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/decode-string/
 */
public class num394 {

    /**
     * 操作次数栈
     */
    private LinkedList<Integer> timesStack = new LinkedList<>();
    /**
     * 操作字符栈
     */
    private LinkedList<String> strStack = new LinkedList<>();
    /**
     * 括号栈
     */
    private LinkedList<Character> bracketsStack = new LinkedList<>();

    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public String decodeString(String s) {
        return decodeString(s, 0);
    }

    private String decodeString(String s, int begin) {
        // 找到第一个右括号
        if (begin >= s.length()) {return "";}
        while (begin < s.length()) {
            char character =  s.charAt(begin);
            int times = 0;
            String currStr;

            while (begin < s.length() && character != RIGHT_BRACKET){
                // 1、计算操作次数
                while (isNumber(character)){
                    times = times * 10 + (character - '0');
                    character = s.charAt(++begin);
                }

                bracketsStack.addLast('[');

                if (times > 0) {
                    timesStack.addLast(times);
                    // 2、如果有必要就跳过左括号
                    begin++;
                }else {
                    timesStack.addLast(1);
                }

                // 3、找需要操作的字符串
                int strBegin = begin;
                character = s.charAt(begin);
                while (isLetter(character)){
                    begin++;
                    if (begin == s.length()) {break;}
                    character = s.charAt(begin);
                }
                strStack.addLast(s.substring(strBegin, begin));

                if (times == 0) {
                    begin--;
                    break;
                }
                character = s.charAt(begin);
                times = 0;
            }

            // 开始计算一个括号内部的内容
            times = timesStack.removeLast();
            currStr = strStack.removeLast();
            bracketsStack.removeLast();

            StringBuilder builder = new StringBuilder("");
            for (; times > 0; times--) {builder.append(currStr);}
            if (!bracketsStack.isEmpty()) {
                // 如果左边还有括号，应该将先前的字符串连接到当前字符串
                strStack.addLast(strStack.removeLast() + builder.toString());
            }else {
                // 如果左边没有括号，就直接压入
                strStack.addLast(builder.toString());
            }
            begin++;
        }
        StringBuilder builder = new StringBuilder();
        while (!strStack.isEmpty()) {
            builder.append(strStack.removeLast());
        }
        return builder.reverse().toString();
    }

    private boolean isNumber(char c) { return c >= '0' && c <= '9'; }
    private boolean isLetter(char c) { return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');}

    public static void main(String[] args) {
        num394 a = new num394();
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]ef";
//        String s = "2[abc]3[cd]ef";
//        String s = "2[b4[F]c]";
//        String s = "3[a]2[b4[F]c]";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
//        String s = "2[2[b]]ef";
        System.out.print(a.decodeString(s));
    }
}
