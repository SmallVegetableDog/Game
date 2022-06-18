package 回溯;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。 
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * <p>
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 */
public class Num518 {

    public static void main(String[] args) {
        Num518 num518 = new Num518();
        int change = num518.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }

    int count = 0;

    public int change(int amount, int[] coins) {
        backTrack(0, amount, coins, 0);
        return count;
    }

    private void backTrack(int start, int target, int[] coins, int sum) {
        if (sum == target) {
            count++;
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < coins.length; i++) {
            backTrack(i, target, coins, sum + coins[i]);
        }
    }
}
