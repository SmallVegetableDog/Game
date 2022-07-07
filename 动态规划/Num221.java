package 动态规划;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class Num221 {

    int max_len = 0;

    int m;

    int n;

    public int maximalSquare(char[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    doMaximalSquare(i, j, dp);
                }
            }
        }
        return max_len;
    }

    private void doMaximalSquare(int i, int j, int[][] dp) {
        int m1 = 0, m2 = 0, m3 = 0;
        if (valid(i - 1, j - 1)) {
            m1 = dp[i - 1][j - 1];
        }
        if (valid(i - 1, j)) {
            m2 = dp[i - 1][j];
        }
        if (valid(i, j - 1)) {
            m3 = dp[i][j - 1];
        }
        int len = Math.min(m1, Math.min(m2, m3)) + 1;
        dp[i][j] = len;
        max_len = Math.max(max_len, len * len);
    }

    private boolean valid(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        return true;
    }
}
