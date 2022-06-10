package 动态规划;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 */
public class Num1143 {

    public static void main(String[] args) {
        Num1143 num1143 = new Num1143();
        System.out.println(num1143.longestCommonSubsequence("abcde", "ace"));
    }

    Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return dp(text1, 0, text2, 0);
    }

    private int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            res = dp(text1, i + 1, text2, j + 1) + 1;
        } else {
            int val1 = dp(text1, i + 1, text2, j);
            int val2 = dp(text1, i, text2, j + 1);
            int val3 = dp(text1, i + 1, text2, j + 1);
            res = Math.max(val1, Math.max(val2, val3));
        }
        memo[i][j] = res;
        return res;
    }
}
