package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * <p>
 * 每步 可以删除任意一个字符串中的一个字符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 * <p>
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * <p>
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 */
public class Num583 {

    public static void main(String[] args) {
        Num583 num583 = new Num583();
        System.out.println(num583.minDistance("leetcode", "etco"));
    }


    Map<String, Integer> memo;

    public int minDistance(String word1, String word2) {
        memo = new HashMap<>(word1.length() + word2.length());
        return dp(word1, 0, word2, 0);
    }

    private int dp(String word1, int i, String word2, int j) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        String str = word1.substring(i) + word2.substring(j);
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int res = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = dp(word1, i + 1, word2, j + 1);
        } else {
            res = Math.min(dp(word1, i + 1, word2, j), dp(word1, i, word2, j + 1)) + 1;
        }
        memo.put(str, res);
        return res;
    }
}
