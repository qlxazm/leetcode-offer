package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yd
 * @date 2020/3/2 11:24
 */
public class num212 {

    private int rows;
    private int columns;
    private boolean[][] visited;
    private Set<String> ans = new HashSet<>();
    /**
     * 前缀树根节点
     */
    private TrieNode root = new TrieNode("");

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        columns = board[0].length;
        visited = new boolean[rows][columns];

        // 建立前缀树
        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dfs(board, i, j, root);
            }
        }

        return new ArrayList<>(ans);
    }

    /**
     * 深度优先遍历
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j, TrieNode p) {
        //范围检查
        if (i < 0 || i >= rows || j < 0 || j >= columns || visited[i][j]) {
            if (p.count > 0) {
                ans.add(p.val);
            }
            return;
        }

        //置访问标志
        visited[i][j] = true;
        TrieNode node = p.childrens[board[i][j] - 'a'];

        if (node == null) {
            if (p.count > 0) {
                ans.add(p.val);
            }
            visited[i][j] = false;
            return;
        }

        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i + 1, j, node);
        dfs(board, i, j - 1, node);
        visited[i][j] = false;
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = root;
        for (int i = 0, len = charArray.length; i < len; i++) {
            char c = charArray[i];
            if (p.childrens[c - 'a'] == null) {
                p.childrens[c - 'a'] = new TrieNode(new String(charArray, 0, i + 1));
            }
            p = p.childrens[c - 'a'];
            p.prefix++;
        }
        p.count++;
    }

    class TrieNode {
        String val;
        int prefix;
        int count;
        TrieNode[] childrens = new TrieNode[26];

        public TrieNode(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

       /* char[][] board = {
                {'a'}
        };
        String[] words = {"a"};*/

        num212 a = new num212();
        for(String word : a.findWords(board, words)) {
            System.out.println(word);
        }
    }
}
