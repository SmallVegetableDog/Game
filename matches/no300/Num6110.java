package matches.no300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 6110. 网格图中递增路径的数目 显示英文描述
 * 通过的用户数813
 * 尝试过的用户数1248
 * 用户总通过次数871
 * 用户总提交次数2105
 * 题目难度Hard
 * 给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。
 * <p>
 * 请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。由于答案可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * 如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1],[3,4]]
 * 输出：8
 * 解释：严格递增路径包括：
 * - 长度为 1 的路径：[1]，[1]，[3]，[4] 。
 * - 长度为 2 的路径：[1 -> 3]，[1 -> 4]，[3 -> 4] 。
 * - 长度为 3 的路径：[1 -> 3 -> 4] 。
 * 路径数目为 4 + 3 + 1 = 8 。
 * 示例 2：
 * <p>
 * 输入：grid = [[1],[2]]
 * 输出：3
 * 解释：严格递增路径包括：
 * - 长度为 1 的路径：[1]，[2] 。
 * - 长度为 2 的路径：[1 -> 2] 。
 * 路径数目为 2 + 1 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 */
public class Num6110 {
    //[[12469,18741,68716,30594,65029,44019,92944,84784,92781,5655,43120,81333,54113,88220,23446,6129,2904,48677,20506,79604,82841,3938,46511,60870,10825,31759,78612,19776,43160,86915,74498,38366,28228,23687,40729,42613,61154,22726,51028,45603,53586,44657,97573,61067,27187,4619,6135,24668,69634,24564,30255,51939,67573,87012,4106,76312,28737,7704,35798]]

    public static void main(String[] args) {
        Num6110 num6110 = new Num6110();
        int[][] grid = new int[][]{{1, 1}, {3, 4}};
        num6110.countPaths(grid);
        System.out.println();
    }

    long count;

    long DIV = 1000000000 + 7;

    Integer[][] memo;


    //记忆化搜索 dfs
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, m, n, grid, Integer.MIN_VALUE);
            }
        }
        return (int) count;
    }

    private long dfs(int i, int j, int m, int n, int[][] grid, int preVal) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (grid[i][j] <= preVal) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        long w = dfs(i - 1, j, m, n, grid, grid[i][j]);
        long s = dfs(i + 1, j, m, n, grid, grid[i][j]);
        long a = dfs(i, j - 1, m, n, grid, grid[i][j]);
        long d = dfs(i, j + 1, m, n, grid, grid[i][j]);
//        count = (count + 1 + ((((w + s) % DIV + a) % DIV) + d) % DIV) % DIV;
        memo[i][j] = (int) ((w + s + a + d + 1) % DIV);
        count = (count + memo[i][j]) % DIV;
        return memo[i][j];
    }


}
