package hot100;

import structs.Trie;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @author qian
 * @date 2020/1/14 15:41
 */
public class num208 {
   public static void main(String[] args) {
       Trie trie = new Trie();

       trie.insert("apple");
       System.out.println(trie.search("apple"));
       System.out.println(trie.search("app"));
       System.out.println(trie.startsWith("app"));
       trie.insert("app");
       System.out.println(trie.search("app"));
   }
}
