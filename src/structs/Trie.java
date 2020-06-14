package structs;

/**
 * 前缀树用于检索字符串集中的键。
 * 前缀树可以完成哈希表不能够完成的任务
 * 1、找到具有同一前缀的全部键值
 * 2、按照字典序枚举字符串的数据集
 * @author yd
 * @date 2020/1/14 15:43
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        // 建立前缀树的根节点
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        char[] charArray = word.toCharArray();

        // 从根节点开始插入
        TrieNode root = this.root;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (root.nextNodes[c - 'a'] == null) {
                root.nextNodes[c - 'a'] = new TrieNode();
            }
            root = root.nextNodes[c - 'a'];
            root.prefix++;
        }
        root.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchPrefix(word) > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) >= 0;
    }

    private int searchPrefix(String s) {
        char[] charArray = s.toCharArray();
        TrieNode root = this.root;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (root.nextNodes[c - 'a'] == null) {
                return -1;
            }
            root = root.nextNodes[c - 'a'];
        }
        return root.count;
    }

    static class TrieNode{
        /**
         * 以该节点为前缀的单词个数
         */
        int prefix;
        /**
         * 以该节点结尾的单词的个数
         *
         * 这个属性可以作为一个指示器，如果为0说明这只是一个前缀，否则，这就是一个完整的单词
         */
        int count;

        /**
         * 子节点，这个数组的大小是字母表中字母的数量，这里采用的是小写字母，所以是26
         */
        TrieNode[] nextNodes = new TrieNode[26];
    }
}
