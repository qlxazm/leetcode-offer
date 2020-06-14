package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class num17 {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {return result;}

        addLetter(result, digits.charAt(0), "");

        for (int i = 1, len = digits.length(); i < len; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0, len1 = result.size(); j < len1; j++) {
                addLetter(temp, digits.charAt(i), result.get(j));
            }
            result = temp;
        }

        return result;
    }

    private void addLetter(List<String> list, char digit, String s) {
        if (digit == '2'){
            list.add(s + "a");
            list.add(s + "b");
            list.add(s + "c");
        }else if (digit == '3') {
            list.add(s + "d");
            list.add(s + "e");
            list.add(s + "f");
        }else if (digit == '4') {
            list.add(s + "g");
            list.add(s + "h");
            list.add(s + "i");

        }else if (digit == '5') {
            list.add(s + "j");
            list.add(s + "k");
            list.add(s + "l");

        }else if (digit == '6') {
            list.add(s + "m");
            list.add(s + "o");
            list.add(s + "n");

        }else if (digit == '7') {
            list.add(s + "p");
            list.add(s + "q");
            list.add(s + "r");
            list.add(s + "s");

        }else if (digit == '8') {
            list.add(s + "t");
            list.add(s + "u");
            list.add(s + "v");

        }else if (digit == '9') {
            list.add(s + "w");
            list.add(s + "x");
            list.add(s + "y");
            list.add(s + "z");
        }
    }

    public static void main(String[] args) {
        num17 a = new num17();
        String s = "23";
        List<String> result = a.letterCombinations(s);

        for (int i = 0, len = result.size(); i < len; i++) {
            System.out.println(result.get(i));
        }
    }
}
