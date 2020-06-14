package hot100;

import java.lang.reflect.Array;
import java.util.*;

/**
 *  https://leetcode-cn.com/problems/generate-parentheses/
 */
public class num22 {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 1;
        result.add("()");

        while (count < n) {
            Iterator<String> iterator = result.iterator();
            Set<String> temp = new HashSet<>();
            while (iterator.hasNext()){
                String curr = iterator.next();
                // 记录下扩展过的字符串，进行减枝
                if (map.get(curr) != null) {continue;}
                map.put(curr, true);

                int index = curr.indexOf('(');
                while (index >= 0) {
                    //在左边添加一个括号
                    String newValue = curr.substring(0, index) + "()" + curr.substring(index);
                    temp.add(newValue);
                    // 右边加上一个括号
                    newValue = curr.substring(0, index + 1) + "()" + curr.substring(index + 1);
                    temp.add(newValue);
                    index = curr.indexOf('(', index + 1);
                }
            }
            result = temp;
            count++;
        }
        List<String> a = new ArrayList<>();
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()){
            a.add(iterator.next());
        }
        return a;
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int i, len;
        for (i = 0, len = s.length(); i < len; i++) {
            Character temp = stack.peekFirst();
            Character curr = s.charAt(i);
            if (temp != null && temp == '(' && curr == ')'){
                stack.pollFirst();
            }else {
                stack.addFirst(curr);
            }
        }
        return i == len && stack.isEmpty();
    }

    public static void main(String[] args) {
        num22 a = new num22();
        List<String> results = a.generateParenthesis(3);

        for (int i = 0, len = results.size(); i < len; i++) {
            System.out.println(results.get(i));
        }
    }
}
