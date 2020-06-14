package hot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class num139 {

    private byte[][] matrix;
    private boolean isArrived = false;

    private void dfs(int source, int destination) {
        for (int i = 0, len = matrix[source].length; i < len; i++) {
            if (matrix[source][i] == 0) {continue;}
            if (i == destination) {
                isArrived = true;
                return;
            }
            dfs(i, destination);
        }
    }

/*
    方法1：暴力解决法 会超时
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreak(String s, HashSet<String> wordDict, int begin) {
        if (begin == s.length()) {return true;}
        for (int end = begin + 1, len = s.length(); end <= len; end++){
            if (wordDict.contains(s.substring(begin, end)) && wordBreak(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }*/

    /**
     * buffer中元素如果为0代表未计算，1代表可以切分成字典中的单词， 2代表不可以切分成字典中的单词
     */
   /* private Boolean[] buffer;
    *//**
     *  方法2：优化暴力解决方法，缓存中间结果
     * @param s
     * @param wordDict
     * @return
     *//*
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        buffer = new Boolean[len + 1];
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreak(String s, HashSet<String> wordDict, int begin) {
        if (begin == s.length()) {
            return buffer[begin] = true;
        }
        for (int end = begin + 1, len = s.length(); end <= len; end++){
            if (wordDict.contains(s.substring(begin, end))) {
                if ((buffer[end] == null && wordBreak(s, wordDict, end)) || buffer[end]){
                    return buffer[begin] = true;
                }
            }
        }
        return buffer[begin] = false;
    }*/


    /**
     *  方法3：动态规划，缓存中间结果
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        // 初始化
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--){
            for (int j = i + 1; j <= len; j++) {
                if (dp[j] && set.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }





   /* public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {return true;}
        boolean result = false;
        for (int i = 0, len = wordDict.size(); i < len; i++) {
            String pattern = wordDict.get(i);
            int index = s.indexOf(pattern);
            if (index == -1) {continue;}
            result = wordBreak(s.substring(0, index), wordDict) && wordBreak(s.substring(index + pattern.length()), wordDict);
            if (result) {return true;}
        }
        return result;
    }*/

   public boolean wordBreak1(String s, List<String> wordDict) {
       HashMap<String, Boolean> map = new HashMap<>();
       wordDict.forEach(word -> map.put(word, true));

       int len = s.length();
       boolean[] dp = new boolean[len + 1];
       dp[len] = true;
       for (int i = len - 1; i >= 0; i--) {
           for (int j = i; j < len; j++) {
                String word = s.substring(i, j + 1);
                if (dp[i] = map.get(word) != null && dp[j + 1]) {break;}
           }
       }
       return dp[0];
   }

    public static void main(String[] args) {
        /*String s = "leetcode";
        String pattern = "leet";
        int index = s.indexOf(pattern);
        String subStr = s.substring(0, index) + s.substring(index + pattern.length());
        System.out.println(index + " 子字符串 " + subStr);*/

        num139 a = new num139();

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("code");
        wordDict.add("leet");


       /* String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");*/

       /* String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");*/

       /* String s = "ccbb";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("bc");
        wordDict.add("cb");*/

        /*String s = "a";
        List<String> wordDict = new ArrayList<>();*/

       /* String s = "abcd";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");*/

        /*String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");*/

        System.out.println(a.wordBreak1(s, wordDict));
    }
}
