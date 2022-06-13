package 动态规划;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Num5 {

    int begin, end;

    int[][] memo;

    public static void main(String[] args) {
        Num5 num5 = new Num5();
        System.out.println(num5.longestPalindrome("abbcbb"));
    }

    public String longestPalindrome(String s) {
        memo = new int[s.length()][s.length()];
        dp(s.toCharArray(), 0, s.length() - 1);
        return s.substring(begin, end + 1);
    }

    /**
     * 去掉前后两个数后仍是一个回文串
     *
     * @param toCharArray
     * @param i
     * @param j
     * @return
     */
    private boolean dp(char[] toCharArray, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (memo[i][j] == 1) {
            return true;
        } else if (memo[i][j] == -1) {
            return false;
        }
        boolean flag = false;
        if (toCharArray[i] == toCharArray[j] && dp(toCharArray, i + 1, j - 1)) {
            if (end - begin < j - i) {
                begin = i;
                end = j;
            }
            flag = true;
        } else {
            if (dp(toCharArray, i, j - 1)) {
                if (end - begin < j - i - 1) {
                    begin = i;
                    end = j - 1;
                }
            } else if (dp(toCharArray, i + 1, j)) {
                if (end - begin < j - i - 1) {
                    begin = i + 1;
                    end = j;
                }
            }
        }
        memo[i][j] = flag ? 1 : -1;
        return flag;
    }
}
