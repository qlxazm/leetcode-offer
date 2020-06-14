package hot100;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * @author qian
 * @date 2020/1/27 16:58
 */
public class num127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);


        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String s = pair.getKey();
            // 寻找s可以转换到的字符串
            for (int i = 0; i < L; i++) {
                String newWord = s.substring(0, i) + '*' + s.substring(i + 1, L);
                ArrayList<String> transformations = allComboDict.get(newWord);
                if (transformations == null) {continue;}
                for (String word : transformations) {
                    if (word.equals(s) || visited.contains(word)) { continue;}
                    if (word.equals(endWord)) { return pair.getValue() + 1;}

                    visited.add(word);
                    queue.offer(new Pair<>(word, pair.getValue() + 1));
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        wordList.add("cog");

        num127 a = new num127();

        System.out.println(a.ladderLength(beginWord, endWord, wordList));


    }
}
