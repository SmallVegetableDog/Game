package dp.hard;

/**
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * 示例 2：
 * <p>
 * 输入：k = 2, n = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：k = 3, n = 14
 * 输出：4
 * <p>
 * 提示：
 * 1 <= k <= 100
 * 1 <= n <= 104
 * 链接：https://leetcode.cn/problems/super-egg-drop
 */
public class Num887 {
    public static void main(String[] args) {
        Num887 num887 = new Num887();
        System.out.println(num887.superEggDrop(2, 6));
    }

    Integer[][] memo;

    int superEggDrop(int k, int n) {
        memo = new Integer[k][n];
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        if (memo[k-1][n-1] != null) {
            return memo[k-1][n-1];
        }
        int lo = 1, hi = n;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            //单调递增
            int x1 = dp(k - 1, mid - 1);
            //单调递增
            int x2 = dp(k, n - mid);
            //求出mid满足x1<=x2的最大值
            if (x1 < x2) {
                lo = mid;
            } else if (x1 > x2) {
                hi = mid;
            } else {
                lo = hi = mid;
            }
        }
//        int res = 1 + Math.max(dp(k - 1, lo - 1), dp(k, n - lo));
        int res = 1 + Math.max(dp(k - 1, hi - 1), dp(k, n - hi));

        memo[k-1][n-1] = res;
        return res;
    }
}














