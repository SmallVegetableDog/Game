package matches.no292;

/**
 * 一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。
 * <p>
 * 字符串是 () 。
 * 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。
 * 字符串可以表示为 (A) ，其中 A 是合法括号序列。
 * 给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径：
 * <p>
 * 路径开始于左上角格子 (0, 0) 。
 * 路径结束于右下角格子 (m - 1, n - 1) 。
 * 路径每次只会向 下 或者向 右 移动。
 * 路径经过的格子组成的括号字符串是 合法 的。
 * 如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
 * 输出：true
 * 解释：上图展示了两条路径，它们都是合法括号字符串路径。
 * 第一条路径得到的合法字符串是 "()(())" 。
 * 第二条路径得到的合法字符串是 "((()))" 。
 * 注意可能有其他的合法括号字符串路径。
 * <p>
 * 示例 2：
 * 输入：grid = [[")",")"],["(","("]]
 * 输出：false
 * 解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 要么是 '(' ，要么是 ')' 。
 * <p>
 * 链接：https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path
 */
public class Num2267 {

    public static void main(String[] args) {
        char[][] chars = {{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}};
        Num2267 num2267 = new Num2267();
        System.out.println(num2267.hasValidPath(chars));
    }

    Boolean[][][] memo;

    public boolean hasValidPath(char[][] chars) {
        int m = chars.length;
        int n = chars[0].length;
        memo = new Boolean[m][n][m + n];
        if ((m + n) % 2 == 0) {
            return false;
        }
        return dp(0, 0, 0, chars);
    }

    /**
     * 当前状态status
     * 能否从i，j走到终点右下角
     *
     * @param i
     * @param j
     * @param status 碰到'(' 减一   碰到')'加一 status为负数说明不能走到终点
     * @param chars
     * @return
     */
    private boolean dp(int i, int j, int status, char[][] chars) {
        int m = chars.length;
        int n = chars[0].length;
        if (i >= m || j >= n) {
            return false;
        }
        if (memo[i][j][status] != null) {
            return memo[i][j][status];
        }
        int nowStatus = chars[i][j] == '(' ? 1 : -1;
        status = nowStatus + status;
        if (status < 0) {
            return false;
        }
        //base case
        if (i == m - 1 && j == n - 1) {
            return status == 0;
        }
        boolean res = dp(i + 1, j, status, chars) || dp(i, j + 1, status, chars);
        memo[i][j][status-nowStatus] = res;
        return res;
    }
}
