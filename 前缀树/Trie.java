package 前缀树;


/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }

    private Trie[] tries;

    boolean end;


    public Trie() {
        tries = new Trie[26];
        end = false;
    }

    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            if (trie.tries[num] != null) {
                trie = trie.tries[num];
            } else {
                trie.tries[num] = new Trie();
                trie = trie.tries[num];
            }
            if (i == word.length() - 1) {
                trie.end = true;
            }
        }
    }


    public boolean search(String word) {
        Trie children = this;
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            if (children.tries[num] == null) {
                return false;
            } else {
                children = children.tries[num];
                if (i == word.length() - 1 && children.end) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie[] children = tries;
        for (int i = 0; i < prefix.length(); i++) {
            int num = prefix.charAt(i) - 'a';
            if (children[num] == null) {
                return false;
            } else {
                children = children[num].tries;
            }
        }
        return true;
    }


}
