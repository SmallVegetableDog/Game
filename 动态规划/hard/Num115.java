package 动态规划.hard;

/**
 * 115. 不同的子序列
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 */
public class Num115 {

    public static void main(String[] args) {
        Num115 num115 = new Num115();
        System.out.println(num115.numDistinct("ddd", "dd"));
    }

    Integer[][] memo;

    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return dp(s, 0, t, 0);
    }

    /**
     * dp函数定义：s[i...]的子序列t[j..]出现的次数
     *
     * @param s
     * @param i
     * @param t
     * @param j
     * @return
     */
//    private int dp(String s, int i, String t, int j) {
//        //以t的视角描述状态转移方程
//        if (j == t.length()) {
//            return 1;
//        }
//        if (i == s.length()) {
//            return 0;
//        }
//        if (memo[i][j] != null) {
//            return memo[i][j];
//        }
//        int sum = 0;
//        for (int ii = i; ii < s.length(); ii++) {
//            if (s.charAt(ii) == t.charAt(j)) {
//                sum = sum + dp(s, ii + 1, t, j + 1);
//            }
//        }
//        memo[i][j] = sum;
//        return sum;
//    }

    /**
     * dp函数定义：s[i...]的子序列t[j..]出现的次数
     *
     * @param s
     * @param i
     * @param t
     * @param j
     * @return
     */
    private int dp(String s, int i, String t, int j) {
        //以s的视角描述状态转移方程
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int sum;
        if (s.charAt(i) == t.charAt(j)) {
            sum = dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        } else {
            sum = dp(s, i + 1, t, j);
        }
        memo[i][j] = sum;
        return sum;
    }
}
