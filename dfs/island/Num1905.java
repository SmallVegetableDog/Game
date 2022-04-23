package dfs.island;

/**
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * <p>
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * <p>
 * 请你返回 grid2 中 子岛屿 的 数目 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * 输出：3
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * 输出：2
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
 * <p>
 * 链接：https://leetcode-cn.com/problems/count-sub-islands
 */
public class Num1905 {

    public static void main(String[] args) {
        Num1905 num1905 = new Num1905();
        int[][] grids1 = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grids2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(num1905.countSubIslands(grids1, grids2));
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        /**
         * 先把grid2为1但是grid1为0的岛屿淹了
         */
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(i, j, grid2);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    count++;
                    dfs(i, j, grid2);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] grid2) {
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length) {
            return;
        }
        if (grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        dfs(i - 1, j, grid2);
        dfs(i + 1, j, grid2);
        dfs(i, j - 1, grid2);
        dfs(i, j + 1, grid2);
    }
}
