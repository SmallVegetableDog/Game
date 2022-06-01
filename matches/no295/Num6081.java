package matches.no295;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 6081. 到达角落需要移除障碍物的最小数目 显示英文描述
 * 通过的用户数217
 * 尝试过的用户数291
 * 用户总通过次数220
 * 用户总提交次数388
 * 题目难度Hard
 * 给你一个下标从 0 开始的二维整数数组 grid ，数组大小为 m x n 。每个单元格都是两个值之一：
 * <p>
 * 0 表示一个 空 单元格，
 * 1 表示一个可以移除的 障碍物 。
 * 你可以向上、下、左、右移动，从一个空单元格移动到另一个空单元格。
 * <p>
 * 现在你需要从左上角 (0, 0) 移动到右下角 (m - 1, n - 1) ，返回需要移除的障碍物的 最小 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,1],[1,1,0],[1,1,0]]
 * 输出：2
 * 解释：可以移除位于 (0, 1) 和 (0, 2) 的障碍物来创建从 (0, 0) 到 (2, 2) 的路径。
 * 可以证明我们至少需要移除两个障碍物，所以返回 2 。
 * 注意，可能存在其他方式来移除 2 个障碍物，创建出可行的路径。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
 * 输出：0
 * 解释：不移除任何障碍物就能从 (0, 0) 到 (2, 4) ，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * grid[i][j] 为 0 或 1
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */
public class Num6081 {

    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 1, 1}, {1, 1, 0}, {1, 1, 0}
//        };
//        int[][] grid = {
//                {0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}
//        };

        int[][] grid = {
                {0, 0, 1, 1, 1, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 1, 1}, {1, 1, 0, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 1, 1, 1, 1, 0, 0, 1, 1}, {1, 0, 1, 0, 0, 0, 1, 1, 1, 0}
        };
        Num6081 num6081 = new Num6081();
        System.out.println(num6081.minimumObstacles(grid));
    }


    public int minimumObstacles(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{0, 0, grid[0][0]});
        visited[0][0] = 1;
        int m = grid.length;
        int n = grid[0].length;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int val = poll[2];
            if (x == m - 1 && y == n - 1) {
                return val;
            }
            addQueue(x - 1, y, visited, queue, grid, val);
            addQueue(x + 1, y, visited, queue, grid, val);
            addQueue(x, y - 1, visited, queue, grid, val);
            addQueue(x, y + 1, visited, queue, grid, val);
        }
        return 0;
    }

    private void addQueue(int x, int y, int[][] visited, PriorityQueue<int[]> queue, int[][] grid, int preVal) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m) {
            return;
        }
        if (y < 0 || y >= n) {
            return;
        }
        if (visited[x][y] == 1) {
            return;
        }
        visited[x][y] = 1;
        queue.add(new int[]{x, y, preVal + grid[x][y]});
    }
}
