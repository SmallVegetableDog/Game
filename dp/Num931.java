package dp;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * 示例 1：
 * 输入：matrix = [[2,1,3],
 * [6,5,4],
 * [7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 */
public class Num931 {

    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;

        int[][] result = matrix.clone();

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int val1 = getMatrixValue(i - 1, j - 1, len, matrix, result[i][j]);
                int val2 = getMatrixValue(i - 1, j, len, matrix, result[i][j]);
                int val3 = getMatrixValue(i - 1, j + 1, len, matrix, result[i][j]);
                result[i][j] = Math.min(val1, (Math.min(val2, val3)));
            }
        }
        int val = result[len - 1][0];
        for (int i = 1; i < len; i++) {
            if (val > result[len - 1][i]) {
                val = result[len - 1][i];
            }
        }
        return val;
    }

    private int getMatrixValue(int i, int j, int len, int[][] matrix, int self) {
        if (i < 0 || j < 0 || i >= len || j >= len) {
            return Integer.MAX_VALUE;
        }
        return matrix[i][j] + self;
    }
}
