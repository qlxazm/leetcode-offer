package hot100;

/**
 * @author yd
 * @date 2020/3/2 14:54
 */
public class num344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }

}
