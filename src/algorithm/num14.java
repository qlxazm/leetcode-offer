package algorithm;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class num14 {

    class TrieNode {
        int preffix;
        int count;
        TrieNode[] nextNodes = new TrieNode[26];
    }

    class Trie{
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            char[] charArray = s.toCharArray();
            TrieNode root = this.root;
            for (int i = 0, len = charArray.length; i < len; i++) {
                char c = charArray[i];
                if (root.nextNodes[c - 'a'] == null) {
                    root.nextNodes[c - 'a'] = new TrieNode();
                }
                root = root.nextNodes[c - 'a'];
                root.preffix++;

                // 判断
                if (root.preffix >= count) {
                    count = root.preffix;
                    preffix = s.substring(0, i + 1);
                }
            }
            root.count++;
        }

    }

    private String preffix = "";
    private int count = 0;

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String s : strs) {
            trie.insert(s);
        }
        return count == strs.length ? preffix : "";
    }


    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        num14 num14 = new num14();
        System.out.println(num14.longestCommonPrefix(strs));
    }
}
