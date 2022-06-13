package 动态规划;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 */
public class Num64 {
    Integer[][] memo;

    public int minPathSum(int[][] grid) {
        memo = new Integer[grid.length][grid[0].length];
        return dp(grid, grid.length - 1, grid[0].length - 1);

    }

    /**
     * 从0，0走到i，j的最小路径和
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dp(int[][] grid, int i, int j) {
        //base case
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        //base case
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        //剪枝
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = Math.min(dp(grid, i, j - 1), dp(grid, i - 1, j)) + grid[i][j];
        memo[i][j] = res;
        return res;
    }
}
