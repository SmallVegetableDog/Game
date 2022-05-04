package dp;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * <p>
 * "aabcbcbcaccbcaabc"
 * ".*a*aa*.*b*.c*.*a*"
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 */
public class Num10 {

    public static void main(String[] args) {
        Num10 num10 = new Num10();
        System.out.println(num10.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));
    }

    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()][p.length()];
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        //base case
        if (i == s.length() && j == p.length()) {
            return true;
        } else if (i == s.length()) { //s串匹配完，判断p串能否匹配空串（即p的形式类似于a*b*c*）
            int pl = p.length();
            if ((pl - j) % 2 == 1) {
                return false;
            }
            while (j + 1 < pl) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
                j = j + 2;
            }
            return true;
        } else if (i >= s.length() || j >= p.length()) {
            return false;
        }
        //解决重复子问题
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        char c = s.charAt(i), c2 = p.charAt(j);
        boolean res;
        if (c == c2 || c2 == '.') {
            //aaa  a*   aaa b*aaa
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            //aaa  b*   aaa b*aaa
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        memo[i][j] = res;
        return res;
    }
}
