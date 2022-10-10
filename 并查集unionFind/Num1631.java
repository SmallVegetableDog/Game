package 并查集unionFind;

/**
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */
public class Num1631 {

    public static void main(String[] args) {
        Num1631 num1631 = new Num1631();
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(num1631.minimumEffortPath(heights));
    }

    Integer[][] memo;

    int rows;

    int cols;

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        memo = new Integer[rows][cols];
        this.rows = rows;
        this.cols = cols;
        return dfs(heights, rows - 1, cols - 1);
    }

    private int dfs(int[][] heights, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i >= rows || i < 0 || j >= cols || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int w = dfs(heights, i - 1, j);
        int s = dfs(heights, i + 1, j);
        int a = dfs(heights, i, j - 1);
        int d = dfs(heights, i, j + 1);
        if (w != Integer.MAX_VALUE) {
            w = Math.max(w, Math.abs(heights[i][j] - heights[i - 1][j]));
        }
        if (s != Integer.MAX_VALUE) {
            s = Math.max(s, Math.abs(heights[i][j] - heights[i + 1][j]));
        }
        if (a != Integer.MAX_VALUE) {
            a = Math.max(a, Math.abs(heights[i][j] - heights[i][j - 1]));
        }
        if (d != Integer.MAX_VALUE) {
            d = Math.max(d, Math.abs(heights[i][j] - heights[i][j + 1]));
        }
        int val = w;
        val = Math.min(val, s);
        val = Math.min(val, a);
        val = Math.min(val, d);
        return val;
    }
}
