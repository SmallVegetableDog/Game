package matches.no290;

import java.util.HashSet;

/**
 * 2249. 统计圆内格点数目 显示英文描述
 * 通过的用户数2961
 * 尝试过的用户数3703
 * 用户总通过次数3069
 * 用户总提交次数6884
 * 题目难度Medium
 * 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
 * <p>
 * 注意：
 * <p>
 * 格点 是指整数坐标对应的点。
 * 圆周上的点 也被视为出现在圆内的点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：circles = [[2,2,1]]
 * 输出：5
 * 解释：
 * 给定的圆如上图所示。
 * 出现在圆内的格点为 (1, 2)、(2, 1)、(2, 2)、(2, 3) 和 (3, 2)，在图中用绿色标识。
 * 像 (1, 1) 和 (1, 3) 这样用红色标识的点，并未出现在圆内。
 * 因此，出现在至少一个圆内的格点数目是 5 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：circles = [[2,2,2],[3,4,1]]
 * 输出：16
 * 解释：
 * 给定的圆如上图所示。
 * 共有 16 个格点出现在至少一个圆内。
 * 其中部分点的坐标是 (0, 2)、(2, 0)、(2, 4)、(3, 2) 和 (4, 4) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= circles.length <= 200
 * circles[i].length == 3
 * 1 <= xi, yi <= 100
 * 1 <= ri <= min(xi, yi)
 */
public class Num2249 {

    public int count = 0;

    public static void main(String[] args) {
        Num2249 num2249 = new Num2249();
//        int[][] circles = {{2, 2, 2}, {2, 2, 1}};

        int[][] circles = {
                {8, 9, 6}, {9, 8, 4}, {4, 1, 1}, {8, 5, 1}, {7, 1, 1}, {6, 7, 5}, {7, 1, 1}, {7, 1, 1}, {5, 5, 3}
        };
        System.out.println(num2249.countLatticePoints(circles));
    }

    public int countLatticePoints(int[][] circles) {
        HashSet<String> pointSet = new HashSet<>();
        for (int[] circle : circles) {
            getPointFromCircle(circle, pointSet);
        }
        return pointSet.size();
    }

    private void getPointFromCircle(int[] circle, HashSet<String> pointSet) {
        int x = circle[0], y = circle[1], r = circle[2];
        for (int i = x - r; i <= x + r; i++) {
            for (int j = y - r; j <= y + r; j++) {
                if (validPoint(i, j, r, x, y)) {
                    pointSet.add(i + "," + j);
                }
            }
        }
    }

    private boolean validPoint(int i, int j, int r, int x, int y) {
        return (Math.abs(i - x) * Math.abs(i - x) + Math.abs(j - y) * Math.abs(j - y)) <= r * r;
    }
}
