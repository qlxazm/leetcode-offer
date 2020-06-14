package hot100;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/word-break-ii/
 * @author qian
 * @date 2020/1/29 21:59
 */
public class num140 {

    /*方法1：带有备忘录的回溯算法*/
   /* private HashMap<String, Boolean> map = new HashMap<>();
    private HashMap<Integer, List<String>> buffer = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            map.put(word, true);
        }
        return wordBreak(s, 0, s.length() - 1);
    }

    private List<String> wordBreak(String s, int start, final int L) {

        if(buffer.containsKey(start)) {return buffer.get(start);}

        List<String> ans = new ArrayList<>();

        for (int i = start; i <= L; i++) {
            String word = s.substring(start, i + 1);
            if (map.containsKey(word)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                if (i < L) {
                    list = wordBreak(s, i + 1, L);
                    if (!list.isEmpty()) {
                        list = list.stream().map(sentence -> word + " " + sentence).collect(Collectors.toList());
                    }
                }
                ans.addAll(list);
            }
        }

        buffer.put(start, ans);
        return ans;
    }*/

    /**
     * 动态规划法
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        HashMap<String, Boolean> dictMap = new HashMap<>();
        HashMap<Integer, List<String>> dp = new HashMap<>();
        for (String word : wordDict) { dictMap.put(word, true);}

        final int L = s.length();
        // 初始化
        List<String> tempList = new ArrayList<>();
        tempList.add("");
        dp.put(0, tempList);

        for (int i = 1; i <= L; i++) {
            tempList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp.get(j).size() > 0 && dictMap.containsKey(word)) {
                    for (String sentence : dp.get(j)) {
                        tempList.add(sentence.equals("") ? word : sentence + " " + word);
                    }
                }
            }
            dp.put(i, tempList);
        }

        return dp.get(L);
    }



    private HashMap<Integer, List<String>> buffer = new HashMap<>();
    public List<String> wordBreak1(String s, List<String> wordDict) {
        return wordBreak1(s, 0, s.length() - 1, new HashSet<String>(wordDict));
    }

    public List<String> wordBreak1(String s, int start, int L, Set<String> set) {
        List<String> ans = new ArrayList<>();

        if (buffer.get(start) != null) {
            return buffer.get(start);
        }

        for (int i = start; i <= L; i++) {
            String word = s.substring(start, i + 1);
            if (set.contains(word)) {
                List<String> sentenceList = wordBreak1(s, i + 1, L, set);
                if (sentenceList.size() == 0) {
                    if (i == L) { ans.add(word); }
                } else {
                    for (String str : sentenceList) {
                        ans.add(word + " " + str);
                    }
                }
            }
        }

        buffer.put(start, ans);

        return ans;
    }


    public List<String> wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        LinkedList<String>[] dp = new LinkedList[len + 1];

        // 初始化
        LinkedList<String> init = new LinkedList<>();
        init.add("");
        dp[0] = init;

        for (int i = 1; i <= len; i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j].size() > 0 && set.contains(word)) {
                    for (String str : dp[j]) {
                        list.add((str.equals("") ? "" : str + " ") + word);
                    }
                }
            }
            dp[i] = list;
        }
        return dp[len];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        String s = "catsanddog";

        num140 a = new num140();

        for (String ans : a.wordBreak2(s, wordDict)) {
            System.out.println(ans);
        }
    }
}
