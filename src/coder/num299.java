package coder;

/**
 * https://leetcode-cn.com/problems/bulls-and-cows/
 */
public class num299 {
    public String getHint(String secret, String guess) {
        int bulls, cows, len, i, index;
        bulls = cows = 0;
        for (i = 0, len = secret.length(); i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                secret = replaceCharAt(secret, i, null);
                guess = replaceCharAt(guess, i, "#");
                bulls++;
            }
        }

        for (i = 0, len = secret.length(); i < len; i++) {
            index = secret.indexOf(guess.charAt(i));
            if (index == -1) {
                continue;
            }
            secret = replaceCharAt(secret, index, null);
            cows++;
        }

        return bulls + "A" + cows + "B";
    }

    public String replaceCharAt(String s, int pos, String placeholder) {
        if (placeholder == null) {
            placeholder = "%";
        }
        return s.substring(0, pos) + placeholder + s.substring(pos + 1);
    }

    public String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public static void main(String[] args) {
        System.out.println(new num299().getHint("11", "10"));
    }
}
