package algorithm;

import java.math.BigInteger;
import java.util.Random;

/**
 * RabinKarp 算法进行字符串匹配
 * @author qlx
 * @date 2020/6/1 17:17
 */
public class RabinKarp {

    /**
     * 模式字符串
     */
    private String pattern;

    /**
     * 字符集的大小
     */
    private int m;

    /**
     * 用来取余的素数
     */
    private long q;

    /**
     * m的len-1次方，len是模式字符串的长度
     */
    private long mLen = 1;

    /**
     * 模式串的hashcode
     */
    private long patternHashCode;

    /**
     * 模式串的长度
     */
    private int len;

    public RabinKarp(String pattern) {
        this.pattern = pattern;
        // 128表示ASCII码的范围
        m = 128;
        q = longPrime();
        len = pattern.length();

        for (int i = 0; i < len - 1; i++) {
            mLen = (mLen * m) % q;
        }

        // 计算模式串的hashcode
        patternHashCode = hash(pattern, len);
    }

    public int indexOf(String target) {
        int l = target.length();
        if (l < pattern.length()) {return -1;}
        long targetHashCode = hash(target, len);
        if (targetHashCode == patternHashCode && isSame(target, 0)) {
            return 0;
        }

        for (int i = len; i < l; i++) {
            targetHashCode = (targetHashCode + q - (target.charAt(i - len) * mLen) % q) % q;
            targetHashCode = (targetHashCode * m + target.charAt(i)) % q;
            if (targetHashCode == patternHashCode && isSame(target, i - len + 1)) {
                return i - len + 1;
            }
        }

        return -1;
    }

    /**
     * 再次检查是否一致
     * @param target
     * @param start
     * @return
     */
    private boolean isSame(String target, int start) {
        return pattern.equals(target.substring(start, start + len));
    }


    /**
     * 计算初始的hashcode
     * @param str
     * @param l
     * @return
     */
    private long hash(String str, int l) {
        long ans = 0;
        for (int i = 0; i < l; i++) {
            ans = (ans * m + str.charAt(i)) % q;
        }
        return ans;
    }

    /**
     * 获取一个大的素数
     * @return
     */
    private long longPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
    }
}
